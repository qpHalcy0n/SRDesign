package ink3d.ConfigurationObjects;

import java.io.File;
import java.util.Objects;

/**
 * Created by daniellain on 2/8/14.
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileConfiguration {
    private String name;
    private File parentSTLFile;
    private File subsetSTL;
    
    /**
     * Represents the extruder (it's position) that is responsible for this file
     */
    private int extruderNum;
    private ExtruderConfiguration extruderConfiguration;
    private MaterialConfiguration materialConfiguration;

    public FileConfiguration () {
        this.extruderConfiguration = new ExtruderConfiguration();
        this.materialConfiguration = new MaterialConfiguration();
    }

    public void setParentSTLFile(File parentSTLFile) {
        this.parentSTLFile = parentSTLFile;
    }
    
    public void setSubsetSTL(File subsetSTL) {
        this.subsetSTL = subsetSTL;
    }

    public void setExtruderConfiguration(ExtruderConfiguration extruderConfiguration) {
        this.extruderConfiguration = extruderConfiguration;
    }
    
    public void setMaterialConfiguration(MaterialConfiguration materialConfiguration) {
        this.materialConfiguration = materialConfiguration;
    }
    
    public MaterialConfiguration getMaterialConfiguration() {
        return materialConfiguration;
    }
    
    public ExtruderConfiguration getExtruderConfiguration() {
        return extruderConfiguration;
    }
    
    public File getSubsetSTL() {
        return subsetSTL;
    }
    
    public File getParentSTLFile() {
        return parentSTLFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + Objects.hashCode(this.parentSTLFile);
        hash = 11 * hash + Objects.hashCode(this.subsetSTL);
        hash = 11 * hash + this.extruderNum;
        hash = 11 * hash + Objects.hashCode(this.extruderConfiguration);
        hash = 11 * hash + Objects.hashCode(this.materialConfiguration);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileConfiguration other = (FileConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.parentSTLFile, other.parentSTLFile)) {
            return false;
        }
        if (!Objects.equals(this.subsetSTL, other.subsetSTL)) {
            return false;
        }
        if (this.extruderNum != other.extruderNum) {
            return false;
        }
        if (!Objects.equals(this.extruderConfiguration, other.extruderConfiguration)) {
            return false;
        }
        if (!Objects.equals(this.materialConfiguration, other.materialConfiguration)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FileConfiguration{" + "name=" + name + ", parentSTLFile=" + parentSTLFile + ", subsetSTL=" + subsetSTL + ", extruderNum=" + extruderNum + ", extruderConfiguration=" + extruderConfiguration + ", materialConfiguration=" + materialConfiguration + '}';
    }
    
    

    /**
     * @return the extruderNum
     */
    public int getExtruderNum() {
        return extruderNum;
    }

    /**
     * @param extruderNum the extruderNum to set
     */
    public void setExtruderNum(int extruderNum) {
        this.extruderNum = extruderNum;
    }
    
}
