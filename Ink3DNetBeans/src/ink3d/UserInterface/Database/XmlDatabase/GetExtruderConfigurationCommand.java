/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.UserInterface.Database.CommandStructure;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author daniellain
 */
public class GetExtruderConfigurationCommand extends CommandStructure {
    String name;
    private static String path = "./Database/Extruders/";
    private static String extention =".xml";
    
    public GetExtruderConfigurationCommand(String name){
        this.name = name;
    }
    @Override
    public void execute() {
        File file = new File(path+name+extention);
        try {
            JAXBContext jc = JAXBContext.newInstance(ExtruderConfiguration.class);
 
            StreamSource xml = new StreamSource(path+name+extention);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<ExtruderConfiguration> je1 = unmarshaller.unmarshal(xml, ExtruderConfiguration.class);
            result = je1.getValue();
        }catch (JAXBException ex) {
            Logger.getLogger(GetExtruderConfigurationCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
