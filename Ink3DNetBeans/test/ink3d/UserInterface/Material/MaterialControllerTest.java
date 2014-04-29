/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Material;

import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author time9_000
 */
public class MaterialControllerTest {
    
    private PersistenceFramework db;
    
    @Before
    public void setUp() {
        db = PersistenceFramework.getDB();
    }

    /**
     * Test of getMaterialConfigurations method, of class MaterialController.
     */
    @Test
    public void testGetMaterialConfigurations() {
        System.out.println("getMaterialConfigurations");
        MaterialController instance = new MaterialController();
        ArrayList<String> expected = db.getMaterialConfigurations();
        ArrayList<String> result = instance.getMaterialConfigurations();
        assertEquals(expected, result);
    }

    /**
     * Test of deleteMaterialConfiguration method, of class MaterialController.
     */
    @Test
    public void testDeleteMaterialConfiguration() throws Exception {
        System.out.println("deleteMaterialConfiguration");
        String name = "Material Controller Delete Test";
        MaterialController instance = new MaterialController();
        MaterialConfiguration material = new MaterialConfiguration();
        material.setName(name);
        db.saveMaterialConfiguration(material);
        boolean result = instance.deleteMaterialConfiguration(name);
        Assert.assertTrue(result);
    }

    /**
     * Test of loadMaterialConfiguration method, of class MaterialController.
     */
    @Test
    public void testLoadMaterialConfiguration() throws Exception {
        System.out.println("loadMaterialConfiguration");
        String name = "Material Controller Load Test";
        MaterialController instance = new MaterialController();
        MaterialConfiguration material = new MaterialConfiguration();
        material.setName(name);
        db.saveMaterialConfiguration(material);
        ArrayList<String> result = instance.loadMaterialConfiguration(name);
        assertNotNull(result);
        assertTrue(result.size() > 0);

        // clean up
        db.deleteMaterialConfiguration(name);
    }

    /**
     * Test of saveMaterialConfiguration method, of class MaterialController.
     */
    @Test
    public void testSaveMaterialConfiguration() throws Exception {
        System.out.println("saveMaterialConfiguration");
        MaterialConfiguration material = new MaterialConfiguration();
        String name = "Material Controller Save Test";
        ArrayList<String> varList = new ArrayList<>();
        varList.add(name);
        varList.add(Double.toString(material.getFilamentDiameter()));
        varList.add(Double.toString(material.getExtrusionMultiplier()));
        
        varList.add(Integer.toString(material.getFirstLayerExtrusionTemperature()));
        varList.add(Integer.toString(material.getExtrusionTemperature()));
        
        varList.add(Double.toString(material.getRetractionLength()));
        varList.add(Double.toString(material.getRetractionLiftZ()));
        varList.add(Integer.toString(material.getRetractionSpeed()));
        varList.add(Double.toString(material.getExtraLengthAfterRetraction()));
        varList.add(Double.toString(material.getMinimumTravelAfterRetraction()));
        varList.add(Boolean.toString(material.isRetractOnLayerChange()));
        varList.add(Boolean.toString(material.isWipeBeforeRetract()));
        
        varList.add(Double.toString(material.getRetractionLengthBeforeToolChange()));
        varList.add(Double.toString(material.getExtraLengthOnToolReenable()));
        
        varList.add(material.getgCodeStart());
        varList.add(material.getgCodeEnd());
        MaterialController instance = new MaterialController();
        Boolean result = instance.saveMaterialConfiguration(varList);
        assertTrue(result);

        // clean up
        db.deleteMaterialConfiguration(name);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
