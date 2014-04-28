/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrintConfig;

import ink3d.ConfigurationObjects.PrintConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import ink3d.UserInterface.MainMenu.BadFieldException;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author time9_000
 */
public class PrintControllerTest {
	private PersistenceFramework db;
    private PrintController pc;
    private String PRINT_CONFIG_DIR = (new File("").getAbsolutePath()) + "/Database/Prints/";

	@Before
	public void initialize() {
		db = PersistenceFramework.getDB();
        pc = new PrintController();
	}
    
	@Test
	public void testLoadPrintConfigurationList() {
		List<String> actualList = pc.loadPrintConfigurationList();
		List<String> expectedList = db.getPrintConfigurations();
		for(int i = 0; i < expectedList.size(); i++) {
		    boolean equals = expectedList.get(i).equals(actualList.get(i));
		    Assert.assertTrue("Actual list must match expected list.", equals);
		}
	}

	@Test
	public void testLoadPrintConfiguration() {
		List<String> printNames = pc.loadPrintConfigurationList();
		for(String name : printNames) {
			PrintConfiguration expected = db.getPrintConfiguration(name);
			PrintConfiguration actual = pc.loadPrintConfiguration(name);
            Assert.assertEquals(expected, actual);
		}
	}
    
    @Test
    public void testSavePrintConfiguration() {
        String printName = "Print Controller Save Test";
        PrintConfiguration print = new PrintConfiguration();
        print.setName(printName);
        try {
            pc.savePrintConfiguration(print);
        } catch (BadFieldException ex) {
            Logger.getLogger(PrintControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        PrintConfiguration actual = db.getPrintConfiguration(printName);
        db.deletePrintConfiguration(printName);
        Assert.assertEquals(print, actual);
    }

    @Test
    public void testDeletePrintConfiguration() {
        String printName = "Print Controller Delete Test";
        PrintConfiguration print = new PrintConfiguration();
        print.setName(printName);
        db.savePrintConfiguration(print);
        pc.deletePrintConfiguration(printName);

        File f = new File(PRINT_CONFIG_DIR + printName + ".xml");
        Assert.assertFalse(f.exists());
    }
}
