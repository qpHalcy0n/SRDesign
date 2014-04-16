/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrinterConfig;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class PrintJobListModel extends javax.swing.AbstractListModel{
    private ArrayList<String> list;
    public PrintJobListModel(ArrayList<String> list){
        if(list != null) this.list = list;
        else this.list = new ArrayList<>();
    }
    
    @Override
    public int getSize() { return list.size(); }
    @Override
    public Object getElementAt(int i) { return list.get(i); }
}
