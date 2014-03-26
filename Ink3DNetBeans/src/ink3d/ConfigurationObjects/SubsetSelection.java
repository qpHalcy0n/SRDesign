/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.ConfigurationObjects;

import java.util.ArrayList;

/**
 *
 * @author daniellain
 */
public class SubsetSelection {
        private double bottomZ;
        private double topZ;
        private String printConfiguration;
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
    }