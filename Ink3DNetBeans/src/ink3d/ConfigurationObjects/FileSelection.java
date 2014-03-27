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
    private String extruder; 

    public FileSelection(){
    }
    
    public FileSelection(String extruder, String file){
        this.extruder = extruder;
        this.file = file;
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

    @Override
    public String toString() {
        return "FileSelection{" + "file=" + file + ", extruder=" + extruder + '}';
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
        return true;
    }      
}
