/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrintJob;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Dan
 */
public class MaterialFileMatchingComboBoxModel extends DefaultComboBoxModel{

    private ArrayList<String> list = PrintJobPanel.extruderMaterialArrayListForPrintJob;
    
    
    @Override
    public int getSize() { return list.size(); }
    @Override
    public Object getElementAt(int i) { 
        if(i < 10) return "0"+i+"-"+list.get(i);
        else return i+"-"+list.get(i); 
    }
    
}
