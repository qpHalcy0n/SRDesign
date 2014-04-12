/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Import;

import ink3d.UserInterface.Database.PersistenceFramework;
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
    
    public Boolean deleteStl(String name){
        return db.deleteStlFile(name);
    }
}
