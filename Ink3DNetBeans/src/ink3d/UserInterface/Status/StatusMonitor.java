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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tim
 */
public class StatusMonitor extends Thread {
    private StatusController controller;
    private PrinterStatusObject pso;
    private PrinterStatus status;
    private PrintJobConfiguration printJob;
    private boolean paused;

    public StatusMonitor(StatusController controller, PrintJobConfiguration printJob) {
        this.printJob = printJob;
        this.controller = controller;
        this.paused = true;

        // Instantiate a printer status object if one does not exist
        if(printJob.getPrinterStatusObject() == null) {
            printJob.setPrinterStatusObject(new PrinterStatusObject());
        }
        this.pso = printJob.getPrinterStatusObject();
        this.status = new PrinterStatusImpl(printJob);
    }

    @Override
    public void run() {
        status.go();
        paused = false;
        while(true) {
            try {
                if(paused) {
                    sleep(1000);
                    continue;
                }
                if(pso.hasCurrentToolTemperatures()) {
                    List<TemperatureObject> temps = pso.getCurrentToolTemperatures();
                    controller.updateTemperatures(temps);

                }
                if(pso.hasGCodes()) {
                    List<String> gCodes = pso.getLastGcodesExecuted();
  //                  controller.updateGCodes(gCodes);
                }
                sleep(1000);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(StatusMonitor.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Status Monitor interrupted.");
                break;
            }
        }
    }

    public void cancel() {
        interrupt();
        status.cancelPrinting();
        System.out.println("Canceled printing");
    }

    public void togglePauseResume() {
        if(paused) {
            status.resumePrinting();
            paused = false;
            System.out.println("Resumed printing");
        }
        else {
            paused = true;
            status.pausePrinting();
            System.out.println("Paused printing");
        }
    }

}
