package ink3d.ConfigurationObjects;

import java.io.File;

/**
 * Created by daniellain on 2/8/14.
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileConfiguration {
    private String name;
    private File parentSTLFile;
    private File subsetSTL;

    private ExtruderConfiguration extruderConfiguration;
    private MaterialConfiguration materialConfiguration;

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
    
}
