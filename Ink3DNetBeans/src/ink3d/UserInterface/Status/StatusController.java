/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Status;

import ink3d.Communications.TemperatureObject;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrinterStatusObject;
import ink3d.PrinterStatus.PrinterStatus;
import ink3d.PrinterStatus.PrinterStatusImpl;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDialog;
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
    private PrinterStatus status;
    private boolean paused;
    //private StatusMonitor statusMonitor;

    public StatusController(PrintJobConfiguration printJob) {
        this.view = new StatusPanel(this, printJob);
        this.printJob = printJob;

        if(printJob.getPrinterStatusObject() == null) {
            printJob.setPrinterStatusObject(new PrinterStatusObject());
        }
        this.pso = printJob.getPrinterStatusObject();
        this.status = new PrinterStatusImpl(printJob);
        this.paused = false;

        // redundant
        // this.statusMonitor = new StatusMonitor(this, printJob);
    }

    public void display() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setSize(600, 600);
        dialog.setLayout(new BorderLayout());
        dialog.add(view);
        dialog.setVisible(true);
    }

    private void start() {
        if(status == null) {
            status = new PrinterStatusImpl(printJob);
        }
        status.go();
        // statusMonitor = new StatusMonitor(this, printJob);
        // statusMonitor.start();
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
            this.paused = false;
            start();
        }
        else if(e.getSource().equals(view.getPauseResumeButton())) {
            System.out.println("Pause/Resume button clicked");
            if(paused) {
                status.resumePrinting();
            }
            else {
                status.pausePrinting();
            }
            paused = !paused;
            view.togglePauseResume();
        }
        else if(e.getSource().equals(view.getCancelButton())) {
            System.out.println("Cancel button clicked");
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this print?",
                "Cancel Confirmation", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION) {
                System.out.println("Cancel confirmed");
                view.getStartButton().setEnabled(true);
                view.getPauseResumeButton().setEnabled(false);
                view.getCancelButton().setEnabled(false);
                status.cancelPrinting();
            }
        }
    }

    public void updateTemperatures(List<TemperatureObject> temps) {
        for(TemperatureObject temp : temps) {
            updateTemperature(temp);
        }
    }

    public void updateTemperature(TemperatureObject temp) {
        int tool = temp.getToolNumber();
        System.out.println("Tool to update temp: T" + tool);
        if(tool != -1) {
            float currentTemp = temp.getCurrentTemperature();
            float desiredTemp = temp.getDesiredTemp();
            view.updateTemperatures(tool, currentTemp, desiredTemp);
        }
    }

    public void addGCodes(List<String> gcodes) {
        for(String gcode : gcodes) {
            addGCode(gcode);
        }
    }

    public void addGCode(String gcode) {
        view.addGCode(gcode);
    }

    
    
}
