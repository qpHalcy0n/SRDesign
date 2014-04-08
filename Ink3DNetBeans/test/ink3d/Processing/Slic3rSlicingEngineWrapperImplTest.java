/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Processing;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.SubsetConfiguration;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Tim
 */
public class Slic3rSlicingEngineWrapperImplTest {
    private static final String PRINT_JOB_NAME = "Slic3r Slicing Engine Wrapper Test";
    private static final String GCODE_DIR = Slic3rSlicingEngineWrapperImpl.GCODE_DIR;
    private PrintJobConfiguration printJobConfiguration;

    @BeforeClass
    public static void clean() {
        // Delete old test files
        List<String> filenames = new ArrayList<>();
        filenames.add(GCODE_DIR + File.separator + PRINT_JOB_NAME + File.separator + "sub0.gcode");
        filenames.add(GCODE_DIR + File.separator + PRINT_JOB_NAME + File.separator + "sub1.gcode");

        // Delete test print job dirs
        filenames.add(GCODE_DIR + File.separator + PRINT_JOB_NAME);

        for(String filename : filenames) {
            File file = new File(filename);
            try {
                if(file.delete()) {
                    System.out.println("Deleted " + filename);
                }
                else {
                    System.out.println("Failed to delete " + filename);
                }
            }
            catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Before
    public void initialize() {
        String baseDir = new File("").getAbsolutePath();
        String amfDir = baseDir + File.separator + "test-files" + File.separator + "generate-g-code" + File.separator + "amf";
        String subset0AmfFilename = amfDir + File.separator + "sub0.amf";
        String subset1AmfFilename = amfDir + File.separator + "sub1.amf";

        printJobConfiguration = new PrintJobConfiguration();
        printJobConfiguration.setName(PRINT_JOB_NAME);
        printJobConfiguration.getPrinterConfiguration().getExtruderList().add(new ExtruderConfiguration());
        printJobConfiguration.getPrinterConfiguration().getExtruderList().add(new ExtruderConfiguration());
        printJobConfiguration.getExtruderMaterials().add(new MaterialConfiguration());
        printJobConfiguration.getExtruderMaterials().add(new MaterialConfiguration());
        
        SubsetConfiguration subset0 = new SubsetConfiguration();
        subset0.setAmfFile(new File(subset0AmfFilename));
        subset0.setBottomZ(0.0);

        SubsetConfiguration subset1 = new SubsetConfiguration();
        subset1.setAmfFile(new File(subset1AmfFilename));
        subset1.setBottomZ(7.0);

        printJobConfiguration.getSubsetConfigurationList().add(subset0);
        printJobConfiguration.getSubsetConfigurationList().add(subset1);

    }

    @Test
    public void testGenerateGCode() {
        System.out.println(printJobConfiguration);
        Slic3rSlicingEngineWrapperImpl slicingEngine = new Slic3rSlicingEngineWrapperImpl();
        boolean success = false;
        try {
            success = slicingEngine.generateGCode(printJobConfiguration);
        } catch (ProcessorException ex) {
            Logger.getLogger(Slic3rSlicingEngineWrapperImplTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }

        Assert.assertTrue("Generate G Code must succeed.", success);

        List<SubsetConfiguration> subsets = printJobConfiguration.getSubsetConfigurationList();
        for(SubsetConfiguration subset : subsets) {
            Assert.assertNotNull(subset.getgCodeFile());
        }
    }
}
