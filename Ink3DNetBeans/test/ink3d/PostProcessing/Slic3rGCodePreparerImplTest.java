/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PostProcessing;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrinterConfiguration;
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
public class Slic3rGCodePreparerImplTest {
    private PrintJobConfiguration printJob;
    private static final String PRINT_JOB_NAME = "GCode Preparer Test";
    private static final String BASE_DIR = new File("").getAbsolutePath();

    @BeforeClass
    public static void clean() {
        File finalizedGCodeFile = new File(BASE_DIR + File.separator + "gcode" + File.separator + "GCode Preparer Test.gcode");
        finalizedGCodeFile.delete();
    }

    @Before
    public void initialize() {
        PrinterConfiguration printerConfig = new PrinterConfiguration();
        printerConfig.setStartGCode("; printer start code here");
        printerConfig.setEndGCode("; printer end gcode here");
         
        ExtruderConfiguration extruder0 = new ExtruderConfiguration();
        extruder0.setStartGCode("; T4 start gcode here");
        extruder0.setEndGCode("; T4 end gcode here");

        ExtruderConfiguration extruder1 = new ExtruderConfiguration();
        extruder1.setStartGCode("; T5 start gcode here");
        extruder1.setEndGCode("; T5 end gcode here");

        List<ExtruderConfiguration> extruders = new ArrayList<>();
        extruders.add(new ExtruderConfiguration());
        extruders.add(new ExtruderConfiguration());
        extruders.add(new ExtruderConfiguration());
        extruders.add(new ExtruderConfiguration());
        extruders.add(extruder0);
        extruders.add(extruder1);

        printerConfig.setExtruderList(extruders);

        File subsetFile0 = new File(BASE_DIR + File.separator + "test-files" 
                + File.separator + "g-code-preparer" + File.separator 
                + "gcode" + File.separator + "sub0.gcode");

        File subsetFile1 = new File(BASE_DIR + File.separator + "test-files" 
                + File.separator + "g-code-preparer" + File.separator 
                + "gcode" + File.separator + "sub1.gcode");
        List<Integer> extrudersNeeded = new ArrayList<>();
        extrudersNeeded.add(4);
        extrudersNeeded.add(5);
        SubsetConfiguration subset0 = new SubsetConfiguration();
        subset0.setgCodeFile(subsetFile0);
        subset0.setExtrudersNeeded(extrudersNeeded);
        SubsetConfiguration subset1 = new SubsetConfiguration();
        subset1.setgCodeFile(subsetFile1);
        subset1.setExtrudersNeeded(extrudersNeeded);

        List<SubsetConfiguration> subsets = new ArrayList<>();
        subsets.add(subset0);
        subsets.add(subset1);

        this.printJob = new PrintJobConfiguration();
        this.printJob.setName(PRINT_JOB_NAME);
        this.printJob.setPrinterConfiguration(printerConfig);
        this.printJob.setSubsetConfigurationList(subsets);
    }

    @Test
    public void testGCodePreparer() {
        GCodePreparer preparer = new Slic3rGCodePreparerImpl();
        boolean success = false;
        try {
            success = preparer.prepareGCode(this.printJob);
        }
        catch (PostProcessorException ex) {
            Logger.getLogger(Slic3rGCodePreparerImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Assert.assertNotNull(this.printJob.getFinalizedGCode());
        Assert.assertTrue(success);
    }
}
