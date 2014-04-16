/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrintJob;

import java.util.ArrayList;
import javax.swing.JScrollPane;

/**
 *
 * @author Dan
 */
public class MasterSubsectionPane extends JScrollPane{
    ArrayList<SubsectionPanel> panels;
    
    public ArrayList<SubsectionPanel> getPanels(){
        return panels;
    }
    
    public void removeSubsection(int id){
        panels.remove(id);
    }
    
    public void addSubsectionPanel(SubsectionPanel panel){
        panels.add(panel);
    }
    
    MasterSubsectionPane(){
        panels = new ArrayList<>();
        panels.add(new SubsectionPanel());
        for(SubsectionPanel panel: panels){
            this.add(panel);
        }
    }
    
}
