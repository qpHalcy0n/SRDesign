/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.ConfigurationObjects;

import java.util.ArrayList;

/**
 *
 * @author daniellain
 */
public class PrintJobSelection {
    private String name;
    private String printerConfiguration;
    private ArrayList<ExtruderMaterialSelection> materials;
    private ArrayList <SubsetSelection> subsetConfigurationList;
    
    public PrintJobSelection(){
        materials = new ArrayList<>();
        subsetConfigurationList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrinterConfiguration() {
        return printerConfiguration;
    }

    public void setPrinterConfiguration(String printerConfiguration) {
        this.printerConfiguration = printerConfiguration;
    }

    public ArrayList<ExtruderMaterialSelection> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<ExtruderMaterialSelection> materials) {
        this.materials = materials;
    }

    public ArrayList<SubsetSelection> getSubsetConfigurationList() {
        return subsetConfigurationList;
    }

    public void setSubsetConfigurationList(ArrayList<SubsetSelection> subsetConfigurationList) {
        this.subsetConfigurationList = subsetConfigurationList;
    }

}


