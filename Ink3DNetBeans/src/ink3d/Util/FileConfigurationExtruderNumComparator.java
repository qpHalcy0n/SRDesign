/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Util;

import ink3d.ConfigurationObjects.FileConfiguration;
import java.util.Comparator;

/**
 *
 * @author Tim
 */
public class FileConfigurationExtruderNumComparator implements Comparator<FileConfiguration>{

    @Override
    public int compare(FileConfiguration f1, FileConfiguration f2) {
        return f1.getExtruderNum() - f2.getExtruderNum();
    }
    
}
