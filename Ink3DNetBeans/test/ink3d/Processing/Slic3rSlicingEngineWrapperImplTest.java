/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Processing;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.FileConfiguration;
import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.SubsetConfiguration;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Tim
 */
public class Slic3rSlicingEngineWrapperImplTest {
    private PrintJobConfiguration printJobConfiguration;

    @Before
    public void initialize() {
        String baseDir = new File("").getAbsolutePath();
        String amfDir = baseDir + File.separator + "test-files" + File.separator + "generate-g-code" + File.separator + "amf";
        String subset0AmfFilename = amfDir + File.separator + "sub0.amf";
        String subset1AmfFilename = amfDir + File.separator + "sub1.amf";

        printJobConfiguration = new PrintJobConfiguration();
        printJobConfiguration.setName("G-Code Generator Test");
        printJobConfiguration.getPrinterConfiguration().getExtruderList().add(new ExtruderConfiguration());
        printJobConfiguration.getExtruderMaterials().add(new MaterialConfiguration());
        
        FileConfiguration fileConfig = new FileConfiguration();
        fileConfig.setMaterialConfiguration(new MaterialConfiguration());
        fileConfig.setExtruderConfiguration(new ExtruderConfiguration());
        fileConfig.setExtruderNum(0);

        SubsetConfiguration subset0 = new SubsetConfiguration();
        subset0.setAmfFile(new File(subset0AmfFilename));
        subset0.getFileConfigurations().add(fileConfig);

        SubsetConfiguration subset1 = new SubsetConfiguration();
        subset1.setAmfFile(new File(subset1AmfFilename));
        subset1.getFileConfigurations().add(fileConfig);

        printJobConfiguration.getSubsetConfigurationList().add(subset0);
        printJobConfiguration.getSubsetConfigurationList().add(subset1);

    }

    @Test
    public void testGenerateGCode() {
        System.out.println(printJobConfiguration);
        Slic3rSlicingEngineWrapperImpl slicingEngine = new Slic3rSlicingEngineWrapperImpl();
        slicingEngine.generateGCode(printJobConfiguration);
    }
}
