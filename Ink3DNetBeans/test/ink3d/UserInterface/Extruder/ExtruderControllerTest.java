/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Extruder;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import java.io.File;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author time9_000
 */
public class ExtruderControllerTest {

	private PersistenceFramework db;
    private static String EXTRUDER_DIR = new File("").getAbsolutePath() + "/Database/Extruders/";

	@Before
	public void initialize() {
		db = PersistenceFramework.getDB();
	}
    
	@Test
	public void testLoadExtruderConfigurationList() {
		ExtruderController ec = new ExtruderController();
		List<String> actualList = ec.loadExtruderConfigurationList();
		List<String> expectedList = db.getExtruderConfigurations();
		for(int i = 0; i < expectedList.size(); i++) {
		    boolean equals = expectedList.get(i).equals(actualList.get(i));
		    Assert.assertTrue("Actual list must match expected list.", equals);
		}
	}

	@Test
	public void testLoadExtruderConfiguration() {
		ExtruderController ec = new ExtruderController();
		List<String> extruderNames = ec.loadExtruderConfigurationList();
		for(String name : extruderNames) {
			ExtruderConfiguration expected = db.getExtruderConfiguration(name);
			ExtruderConfiguration actual = ec.loadExtruderConfiguration(name);
			Assert.assertTrue("Actual extruder must match expected extruder.", expected.equals(actual));
		}
	}
    
    @Test
    public void testSaveExtruderConfiguration() {
        String extruderName = "Extruder Controller Save Test";
        ExtruderController ec = new ExtruderController();
        ExtruderConfiguration extruder = new ExtruderConfiguration();
        extruder.setName(extruderName);
        ec.saveExtruderConfiguration(extruder);
        ExtruderConfiguration actual = db.getExtruderConfiguration(extruderName);
        db.deleteExtruderConfiguration(extruderName);
        Assert.assertEquals(extruder, actual);
    }

    @Test
    public void testDeleteExtruderConfiguration() {
        String extruderName = "Extruder Controller Delete Test";
        ExtruderConfiguration extruder = new ExtruderConfiguration();
        extruder.setName(extruderName);
        db.saveExtruderConfiguration(extruder);
        ExtruderController ec = new ExtruderController();
        ec.deleteExtruderConfiguration(extruderName);

        File f = new File(EXTRUDER_DIR + extruderName + ".xml");
        Assert.assertFalse(f.exists());
    }
		
}
