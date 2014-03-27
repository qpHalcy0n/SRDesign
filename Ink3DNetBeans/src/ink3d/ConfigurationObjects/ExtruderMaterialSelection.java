/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.ConfigurationObjects;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniellain
 */
@XmlRootElement(name = "extruderMarterial")
@XmlAccessorType (XmlAccessType.FIELD)
public class ExtruderMaterialSelection {
    private String extruder;
    private String material;

    public ExtruderMaterialSelection(){}

    public ExtruderMaterialSelection(String extruder, String material){
        this.extruder = extruder;
        this.material = material;
    }

    public String getExtruder() {
        return extruder;
    }

    public void setExtruder(String extruder) {
        this.extruder = extruder;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExtruderMaterialSelection other = (ExtruderMaterialSelection) obj;
        if (!Objects.equals(this.extruder, other.extruder)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExtruderMaterialSelection{" + "extruder=" + extruder + ", material=" + material + '}';
    }

}
