/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.PrintConfiguration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.*;
import javax.xml.namespace.QName;

/**
 *
 * @author daniellain
 */
public class SavePrintConfigurationCommand extends ink3d.UserInterface.Database.CommandStructure{
    private PrintConfiguration config;
    private static String xmlHeadName = "print";
    private static String path = "./Database/Prints/";
    private static String extention =".xml";
    
    public SavePrintConfigurationCommand(PrintConfiguration config){
        this.config = config;
    }
    
   @Override
    public void execute() {
        try {
            File file = new File(path);
            file.mkdir();
            file = new File(path+config.getName()+extention);
            file.createNewFile();
            JAXBContext jc = JAXBContext.newInstance(PrintConfiguration.class);
            JAXBElement<PrintConfiguration> je = new JAXBElement<PrintConfiguration>(new QName(xmlHeadName), PrintConfiguration.class, config);
            Marshaller marshaller = jc.createMarshaller();
            OutputStream os = new FileOutputStream( path+config.getName()+extention );
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(je, os);
            file = null;
            os = null;
            System.gc();
            result = Boolean.TRUE;
        } catch (Exception ex) {
            Logger.getLogger(SavePrintConfigurationCommand.class.getName()).log(Level.SEVERE, null, ex);
            result = Boolean.FALSE;
        }
    }
    
}
