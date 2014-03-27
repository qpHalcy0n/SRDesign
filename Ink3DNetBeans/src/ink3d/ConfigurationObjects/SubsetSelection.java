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
@XmlRootElement(name = "subsetSelection")
@XmlAccessorType (XmlAccessType.FIELD)
public class SubsetSelection {
    private double bottomZ;
    private double topZ;
    private String printConfiguration;
    
    @XmlElement(name = "fileSelection")
    private ArrayList<FileSelection> fileConfigurations;

    public SubsetSelection(){
    fileConfigurations = new ArrayList<>();
    }

    public double getBottomZ() {
        return bottomZ;
    }

    public void setBottomZ(double bottomZ) {
        this.bottomZ = bottomZ;
    }

    public double getTopZ() {
        return topZ;
    }

    public void setTopZ(double topZ) {
        this.topZ = topZ;
    }

    public void setPrintConfiguration(String printConfiguration) {
        this.printConfiguration = printConfiguration;
    }

    public String getPrintConfiguration() {
        return printConfiguration;
    }

    public ArrayList<FileSelection> getFileConfigurations() {
        return fileConfigurations;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubsetSelection other = (SubsetSelection) obj;
        if (Double.doubleToLongBits(this.bottomZ) != Double.doubleToLongBits(other.bottomZ)) {
            return false;
        }
        if (Double.doubleToLongBits(this.topZ) != Double.doubleToLongBits(other.topZ)) {
            return false;
        }
        if (!Objects.equals(this.printConfiguration, other.printConfiguration)) {
            return false;
        }
        for(int i = 0; i<this.fileConfigurations.size();i++)
        if (!this.fileConfigurations.get(i).equals(other.fileConfigurations.get(i))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SubsetSelection{" + "bottomZ=" + bottomZ + ", topZ=" + topZ + ", printConfiguration=" + printConfiguration + ", fileConfigurations=" + fileConfigurations + '}';
    }
    
    
}