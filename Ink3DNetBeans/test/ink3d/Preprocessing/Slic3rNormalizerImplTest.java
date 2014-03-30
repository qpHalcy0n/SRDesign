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
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Tim
 */
public class Slic3rNormalizerImplTest {
    private static String TEST_FILE_DIR = File.separator + "test-files" + File.separator + "stl" + File.separator;
    
    // TODO:  Clean up openscad, stl, amf files (if they exist) before tests
    
    @Test
    public void testSubsectionFiles() {
        String basePath = new File("").getAbsolutePath();
        String stlFilePath = basePath + TEST_FILE_DIR + "Feed-Housing.STL";
        String materialName = "PLA";
        double bottomZ_0 = 0.0;
        double topZ_0 = 7.0;
        double bottomZ_1 = 7.0;
        double topZ_1 = 22.0;

        // Build Print Job Config
        MaterialConfiguration materialConfig = new MaterialConfiguration();
        materialConfig.setName(materialName);

        // Create two file configs that have the same parent STL file.

        // This file config is placed in subset 0
        FileConfiguration fileConfig_0 = new FileConfiguration();
        fileConfig_0.setParentSTLFile(new File(stlFilePath));
        fileConfig_0.setMaterialConfiguration(materialConfig);

        // This file config is placed in subset 1
        FileConfiguration fileConfig_1 = new FileConfiguration();
        fileConfig_1.setParentSTLFile(new File(stlFilePath));
        fileConfig_1.setMaterialConfiguration(materialConfig);

        // Initialize subset 0
        SubsetConfiguration subset_0 = new SubsetConfiguration();
        subset_0.setBottomZ(bottomZ_0);
        subset_0.setTopZ(topZ_0);
        subset_0.getFileConfigurations().add(fileConfig_0);

        // Initialize subset 1
        SubsetConfiguration subset_1 = new SubsetConfiguration();
        subset_1.setBottomZ(bottomZ_1);
        subset_1.setTopZ(topZ_1);
        subset_1.getFileConfigurations().add(fileConfig_1);

        // Initialize the print job config object
        PrintJobConfiguration printJob = new PrintJobConfiguration();
        printJob.getSubsetConfigurationList().add(subset_0);
        printJob.getSubsetConfigurationList().add(subset_1);

        Slic3rNormalizerImpl normalizer = new Slic3rNormalizerImpl();
        normalizer.subsectionFiles(printJob);

        // Run the test to make sure not subset stl file references are null.
        int subsetNum = 0;
        for(SubsetConfiguration sub : printJob.getSubsetConfigurationList()) {
            int fileConfigNum = 0;
            for(FileConfiguration fileConfig : sub.getFileConfigurations()) {
                Assert.assertNotNull("Subsection STL file reference must not be null. (Subset " 
                    + subsetNum + "; FileConfig " + fileConfigNum + ")", fileConfig.getSubsetSTL());
                fileConfigNum++;
            }
            subsetNum++;
        }
    }

    @Test
    public void testTranslateFiles() {
        String basePath = new File("").getAbsolutePath();
        String stlFilePath_0 = basePath + File.separator + "test-files" + File.separator
                + "file-translation" + File.separator + "stl" 
                + File.separator + "Feed-Housing-sub0.stl";
        String stlFilePath_1 = basePath + File.separator + "test-files" + File.separator  
                + "file-translation" + File.separator + "stl" 
                + File.separator + "Feed-Housing-sub1.stl";
        String materialName = "PLA";

        // Build Print Job Config
        MaterialConfiguration materialConfig = new MaterialConfiguration();
        materialConfig.setName(materialName);

        FileConfiguration fileConfig_0 = new FileConfiguration();
        fileConfig_0.setExtruderNum(0);
        fileConfig_0.setSubsetSTL(new File(stlFilePath_0));
        fileConfig_0.setMaterialConfiguration(materialConfig);

        FileConfiguration fileConfig_1 = new FileConfiguration();
        fileConfig_1.setExtruderNum(0);
        fileConfig_1.setSubsetSTL(new File(stlFilePath_0));
        fileConfig_1.setMaterialConfiguration(materialConfig);

        SubsetConfiguration subset_0 = new SubsetConfiguration();
        subset_0.getFileConfigurations().add(fileConfig_0);

        SubsetConfiguration subset_1 = new SubsetConfiguration();
        subset_1.getFileConfigurations().add(fileConfig_1);

        PrintJobConfiguration printJob = new PrintJobConfiguration();
        printJob.setName("File Translation Test");
        printJob.getSubsetConfigurationList().add(subset_0);
        printJob.getSubsetConfigurationList().add(subset_1);

        Slic3rNormalizerImpl normalizer = new Slic3rNormalizerImpl();
        normalizer.translateFiles(printJob);
        
        int count = 0;
        for(SubsetConfiguration sub : printJob.getSubsetConfigurationList()) {
            Assert.assertNotNull("AMF file reference must not be null. (Subset " + count + ")", sub.getAmfFile());
            count++;
        }
        
    }
}
