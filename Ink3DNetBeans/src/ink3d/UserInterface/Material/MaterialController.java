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
    
    public Boolean deleteMaterialConfiguration(String name){
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
        varList.add(material.getRetractionSpeed()== 0 ? "true":"false");
        varList.add(Double.toString(material.getExtraLengthAfterRetraction()));
        varList.add(Double.toString(material.getMinimumTravelAfterRetraction()));
        varList.add(Boolean.toString(material.isRetractOnLayerChange()));
        varList.add(Boolean.toString(material.isWipeBeforeRetract()));
        varList.add(Double.toString(material.getRetractionLengthBeforeToolChange()));
        varList.add(Double.toString(material.getExtraLengthOnToolReenable()));
        varList.add(Boolean.toString(material.isFanAlwaysOn()));
        varList.add(Boolean.toString(material.isEnableAutoCooling()));
        varList.add(Integer.toString(material.getMinFanSpeed()));
        varList.add(Integer.toString(material.getMaxFanSpeed()));
        varList.add(Integer.toString(material.getBridgeFanSpeedPercent()));
        varList.add(Integer.toString(material.getDisableFanForFirstNLayers()));
        varList.add(Integer.toString(material.getEnableFanTimeThreshold()));
        varList.add(Integer.toString(material.getSlowDownTimeTreshold()));
        varList.add(Integer.toString(material.getMinPrintSpeed()));
        varList.add(material.getgCodeStart());
        varList.add(material.getgCodeEnd());
        
        return varList;
    }
    
    public Boolean saveMaterialConfiguration(ArrayList<String> vars) throws BadFieldException{
        Double d;
        Integer i;
        MaterialConfiguration config = new MaterialConfiguration();
        try{
            if(vars.get(0).length()>0)config.setName(vars.get(0));
            else {
                throw new BadFieldException("Name must not be empty.");
            }
            
            d = new Double(vars.get(1));
            if(d>0) config.setFilamentDiameter(d);
            else {
                throw new BadFieldException("Filament Diameter must be a double precision value greater than 0.");
            }
            
            d = new Double(vars.get(2));
            if(d>0) config.setExtrusionMultiplier(d);
            else{
                throw new BadFieldException("Extrusion Multiplier must be a double precision value greater than 0.");
            }
            
            i = new Integer(vars.get(3));
            config.setFirstLayerExtrusionTemperature(i);
            
            i = new Integer(vars.get(4));
            config.setExtrusionTemperature(i);
            
            d = new Double(vars.get(5));
            if(d>=0)config.setRetractionLength(d);
            else {
                throw new BadFieldException("Retraction Length must be a double precision value greater than or equal to 0.");
            }
     
            d = new Double(vars.get(6));
            if(d>=0)config.setRetractionLiftZ(d);
            else{
                throw new BadFieldException("Retraction Length must be a double precision value greater than or equal to 0.");
            }
            
            i = new Integer(vars.get(7));
            if(i>=0)config.setRetractionSpeed(i);
            else{
                throw new BadFieldException("Retraction Speed must be an integer greater than 0");
            }
            
            d = new Double(vars.get(8));
            if(d>=0)config.setExtraLengthAfterRetraction(d);
            else{
                throw new BadFieldException("Extra Length After Retraction must be a double precision value greater then or equal to 0.");
            }
            
            d = new Double(vars.get(9));
            if(d>=0)config.setMinimumTravelAfterRetraction(d);
            else{
                throw new BadFieldException("Minimum Travel After Retraction must be a double precision value greater then or equal to 0.");
            }
            
            config.setRetractOnLayerChange(Boolean.getBoolean(vars.get(10)));
            config.setWipeBeforeRetract(Boolean.getBoolean(vars.get(11)));
            
            d = new Double(vars.get(12));
            if(d>=0)config.setRetractionLengthBeforeToolChange(d);
            else{
                throw new BadFieldException("Retraction Legth Before Tool Change must be a double precision value greater then or equal to 0.");
            }
            
            d = new Double(vars.get(13));
            if(d>=0)config.setExtraLengthOnToolReenable(d);
            else{
                throw new BadFieldException("Extra Length on Tool Reenable must bea double precision value greater then or equal to 0.");
            }
            
            config.setFanAlwaysOn(Boolean.getBoolean(vars.get(14)));
            config.setEnableAutoCooling(Boolean.getBoolean(vars.get(15)));
            
            int minFan = new Integer(vars.get(16));
            int maxFan = new Integer(vars.get(17));
            if(minFan>=0 && minFan <=maxFan) config.setMinFanSpeed(minFan);
            else{
                if(minFan > maxFan)throw new BadFieldException("Minimum Fan Speed must be an integer that is less than maximum fan speed.");
                else{
                    throw new BadFieldException("Minimum Fan Speed must be an integer that is greater than or equal to 0.");
                }
            }
            if(maxFan<=100)config.setMaxFanSpeed(maxFan);
            else {
                throw new BadFieldException("Maximum Fan Speed must be an integer that is less than or equal to 100");
            }
            
            i = new Integer(vars.get(18));
            if(i>=0 && i<=100)config.setBridgeFanSpeedPercent(i);
            else{
                throw new BadFieldException("Bridge Fan Speed Percent must be an integer value between 0 and 100");
            }
            
            i = new Integer(vars.get(19));
            if(i>=0)config.setDisableFanForFirstNLayers(i);
            else{
                throw new BadFieldException("Disable Fan for First N Layers must be an integer greater than or equal to 0.");
            }
            
            i = new Integer(vars.get(20));
            if(i>=0)config.setEnableFanTimeThreshold(i);
            else{
                throw new BadFieldException("Enable Fan Time Threshold must be an integer greater than or equal to 0.");
            }
            
            i = new Integer(vars.get(21));
            if(i>=0)config.setSlowDownTimeTreshold(i);
            else {
                throw new BadFieldException("Slow Down Time Threshold must be an integer greater than or equal to 0.");
            }
            
            i = new Integer(vars.get(22));
            if(i>=0)config.setMinPrintSpeed(i);
            else {
                throw new BadFieldException("Minimum Print Speed must be an integer greater than 0.");
            }
            
            config.setgCodeStart(vars.get(23));
            config.setgCodeEnd(vars.get(24));
        }catch(NumberFormatException e){
            throw new BadFieldException("All Fields need to be filed out to save a Printer");
        }
        return db.saveMaterialConfiguration(config);
    }
}
