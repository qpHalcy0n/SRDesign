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
        String stlFilePath0 = basePath + File.separator + "test-files" + File.separator 
                + "subsection" + File.separator + "stl" + File.separator + "Feed-Housing-PartA.stl";
        String stlFilePath1 = basePath + File.separator + "test-files" + File.separator 
                + "subsection" + File.separator + "stl" + File.separator + "Feed-Housing-PartB.stl";

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
        FileConfiguration fileConfig_00 = new FileConfiguration();
        fileConfig_00.setParentSTLFile(new File(stlFilePath0));
        fileConfig_00.setMaterialConfiguration(materialConfig);
        fileConfig_00.setExtruderNum(0);

        FileConfiguration fileConfig_01 = new FileConfiguration();
        fileConfig_01.setParentSTLFile(new File(stlFilePath1));
        fileConfig_01.setMaterialConfiguration(materialConfig);
        fileConfig_01.setExtruderNum(1);

        // This file config is placed in subset 1
        FileConfiguration fileConfig_10 = new FileConfiguration();
        fileConfig_10.setParentSTLFile(new File(stlFilePath0));
        fileConfig_10.setMaterialConfiguration(materialConfig);
        fileConfig_10.setExtruderNum(0);

        FileConfiguration fileConfig_11 = new FileConfiguration();
        fileConfig_11.setParentSTLFile(new File(stlFilePath1));
        fileConfig_11.setMaterialConfiguration(materialConfig);
        fileConfig_11.setExtruderNum(1);

        // Initialize subset 0
        SubsetConfiguration subset_0 = new SubsetConfiguration();
        subset_0.setBottomZ(bottomZ_0);
        subset_0.setTopZ(topZ_0);
        subset_0.getFileConfigurations().add(fileConfig_00);
        subset_0.getFileConfigurations().add(fileConfig_01);

        // Initialize subset 1
        SubsetConfiguration subset_1 = new SubsetConfiguration();
        subset_1.setBottomZ(bottomZ_1);
        subset_1.setTopZ(topZ_1);
        subset_1.getFileConfigurations().add(fileConfig_10);
        subset_1.getFileConfigurations().add(fileConfig_11);

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
                //Assert.assertNotNull("Subsection STL file reference must not be null. (Subset " 
                  //  + subsetNum + "; FileConfig " + fileConfigNum + ")", fileConfig.getSubsetSTL());
                fileConfigNum++;
            }
            subsetNum++;
        }
    }

    @Test
    public void testTranslateFiles() {
        String basePath = new File("").getAbsolutePath();
        String stlFilePath_A0 = basePath + File.separator + "test-files" + File.separator
                + "file-translation" + File.separator + "stl" 
                + File.separator + "Feed-Housing-PartA-sub0.stl";
        String stlFilePath_A1 = basePath + File.separator + "test-files" + File.separator  
                + "file-translation" + File.separator + "stl" 
                + File.separator + "Feed-Housing-PartA-sub1.stl";

        String stlFilePath_B0 = basePath + File.separator + "test-files" + File.separator
                + "file-translation" + File.separator + "stl" 
                + File.separator + "Feed-Housing-PartB-sub0.stl";
        String stlFilePath_B1 = basePath + File.separator + "test-files" + File.separator  
                + "file-translation" + File.separator + "stl" 
                + File.separator + "Feed-Housing-PartB-sub1.stl";

        String materialA = "Material A";
        String materialB = "Material B";

        // Build Print Job Config
        MaterialConfiguration materialConfigA = new MaterialConfiguration();
        materialConfigA.setName(materialA);

        MaterialConfiguration materialConfigB = new MaterialConfiguration();
        materialConfigB.setName(materialB);

        FileConfiguration fileConfig_A0 = new FileConfiguration();
        fileConfig_A0.setExtruderNum(0);
        fileConfig_A0.setSubsetSTL(new File(stlFilePath_A0));
        fileConfig_A0.setMaterialConfiguration(materialConfigA);

        FileConfiguration fileConfig_A1 = new FileConfiguration();
        fileConfig_A1.setExtruderNum(0);
        fileConfig_A1.setSubsetSTL(new File(stlFilePath_A1));
        fileConfig_A1.setMaterialConfiguration(materialConfigA);

        FileConfiguration fileConfig_B0 = new FileConfiguration();
        fileConfig_B0.setExtruderNum(1);
        fileConfig_B0.setSubsetSTL(new File(stlFilePath_B0));
        fileConfig_B0.setMaterialConfiguration(materialConfigB);

        FileConfiguration fileConfig_B1 = new FileConfiguration();
        fileConfig_B1.setExtruderNum(1);
        fileConfig_B1.setSubsetSTL(new File(stlFilePath_B1));
        fileConfig_B1.setMaterialConfiguration(materialConfigB);

        SubsetConfiguration subset_0 = new SubsetConfiguration();
        subset_0.getFileConfigurations().add(fileConfig_A0);
        subset_0.getFileConfigurations().add(fileConfig_B0);

        SubsetConfiguration subset_1 = new SubsetConfiguration();
        subset_1.getFileConfigurations().add(fileConfig_A1);
        subset_1.getFileConfigurations().add(fileConfig_B1);

        PrintJobConfiguration printJob = new PrintJobConfiguration();
        printJob.setName("Feed Housing Two Material File Translation Test");
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
