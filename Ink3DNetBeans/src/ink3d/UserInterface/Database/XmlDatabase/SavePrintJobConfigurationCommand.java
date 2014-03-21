/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.PrintJobConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.*;
import javax.xml.namespace.QName;

/**
 *
 * @author daniellain
 */
public class SavePrintJobConfigurationCommand extends ink3d.UserInterface.Database.CommandStructure{
    private PrintJobConfiguration config;
    private static String xmlHeadName = "printjob";
    private static String path = "./PrintJobs";
    private static String extention =".xml";
    
    public SavePrintJobConfigurationCommand(PrintJobConfiguration config){
        this.config = config;
    }
    
   @Override
    public void execute() {
        try {
            File file = new File(path);
            file.mkdir();
            file = new File(path+config.getName()+extention);
            file.createNewFile();
            JAXBContext jc = JAXBContext.newInstance(PrintJobConfiguration.class);
            JAXBElement<PrintJobConfiguration> je = new JAXBElement<PrintJobConfiguration>(new QName(xmlHeadName), PrintJobConfiguration.class, config);
            Marshaller marshaller = jc.createMarshaller();
            OutputStream os = new FileOutputStream( path+config.getName()+extention );
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(je, os);
            result = Boolean.TRUE;
        } catch (JAXBException ex) {
            Logger.getLogger(SaveExtruderConfigurationCommand.class.getName()).log(Level.SEVERE, null, ex);
            result = Boolean.FALSE;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveExtruderConfigurationCommand.class.getName()).log(Level.SEVERE, null, ex);
            result = Boolean.FALSE;
        } catch (IOException ex) {
            Logger.getLogger(SaveExtruderConfigurationCommand.class.getName()).log(Level.SEVERE, null, ex);
            result = Boolean.FALSE;
        }
    }
    
}
