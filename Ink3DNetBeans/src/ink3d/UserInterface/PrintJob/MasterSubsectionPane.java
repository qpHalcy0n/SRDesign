/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrintJob;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Dan
 */
public class MasterSubsectionPane extends JScrollPane{
    ArrayList<SubsectionPanel> panels;
    JPanel master;
    public ArrayList<SubsectionPanel> getPanels(){
        return panels;
    }
    
    public void removeSubsection(SubsectionPanel panel){
        panels.remove(panel);
        master.remove(panel);
    }
    
    public void addNewSubsectionPanel(){
        SubsectionPanel newPanel =new SubsectionPanel();
        panels.add(newPanel);
        master.add(newPanel);
    }
    
    public void removeAllSubsections(){
        master = new JPanel();
        master.setLayout(new GridLayout(0,1));
        panels = new ArrayList<>();
        panels.add(new SubsectionPanel());
        for(SubsectionPanel panel: panels){
            master.add(panel);
        }
        this.setViewportView(master);
    }
    
    MasterSubsectionPane(){
        master = new JPanel();
        master.setLayout(new GridLayout(0,1));
        panels = new ArrayList<>();
        panels.add(new SubsectionPanel());
        for(SubsectionPanel panel: panels){
            master.add(panel);
        }
        this.setViewportView(master);
    }
    
}
