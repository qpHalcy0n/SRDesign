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
@XmlRootElement(name = "fileSelection")
@XmlAccessorType (XmlAccessType.FIELD)
public class FileSelection {
    private String file;
    private int extruderNum;
    private String extruder;
    private String material;

    public FileSelection(){
    }

    public int getExtruderNum() {
        return extruderNum;
    }

    public void setExtruderNum(int extruderNum) {
        this.extruderNum = extruderNum;
    }
    
    public FileSelection(String extruder, String material, String file){
        this.extruder = extruder;
        this.file = file;
        this.material = material;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.file);
        hash = 53 * hash + Objects.hashCode(this.extruder);
        hash = 53 * hash + Objects.hashCode(this.material);
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
        final FileSelection other = (FileSelection) obj;
        if (!Objects.equals(this.file, other.file)) {
            return false;
        }
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
        return "FileSelection{" + "file=" + file + ", extruder=" + extruder + ", material=" + material + '}';
    }
}
