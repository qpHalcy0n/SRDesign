package ink3d.ConfigurationObjects;

import java.io.File;

/**
 * Created by daniellain on 2/8/14.
 */
public class FileConfiguration {
    private File parentSTLFile;
    private File subsetSTL;

    private ExtruderConfiguration extruderConfiguration;
    private MaterialConfiguration materialConfiguration;

    public File getParentSTLFile() {
        return parentSTLFile;
    }

    public void setParentSTLFile(File parentSTLFile) {
        this.parentSTLFile = parentSTLFile;
    }

    public File getSubsetSTL() {
        return subsetSTL;
    }

    public void setSubsetSTL(File subsetSTL) {
        this.subsetSTL = subsetSTL;
    }

    public ExtruderConfiguration getExtruderConfiguration() {
        return extruderConfiguration;
    }

    public void setExtruderConfiguration(ExtruderConfiguration extruderConfiguration) {
        this.extruderConfiguration = extruderConfiguration;
    }

    public MaterialConfiguration getMaterialConfiguration() {
        return materialConfiguration;
    }

    public void setMaterialConfiguration(MaterialConfiguration materialConfiguration) {
        this.materialConfiguration = materialConfiguration;
    }
    
    
}
