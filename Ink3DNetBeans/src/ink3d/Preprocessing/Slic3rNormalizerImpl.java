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
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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

	@Override
	public boolean normalize(PrintJobConfiguration printJobConfiguration) {
        return translateFiles(printJobConfiguration);
	}

    private boolean subsectionFiles(PrintJobConfiguration printJobConfiguration) {


        return true;
    }

	private boolean translateFiles(PrintJobConfiguration printJobConfiguration) {
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
