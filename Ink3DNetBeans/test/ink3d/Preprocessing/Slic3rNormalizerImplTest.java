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
    private static String STL_FILE_DIR = File.separator + "test-files" + File.separator + "stl" + File.separator;

    @Test
    public void testTranslateFiles() {
        String basePath = new File("").getAbsolutePath();
        String stlFilePath = basePath + STL_FILE_DIR + "20mm-Basic-Cube-Solid.STL";
        String materialName = "PLA";

        // Build Print Job Config
        MaterialConfiguration materialConfig = new MaterialConfiguration();
        materialConfig.setName(materialName);
        FileConfiguration fileConfig = new FileConfiguration();
        fileConfig.setSubsetSTL(new File(stlFilePath));
        fileConfig.setMaterialConfiguration(materialConfig);
        SubsetConfiguration subset = new SubsetConfiguration();
        subset.getFileConfigurations().add(fileConfig);
        PrintJobConfiguration printJob = new PrintJobConfiguration();
        printJob.getSubsetConfigurationList().add(subset);

        Normalizer normalizer = new Slic3rNormalizerImpl();
        normalizer.normalize(printJob);
        
        int count = 0;
        for(SubsetConfiguration sub : printJob.getSubsetConfigurationList()) {
            Assert.assertNotNull("AMF file reference must not be null. (Subset " + count + ")", sub.getAmfFile());
            count++;
        }
        
    }
}
