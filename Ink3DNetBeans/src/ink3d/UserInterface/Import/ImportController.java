/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Import;

import ink3d.UserInterface.Database.PersistenceFramework;
import ink3d.UserInterface.MainMenu.BadFieldException;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class ImportController {
    private PersistenceFramework db = PersistenceFramework.getDB();
    public ArrayList<String> getStlFiles(){
        return db.getStlFiles();
    }
    
    public Boolean importStl(String Path){
        return db.importStlFile(Path);
    }
    
    public Boolean deleteStl(String name) throws BadFieldException{
        if(name == null || name =="")throw new BadFieldException("Please select a file to delete");
        return db.deleteStlFile(name);
    }
}
