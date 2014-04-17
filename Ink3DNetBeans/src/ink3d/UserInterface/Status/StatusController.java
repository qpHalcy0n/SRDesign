/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Status;

import ink3d.ConfigurationObjects.PrintJobConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tim
 */
public class StatusController implements ActionListener {

    private StatusPanel view;
    private PrintJobConfiguration printJob;

    public StatusController(StatusPanel view, PrintJobConfiguration printJob) {
        this.view = view;
        this.printJob = printJob;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getPauseResumeButton())) {
            System.out.println("Pause button clicked");
        }
        else if(e.getSource().equals(view.getCancelButton())) {
            System.out.println("Cancel button clicked");
        }
    }
    
}
