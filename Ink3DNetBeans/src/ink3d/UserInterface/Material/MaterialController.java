/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Material;

import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import ink3d.UserInterface.MainMenu.BadFieldException;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class MaterialController {
    private PersistenceFramework db = PersistenceFramework.getDB();
    
    public ArrayList<String> getMaterialConfigurations(){
        return db.getMaterialConfigurations();
    }
    
    public Boolean deleteMaterialConfiguration(String name) throws BadFieldException{
        if(name == null || name =="")throw new BadFieldException("Please select a file to delete");
        return db.deleteMaterialConfiguration(name);
    }
    
    public ArrayList<String> loadMaterialConfiguration(String name) throws BadFieldException{
        MaterialConfiguration material;
        if(name == null || name =="")throw new BadFieldException("Please select a file to load");
        material = db.getMaterialConfiguration(name);
        ArrayList<String> varList = new ArrayList<>();
        varList.add(name);
        varList.add(Double.toString(material.getFilamentDiameter()));
        varList.add(Double.toString(material.getExtrusionMultiplier()));
        
        varList.add(Integer.toString(material.getFirstLayerExtrusionTemperature()));
        varList.add(Integer.toString(material.getExtrusionTemperature()));
        
        varList.add(Double.toString(material.getRetractionLength()));
        varList.add(Double.toString(material.getRetractionLiftZ()));
        varList.add(Integer.toString(material.getRetractionSpeed()));
        varList.add(Double.toString(material.getExtraLengthAfterRetraction()));
        varList.add(Double.toString(material.getMinimumTravelAfterRetraction()));
        varList.add(Boolean.toString(material.isRetractOnLayerChange()));
        varList.add(Boolean.toString(material.isWipeBeforeRetract()));
        
        varList.add(Double.toString(material.getRetractionLengthBeforeToolChange()));
        varList.add(Double.toString(material.getExtraLengthOnToolReenable()));
        
        
        //varList.add(material.getgCodeStart());
        //varList.add(material.getgCodeEnd());
        
        return varList;
    }
    
    public Boolean saveMaterialConfiguration(ArrayList<String> vars) throws BadFieldException{
        Double d;
        Integer i;
        int minFan, maxFan;
        MaterialConfiguration config = new MaterialConfiguration();
        try{
            if(vars.get(0).length()>0)config.setName(vars.get(0));
            else {
                throw new BadFieldException("Name must not be empty.");
            }
            try{
                d = new Double(vars.get(1));
                if(d>0) config.setFilamentDiameter(d);
                else {
                    throw new BadFieldException("Filament Diameter must be a double precision value greater than 0.");
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Filament Diameter must be a double precision value greater than 0.");  
            }   
                
            try{
                d = new Double(vars.get(2));
                if(d>0) config.setExtrusionMultiplier(d);
                else{
                    throw new BadFieldException("Extrusion Multiplier must be a double precision value greater than 0.");
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Extrusion Multiplier must be a double precision value greater than 0.");  
            }
            
            try{
                i = new Integer(vars.get(3));
                config.setFirstLayerExtrusionTemperature(i);
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("First Layer Extrusion Tempurture must be an integer.");  
            }
            try{
                i = new Integer(vars.get(4));
                config.setExtrusionTemperature(i);
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Extrustion tempurture must be an integer.");  
            }
            
            try{
                d = new Double(vars.get(5));
                if(d>=0)config.setRetractionLength(d);
                else {
                    throw new BadFieldException("Retraction Length must be a double precision value greater than or equal to 0.");
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Retraction Length must be a double precision value greater than or equal to 0.");  
            }
            
            try{
                d = new Double(vars.get(6));
                if(d>=0)config.setRetractionLiftZ(d);
                else{
                    throw new BadFieldException("Retraction lift Z must be a double precision value greater than or equal to 0.");
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Retraction lift Z  must be a double precision value greater than or equal to 0.");  
            }
            
            try{
                i = new Integer(vars.get(7));
                if(i>=0)config.setRetractionSpeed(i);
                else{
                    throw new BadFieldException("Retraction Speed must be an integer greater than 0.");
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Retraction Speed must be an integer greater than 0.");  
            }
            
            try{
                d = new Double(vars.get(8));
                if(d>=0)config.setExtraLengthAfterRetraction(d);
                else{
                    throw new BadFieldException("Extra Length After Retraction must be a double precision value greater then or equal to 0.");
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Extra Length After Retraction must be a double precision value greater then or equal to 0.");  
            }
            
            try{
                d = new Double(vars.get(9));
                if(d>=0)config.setMinimumTravelAfterRetraction(d);
                else{
                    throw new BadFieldException("Minimum Travel After Retraction must be a double precision value greater then or equal to 0.");
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Minimum Travel After Retraction must be a double precision value greater then or equal to 0.");  
            }
            
            config.setRetractOnLayerChange(Boolean.parseBoolean(vars.get(10)));
            config.setWipeBeforeRetract(Boolean.parseBoolean(vars.get(11)));
            
            try{
                d = new Double(vars.get(12));
                if(d>=0)config.setRetractionLengthBeforeToolChange(d);
                else{
                    throw new BadFieldException("Retraction Legth Before Tool Change must be a double precision value greater then or equal to 0.");
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Retraction Legth Before Tool Change must be a double precision value greater then or equal to 0.");  
            }
            
            try{
                d = new Double(vars.get(13));
                if(d>=0)config.setExtraLengthOnToolReenable(d);
                else{
                    throw new BadFieldException("Extra Length on Tool Reenable must bea double precision value greater then or equal to 0.");
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
                throw new BadFieldException("Extra Length on Tool Reenable must bea double precision value greater then or equal to 0.");  
            }
        
        }catch(NumberFormatException e){
            e.printStackTrace();
            throw new BadFieldException("All Fields need to be filed out to save a Material");
        }
        return db.saveMaterialConfiguration(config);
    }
}
