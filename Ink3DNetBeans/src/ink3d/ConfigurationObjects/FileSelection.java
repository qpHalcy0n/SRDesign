/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.ConfigurationObjects;

/**
 *
 * @author daniellain
 */
public class FileSelection {
        private String file;
        private String extruder; 
        
        public FileSelection(String file, String extruder){
            this.file = file;
            this.extruder = extruder;
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
        
    }
