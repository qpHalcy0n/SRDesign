/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderMaterialSelection;
import ink3d.ConfigurationObjects.FileSelection;
import ink3d.ConfigurationObjects.PrintJobSelection;
import ink3d.ConfigurationObjects.SubsetSelection;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author daniellain
 */
public class GetPrintJobSelectionsCommandTest {
    PrintJobSelection printJob;
    SavePrintJobSelectionCommand save;
    File file1;
    File file2;
    File file3;
    File file4;
    File file5;
    ArrayList<String> actual;
    ArrayList<String> expected;

    @Before
    public void setUp() {
        
        PrintWriter writer;
        try {
            writer = new PrintWriter("./Database/PrintJobs/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrintJobSelectionsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        SubsetSelection subset1 = new SubsetSelection();
        subset1.setBottomZ(0);
        subset1.setPrintConfiguration("SaveTest.Sub1.Print");
        subset1.setTopZ(1);
        subset1.getFileConfigurations().add(new FileSelection("extruder1", "material1", "file1"));
        subset1.getFileConfigurations().add(new FileSelection("extruder2", "material2", "file2"));
        subset1.getFileConfigurations().add(new FileSelection("extruder3", "material3", "file3"));
        
        SubsetSelection subset2 = new SubsetSelection();
        subset2.setBottomZ(1);
        subset2.setPrintConfiguration("SaveTest.Sub2.Print");
        subset2.setTopZ(2);
        subset2.getFileConfigurations().add(new FileSelection("extruder2", "material2", "file1"));
        subset2.getFileConfigurations().add(new FileSelection("extruder3", "material3", "file2"));
        subset2.getFileConfigurations().add(new FileSelection("extruder1", "material1", "file3"));
        
        printJob = new PrintJobSelection();
        printJob.setName("GetPrintJobsTest1");
        printJob.setPrinterConfiguration("SaveTest.printer");
        printJob.getMaterials().add(new ExtruderMaterialSelection("extruder 1", "material 1"));
        printJob.getMaterials().add(new ExtruderMaterialSelection("extruder 2", "material 1"));
        printJob.getMaterials().add(new ExtruderMaterialSelection("extruder 3", "material 2"));
        printJob.getSubsetConfigurationList().add(subset1);
        printJob.getSubsetConfigurationList().add(subset2);
        
        save = new SavePrintJobSelectionCommand(printJob);
        save.execute();
        
        printJob.setName("GetPrintJobsTest2");
        save = new SavePrintJobSelectionCommand(printJob);
        save.execute();
        
        printJob.setName("GetPrintJobsTest3");
        save = new SavePrintJobSelectionCommand(printJob);
        save.execute();
        
        printJob.setName("GetPrintJobsTest4");
        save = new SavePrintJobSelectionCommand(printJob);
        save.execute();
        
        expected = new ArrayList<>();
        expected.add("GetPrintJobsTest1");
        expected.add("GetPrintJobsTest2");
        expected.add("GetPrintJobsTest3");
        expected.add("GetPrintJobsTest4");
    }
    
    @After
    public void tearDown() {
        file1 = new File("./Database/PrintJobs/GetPrintJobsTest1.xml");
        file2 = new File("./Database/PrintJobs/GetPrintJobsTest2.xml");
        file3 = new File("./Database/PrintJobs/GetPrintJobsTest3.xml");
        file4 = new File("./Database/PrintJobs/GetPrintJobsTest4.xml"); 
        file5 = new File("./Database/PrintJobs/Trash.txt");
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
        }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void GetPrintJobSelectionsTest() throws IOException {
        GetPrintJobSelectionsCommand instance = new GetPrintJobSelectionsCommand();
        instance.execute();
        actual = (ArrayList<String>)instance.getResult();
       
        for(int i = 0; i < actual.size(); i++){
            assertTrue(expected.get(i).equals(actual.get(i)));
        }
    }
    
}