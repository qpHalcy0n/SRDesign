/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.PrintJobSelection;
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
public class GetPrintJobSelectionCommand extends CommandStructure{String name;
    private static String path = "./Database/PrintJobs/";
    private static String extention =".xml";
    
    public GetPrintJobSelectionCommand(String name){
        this.name = name;
    }
    @Override
    public void execute() {
        try {
            JAXBContext jc = JAXBContext.newInstance(PrintJobSelection.class);
 
            StreamSource xml = new StreamSource(path+name+extention);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<PrintJobSelection> je1 = unmarshaller.unmarshal(xml, PrintJobSelection.class);
            result = je1.getValue();
        }catch (JAXBException ex) {
            Logger.getLogger(GetPrintJobSelectionCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}