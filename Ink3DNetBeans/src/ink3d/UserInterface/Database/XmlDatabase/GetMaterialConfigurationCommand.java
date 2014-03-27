/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.UserInterface.Database.CommandStructure;
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
public class GetMaterialConfigurationCommand extends CommandStructure{
    String name;
    private static String path = "./Database/Materials/";
    private static String extention =".xml";
    
    public GetMaterialConfigurationCommand(String name){
        this.name = name;
    }
    @Override
    public void execute() {
        try {
            JAXBContext jc = JAXBContext.newInstance(MaterialConfiguration.class);
 
            StreamSource xml = new StreamSource(path+name+extention);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<MaterialConfiguration> je1 = unmarshaller.unmarshal(xml, MaterialConfiguration.class);
            result = je1.getValue();
        }catch (JAXBException ex) {
            Logger.getLogger(GetMaterialConfigurationCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
