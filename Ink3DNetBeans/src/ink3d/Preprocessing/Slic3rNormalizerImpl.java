/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Preprocessing;

import ink3d.ConfigurationObjects.FileConfiguration;
import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.SubsetConfiguration;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.j3d.loaders.InvalidFormatException;
import org.j3d.loaders.stl.STLFileReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Tim
 */
public class Slic3rNormalizerImpl implements Normalizer {
    private static final String AMF_TAG = "amf";
    private static final String MATERIAL_TAG = "material";
    private static final String METADATA_TAG = "metadata";
    private static final String ID_ATTR = "id";
    private static final String TYPE_ATTR = "type";
    private static final String OBJECT_TAG = "object";
    private static final String MESH_TAG = "mesh";
    private static final String VERTICIES_TAG = "verticies";
    private static final String VERTEX_TAG = "vertex";
    private static final String COORDS_TAG = "coordinates";
    private static final String X_TAG = "x";
    private static final String Y_TAG = "y";
    private static final String Z_TAG = "z";
    private static final String VOLUME_TAG = "volume";
    private static final String MATERIALID_ATTR = "materialid";
    private static final String TRIANGE_TAG = "triangle";
    private static final String NAME_VALUE = "name";
    private static final String OPENSCAD_FILES_DIR = "openscad-files";
    private static final String OPENSCAD_TEMPLATE =
            "intersection(){import(\"%s\");translate([%f,%f,%f]){cube(size=[%f,%f,%f],center=false);};}";
    private static final String OPENSCAD_EXTENSION = ".scad";
    private static final String STL_EXTENSION = ".stl";
    private static final String STL_DIR = "stl-files";
    private static final String OPENSCAD_PATH = "third-party" + File.separator
            + "openscad" + File.separator + "openscad.exe";
    

	@Override
	public boolean normalize(PrintJobConfiguration printJobConfiguration) {
        // Return false if any operation the process fails.
        // Otherwise return true.
        if(!subsectionFiles(printJobConfiguration)) {
            return false;
        }
        if(!translateFiles(printJobConfiguration)) {
            return false;
        }
        return true;
	}

    public boolean subsectionFiles(PrintJobConfiguration printJobConfiguration) {
        List<SubsetConfiguration> subsets = printJobConfiguration.getSubsetConfigurationList();

        // Count used for naming subsection files.
        int subsetNum = 0;
        for(SubsetConfiguration subset : subsets) {
            for(FileConfiguration fileConfig : subset.getFileConfigurations()) {
                try {
                    File parentStlFile = fileConfig.getParentSTLFile();
                    File scadFile = buildScadFile(parentStlFile,
                            subsetNum, subset.getBottomZ(), subset.getTopZ());
                    
                    // build the name of the subset STL file based on parent STL filename and subset number
                    // "<stlDir>/parentStlFilname-subxxx.stl"
                    String subsetStlFilename = createSubsetStlFilename(parentStlFile.getName(), subsetNum);

                    // build directory to store subset STL file
                    File subsetStlDir = new File(subsetStlFilename).getParentFile();
                    if(!subsetStlDir.exists()) {
                        boolean success = subsetStlDir.mkdirs();
                        if(!success) {
                            throw new Exception("Could not create directory for STL files.");
                        }
                    }

                    // execute Open Scad to make subsection
                    String baseDir = new File("").getAbsolutePath();
                    String command = baseDir + File.separator + OPENSCAD_PATH + " -o " + "\"" + subsetStlFilename + "\" \"" + scadFile.getAbsolutePath() + "\"";
                    Process openScadProcess = Runtime.getRuntime().exec(command);
                    // TODO:  Read output/error stream from process to find error messages.
                    //        Problems can occur where Open SCAD cannot subset STL files
                    //        properly (try to Feed Housing from 0-10 10-22).

                    // wait for open scad to finish processing before continuing
                    // TODO:  May want to optimize this in the future.
                    openScadProcess.waitFor();
                    
                    // Create reference to file that Open Scad (should have) created
                    File subsetStlFile = new File(subsetStlFilename);
                    if(subsetStlFile.exists()) {
                        fileConfig.setSubsetSTL(subsetStlFile);
                    }
                    else {
                        // TODO: Create custom exception?
                        // Open Scad didn't create the subset stl file, throw exception
                        throw new Exception("Did not create subsection STL file.");
                    }
                }
                catch (IOException ex) {
                    Logger.getLogger(Slic3rNormalizerImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    return false;
                }
                catch (Exception ex) {
                    Logger.getLogger(Slic3rNormalizerImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    return false;
                }
            }
            // increment the subsection num (for naming open scad and subset stl files)
            subsetNum++;
        }
        return true;
    }

    private File buildScadFile(File parentStl,
            int subsetNum, double zMin, double zMax) throws Exception {
        // Find the xMin, xMax, yMin, yMax of the parent STL file
        // TODO: Optimize
        STLFileReader reader = new STLFileReader(parentStl);
        int[] numFacets = reader.getNumOfFacets();
        if(numFacets[0] < 1) {
            // TODO:  Make custom Exception
            throw new Exception("Cannot create SCAD file for empty STL file.");
        }

        double xMin = Double.POSITIVE_INFINITY;
        double xMax = Double.NEGATIVE_INFINITY;
        double yMin = Double.POSITIVE_INFINITY;
        double yMax = Double.NEGATIVE_INFINITY;

        double[] normal = new double[3];
        double[][] verticies = new double[3][3];
        for(int i = 0; i < numFacets[0]; i++) {
            reader.getNextFacet(normal, verticies);
            for(int j = 0; j < 3; j++) {
                double x = verticies[j][0];
                double y = verticies[j][1];
                if(x < xMin) {
                    xMin = x;
                }
                else if(x > xMax) {
                    xMax = x;
                }
                if(y < yMin) {
                    yMin = y;
                }
                else if(y > yMax) {
                    yMax = y;
                }
            }
        }
        
        File scadFile = new File(createOpenScadFilename(parentStl.getName(), subsetNum));
        // Escape the file separators in the filename string so that they will be
        // escaped in open scad.
        // TODO: Currently hardcoded for windows.
        // This needs to be fixed, but Java does some strange regex stuff with "\"
        String inputFile = parentStl.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
        String scadScript = createOpenScadScriptString(
                inputFile, xMin, xMax, yMin, yMax, zMin, zMax);
        
        // Create Open Scad file and directory
        if(!scadFile.exists()) {
            File scadFileDir = scadFile.getParentFile();
            if(!scadFileDir.exists()) {
                boolean success = scadFileDir.mkdirs();
                if(!success) {
                    throw new Exception("Could not create Open Scad Files");
                }
            }
            scadFile.createNewFile();
        }

        FileWriter fw = new FileWriter(scadFile);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(scadScript);
        bw.close();

        return scadFile;

    }
    
    private String createOpenScadFilename(String parentFilename, int subsetNum) {
        String parentName = parentFilename
                .substring(0, parentFilename.length() - STL_EXTENSION.length());
        String baseDir = new File("").getAbsolutePath();
        return String.format("%s%s%s%s%s-sub%05d%s",
                baseDir,File.separator,OPENSCAD_FILES_DIR,File.separator,parentName,subsetNum,OPENSCAD_EXTENSION);
    }

    private String createSubsetStlFilename(String parentFilename, int subsetNum) {
        String parentName = parentFilename
                .substring(0, parentFilename.length() - STL_EXTENSION.length());
        String baseDir = new File("").getAbsolutePath();
        return String.format("%s%s%s%s%s-sub%05d%s",
                baseDir,File.separator,STL_DIR,File.separator,parentName,subsetNum,STL_EXTENSION);
    }
    
    private String createOpenScadScriptString(String inputFile, double xMin, 
            double xMax, double yMin, double yMax, double zMin, double zMax) {
        double xDistance = xMax - xMin;
        double yDistance = yMax - yMin;
        double height = zMax - zMin;
        return String.format(OPENSCAD_TEMPLATE,
                inputFile,xMin,yMin,zMin,xDistance,yDistance,height);
        
    }

	public boolean translateFiles(PrintJobConfiguration printJobConfiguration) {
        List<SubsetConfiguration> subsets = printJobConfiguration.getSubsetConfigurationList();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Slic3rNormalizerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        for(SubsetConfiguration subset : subsets) {

            // TODO: Sort file config list by extruder position 0,1,2...n
            // or figure out how we're going to do positioning

            List<FileConfiguration> fileConfigs = subset.getFileConfigurations();
            try {
                Document doc = docBuilder.newDocument();
                Element root = doc.createElement(AMF_TAG);

                // Add material data to AMF
                int materialCount = 1;
                for(FileConfiguration fileConfig : fileConfigs) {
                    MaterialConfiguration materialConfig = fileConfig.getMaterialConfiguration();
                    Element materialElement = doc.createElement(MATERIAL_TAG);
                    materialElement.setAttribute(ID_ATTR, String.valueOf(materialCount));
                    root.appendChild(materialElement);

                    Element metadataElement = doc.createElement(METADATA_TAG);
                    metadataElement.setAttribute(TYPE_ATTR, NAME_VALUE);
                    metadataElement.appendChild(doc.createTextNode(materialConfig.getName()));
                    materialElement.appendChild(metadataElement);
                    materialCount++;
                }
                
                // Add geometry data to AMF
                Element objectElement = doc.createElement(OBJECT_TAG);
                Element meshElement = doc.createElement(MESH_TAG);
                Element verticiesElement = doc.createElement(VERTICIES_TAG);
                doc.appendChild(root);
                root.appendChild(objectElement);
                objectElement.appendChild(meshElement);
                meshElement.appendChild(verticiesElement);

                materialCount = 1;
                for(FileConfiguration fileConfig : fileConfigs) {
                    File stlFile = fileConfig.getSubsetSTL();
                    STLFileReader reader = new STLFileReader(stlFile);
                    int[] numFacets = reader.getNumOfFacets();

                    Element volumeElement = doc.createElement(VOLUME_TAG);
                    volumeElement.setAttribute(MATERIALID_ATTR, String.valueOf(materialCount));
                    materialCount++;
                    
                    int vertCount = 0;
                    for(int i = 0; i < numFacets[0]; i++) {
                        Element triangleElement = doc.createElement(TRIANGE_TAG);
                        volumeElement.appendChild(triangleElement);
                        double[] normal = new double[3];
                        double[][] verticies = new double[3][3];
                        reader.getNextFacet(normal, verticies);
                        for(int j = 0; j < 3; j++) {
                            double x = verticies[j][0];
                            double y = verticies[j][1];
                            double z = verticies[j][2];

                            // create XML elements for the verticies of the face
                            Element vertexElement = doc.createElement(VERTEX_TAG);
                            Element coordsElement = doc.createElement(COORDS_TAG);
                            Element xElement = doc.createElement(X_TAG);
                            Element yElement = doc.createElement(Y_TAG);
                            Element zElement = doc.createElement(Z_TAG);
                            xElement.appendChild(doc.createTextNode(String.valueOf(x)));
                            yElement.appendChild(doc.createTextNode(String.valueOf(y)));
                            zElement.appendChild(doc.createTextNode(String.valueOf(z)));
                            coordsElement.appendChild(xElement);
                            coordsElement.appendChild(yElement);
                            coordsElement.appendChild(zElement);
                            vertexElement.appendChild(coordsElement);
                            verticiesElement.appendChild(vertexElement);

                            // this is the number of vertex in the face
                            // i.e. v1, v2, or v3
                            int faceVertexNumber = j + 1;

                            Element vElement = 
                                    doc.createElement("v" + String.valueOf(faceVertexNumber));

                            triangleElement.appendChild(vElement);
                            triangleElement.appendChild(doc.createTextNode(String.valueOf(vertCount)));

                            vertCount++;
                        }
                    }
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                File amfFile = new File("."+File.separator+"sub"+".amf");
                StreamResult result = new StreamResult(amfFile);

                transformer.transform(source, result);

                subset.setAmfFile(amfFile);
                
            }
            catch(Exception ex) {
                Logger.getLogger(Slic3rNormalizerImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
	}
	
}
