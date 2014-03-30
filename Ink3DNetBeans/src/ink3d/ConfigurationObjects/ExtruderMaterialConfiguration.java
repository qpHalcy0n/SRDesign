/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.ConfigurationObjects;

import java.util.Objects;

/**
 *
 * @author daniellain
 */
public class ExtruderMaterialConfiguration {
    private MaterialConfiguration material;
    private ExtruderConfiguration extruder;

    public ExtruderMaterialConfiguration(){
    }
    
    public ExtruderMaterialConfiguration(ExtruderConfiguration extruder, MaterialConfiguration material){
        this.extruder = extruder;
        this.material = material;
    }
    
    public MaterialConfiguration getMaterial() {
        return material;
    }

    public void setMaterial(MaterialConfiguration material) {
        this.material = material;
    }

    public ExtruderConfiguration getExtruder() {
        return extruder;
    }

    public void setExtruder(ExtruderConfiguration extruder) {
        this.extruder = extruder;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.material);
        hash = 41 * hash + Objects.hashCode(this.extruder);
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
        final ExtruderMaterialConfiguration other = (ExtruderMaterialConfiguration) obj;
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.extruder, other.extruder)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExtruderMaterialConfiguration{" + "material=" + material + ", extruder=" + extruder + '}';
    }    
}
