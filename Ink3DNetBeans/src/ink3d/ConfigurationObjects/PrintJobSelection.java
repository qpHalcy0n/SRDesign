/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.ConfigurationObjects;

import java.util.ArrayList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniellain
 */
@XmlRootElement(name = "printJobSelection")
@XmlAccessorType (XmlAccessType.FIELD)
public class PrintJobSelection {
    private String name;
    private String printerConfiguration;
    
    @XmlElement(name = "extruderMarterial")
    private ArrayList <ExtruderMaterialSelection> materials;
    
    @XmlElement(name = "subsetSelection")
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrintJobSelection other = (PrintJobSelection) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        if (!Objects.equals(this.printerConfiguration, other.printerConfiguration)) {
            return false;
        }
        for(int i=0; i< this.materials.size();i++){
            if (!this.materials.get(i).equals(other.materials.get(i))) {
            return false;
            }
        }
        for(int i=0; i< this.subsetConfigurationList.size();i++){
            if (!this.subsetConfigurationList.get(i).equals(other.subsetConfigurationList.get(i))) {
            return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrintJobSelection{" + "name=" + name + ", printerConfiguration=" + printerConfiguration + ", materials=" + materials + ", subsetConfigurationList=" + subsetConfigurationList + '}';
    }
   
}


