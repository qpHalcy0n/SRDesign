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
public class ExtruderMaterialSelection {
        private String extruder;
        private String material;
        
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
        
    }
