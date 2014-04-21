/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Status;

import ink3d.Communications.TemperatureObject;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrinterStatusObject;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class StatusController implements ActionListener {

    private StatusPanel view;
    private PrintJobConfiguration printJob;
    private PrinterStatusObject pso;
    private StatusMonitor statusMonitor;

    public StatusController(PrintJobConfiguration printJob) {
        this.view = new StatusPanel(this, printJob);
        this.printJob = printJob;

        if(printJob.getPrinterStatusObject() == null) {
            printJob.setPrinterStatusObject(new PrinterStatusObject());
        }
        this.pso = printJob.getPrinterStatusObject();

        // redundant
        // this.statusMonitor = new StatusMonitor(this, printJob);
    }

    public void display() {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());
        frame.add(view);
        frame.setVisible(true);
    }

    private void start() {
        statusMonitor = new StatusMonitor(this, printJob);
        statusMonitor.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getExportButton())) {
            System.out.println("Export button clicked");
        }
        else if(e.getSource().equals(view.getStartButton())) {
            System.out.println("Start button clicked");
            view.getStartButton().setEnabled(false);
            view.getPauseResumeButton().setEnabled(true);
            view.getCancelButton().setEnabled(true);
            view.clearGCodeList();
            start();
        }
        else if(e.getSource().equals(view.getPauseResumeButton())) {
            System.out.println("Pause button clicked");
            statusMonitor.togglePauseResume();
            view.togglePauseResume();
        }
        else if(e.getSource().equals(view.getCancelButton())) {
            System.out.println("Cancel button clicked");
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this print?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION) {
                System.out.println("Cancel confirmed");
                view.getStartButton().setEnabled(true);
                view.getPauseResumeButton().setEnabled(false);
                view.getCancelButton().setEnabled(false);
            }
        }
    }

    public void updateTemperatures(List<TemperatureObject> temps) {
        for(TemperatureObject temp : temps) {
            int tool = temp.getToolNumber();
            float currentTemp = temp.getCurrentTemperature();
            float desiredTemp = temp.getDesiredTemp();
            view.updateTemperatures(tool, currentTemp, desiredTemp);
        }
    }

    public void updateGCodes(List<String> gcodes) {
        for(String gcode : gcodes) {
            view.addGCode(gcode);
        }
    }
    
}
