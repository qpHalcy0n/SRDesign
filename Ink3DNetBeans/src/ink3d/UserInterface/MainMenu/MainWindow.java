/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.MainMenu;

import ink3d.UserInterface.Extruder.ExtruderPanel;
import ink3d.UserInterface.Import.ImportPanel;
import ink3d.UserInterface.Material.MaterialPanel;
import ink3d.UserInterface.PrintConfig.PrintPanel;
import ink3d.UserInterface.PrinterConfig.PrinterPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Tim
 */
public class MainWindow extends JFrame {
    private JTabbedPane tabbedPane;
    private ImportPanel importPanel;
    private PrintPanel printPanel;
    private MaterialPanel materialPanel;
    private ExtruderPanel extruderPanel;
    private PrinterPanel printerPanel;

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();
        importPanel = new ImportPanel();
        printPanel = new PrintPanel();
        materialPanel = new MaterialPanel();
        extruderPanel = new ExtruderPanel();
        printerPanel = new PrinterPanel();

        tabbedPane.addTab("Import", importPanel);
        tabbedPane.addTab("Print Settings", printPanel);
        tabbedPane.addTab("Materials", materialPanel); 
        tabbedPane.addTab("Extruders", extruderPanel);
        tabbedPane.addTab("Printer", printerPanel);

        this.setLayout(new BorderLayout());
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(tabbedPane);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setVisible(true);
    }
}
