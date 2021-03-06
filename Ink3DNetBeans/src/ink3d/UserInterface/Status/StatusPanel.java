/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Status;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Tim
 */
public class StatusPanel extends JPanel {
    private static final int BORDER = 10;
    private static final String EXPORT = "Export G-Code";
    private static final String START = "Start";
    public static final String PAUSE = "Pause";
    public static final String RESUME = "Resume";
    private static final String CANCEL = "Cancel";
    
    private static final String EXTRUDER = "Extruder:";
    private static final String CURRENT_TEMP = "Current Temperature:";
    private static final String DESIRED_TEMP = "Desired Temperature:";

    private JPanel actionPanel;
    private JButton exportButton;
    private JButton startButton;
    private JButton pauseResumeButton;
    private JButton cancelButton;

    private JPanel gCodePanel;
    private JScrollPane gCodeScrollPane;
    private JList gCodeList;

    private JPanel temperaturePanel;
    private JLabel extruderLbl;
    private JLabel currentTempLbl;
    private List<String> extruderNames;
    private List<JTextField> currentTempTextFields;


    private PrintJobConfiguration printJob;
    private StatusController controller;

    public StatusPanel(StatusController controller, PrintJobConfiguration printJob) {
        this.controller = controller;
        this.printJob = printJob;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        exportButton = new JButton(EXPORT);
        exportButton.addActionListener(controller);
        startButton = new JButton(START);
        startButton.addActionListener(controller);
        pauseResumeButton = new JButton(PAUSE);
        pauseResumeButton.setEnabled(false);
        pauseResumeButton.addActionListener(controller);
        cancelButton = new JButton(CANCEL);
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(controller);
        actionPanel = new JPanel();
        actionPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.LINE_AXIS));
        actionPanel.add(exportButton);
        actionPanel.add(Box.createRigidArea(new Dimension(15,0)));
        actionPanel.add(startButton);
        actionPanel.add(Box.createRigidArea(new Dimension(15,0)));
        actionPanel.add(pauseResumeButton);
        actionPanel.add(Box.createRigidArea(new Dimension(15,0)));
        actionPanel.add(cancelButton);

        gCodeList = new JList(new DefaultListModel());
        gCodeScrollPane = new JScrollPane(gCodeList);
        gCodePanel = new JPanel(new BorderLayout());
        gCodePanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
        gCodePanel.add(gCodeScrollPane);

        
        int numberOfExtruders = this.printJob.getPrinterConfiguration().getExtruderList().size();
        temperaturePanel = new JPanel(new GridLayout(3, 1 + numberOfExtruders));
        temperaturePanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
        JPanel[][] gridMap = new JPanel[3][1 + numberOfExtruders];
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 1 + numberOfExtruders; c++) {
                JPanel temp = new JPanel();
                gridMap[r][c] = temp;
                temperaturePanel.add(temp);
            }
        }

        gridMap[0][0].add(new JLabel(EXTRUDER));
        gridMap[1][0].add(new JLabel(CURRENT_TEMP));
        
        currentTempTextFields = new ArrayList<>();
        for(int i = 1; i < 1 + numberOfExtruders; i++) {
            gridMap[0][i].add(new JLabel("T" + String.valueOf(i-1)));
            JTextField currentTempField = new JTextField(6);
            currentTempField.setEnabled(true);
            currentTempField.setEditable(true);
            currentTempTextFields.add(currentTempField);
            gridMap[1][i].add(currentTempField);
        }

        this.add(actionPanel);
        this.add(gCodePanel);
        this.add(temperaturePanel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        PrintJobConfiguration printJob = new PrintJobConfiguration();
        List<ExtruderConfiguration> extruders = new ArrayList<>();
        extruders.add(new ExtruderConfiguration());
        extruders.add(new ExtruderConfiguration());
        extruders.add(new ExtruderConfiguration());
        printJob.getPrinterConfiguration().setExtruderList(extruders);

        StatusController controller = new StatusController(printJob);

        StatusPanel statusPanel = new StatusPanel(controller, printJob);
        frame.add(statusPanel);
        frame.setVisible(true);

    }

    public void addGCode(String gcode) {
        ((DefaultListModel) gCodeList.getModel()).addElement(gcode);
        System.out.println("Added G-Code:  " + gcode);
    }

    public void updateTemperatures(int tool, float currentTemp) {
        if(tool >= 0 && tool < currentTempTextFields.size()) {
            currentTempTextFields.get(tool).setText(String.valueOf(currentTemp));
            System.out.println("T" + tool + " current temp set to:  " + currentTemp);
        }
    }

    public void togglePauseResume() {
        if(pauseResumeButton.getText().equals(PAUSE)) {
            System.out.println("Current state is 'pause', changing to 'resume'");
            pauseResumeButton.setText(RESUME);
        }
        else {
            System.out.println("Current state is 'resume', changing to 'pause'");
            pauseResumeButton.setText(PAUSE);
        }
    }

    public void clearGCodeList() {
        ((DefaultListModel) gCodeList.getModel()).removeAllElements();
    }

    /**
     * @return the actionPanel
     */
    public JPanel getActionPanel() {
        return actionPanel;
    }

    /**
     * @param actionPanel the actionPanel to set
     */
    public void setActionPanel(JPanel actionPanel) {
        this.actionPanel = actionPanel;
    }

    /**
     * @return the pauseResumeButton
     */
    public JButton getPauseResumeButton() {
        return pauseResumeButton;
    }

    /**
     * @param pauseResumeButton the pauseResumeButton to set
     */
    public void setPauseResumeButton(JButton pauseResumeButton) {
        this.pauseResumeButton = pauseResumeButton;
    }

    /**
     * @return the cancelButton
     */
    public JButton getCancelButton() {
        return cancelButton;
    }

    /**
     * @param cancelButton the cancelButton to set
     */
    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    /**
     * @return the gCodePanel
     */
    public JPanel getgCodePanel() {
        return gCodePanel;
    }

    /**
     * @param gCodePanel the gCodePanel to set
     */
    public void setgCodePanel(JPanel gCodePanel) {
        this.gCodePanel = gCodePanel;
    }

    /**
     * @return the gCodeScrollPane
     */
    public JScrollPane getgCodeScrollPane() {
        return gCodeScrollPane;
    }

    /**
     * @param gCodeScrollPane the gCodeScrollPane to set
     */
    public void setgCodeScrollPane(JScrollPane gCodeScrollPane) {
        this.gCodeScrollPane = gCodeScrollPane;
    }

    /**
     * @return the gCodeList
     */
    public JList getgCodeList() {
        return gCodeList;
    }

    /**
     * @param gCodeList the gCodeList to set
     */
    public void setgCodeList(JList gCodeList) {
        this.gCodeList = gCodeList;
    }

    /**
     * @return the temperaturePanel
     */
    public JPanel getTemperaturePanel() {
        return temperaturePanel;
    }

    /**
     * @param temperaturePanel the temperaturePanel to set
     */
    public void setTemperaturePanel(JPanel temperaturePanel) {
        this.temperaturePanel = temperaturePanel;
    }

    /**
     * @return the extruderLbl
     */
    public JLabel getExtruderLbl() {
        return extruderLbl;
    }

    /**
     * @param extruderLbl the extruderLbl to set
     */
    public void setExtruderLbl(JLabel extruderLbl) {
        this.extruderLbl = extruderLbl;
    }

    /**
     * @return the currentTempLbl
     */
    public JLabel getCurrentTempLbl() {
        return currentTempLbl;
    }

    /**
     * @param currentTempLbl the currentTempLbl to set
     */
    public void setCurrentTempLbl(JLabel currentTempLbl) {
        this.currentTempLbl = currentTempLbl;
    }

    /**
     * @return the extruderNames
     */
    public List<String> getExtruderNames() {
        return extruderNames;
    }

    /**
     * @param extruderNames the extruderNames to set
     */
    public void setExtruderNames(List<String> extruderNames) {
        this.extruderNames = extruderNames;
    }

    /**
     * @return the currentTempTextFields
     */
    public List<JTextField> getCurrentTempTextFields() {
        return currentTempTextFields;
    }

    /**
     * @param currentTempTextFields the currentTempTextFields to set
     */
    public void setCurrentTempTextFields(List<JTextField> currentTempTextFields) {
        this.currentTempTextFields = currentTempTextFields;
    }

    /**
     * @return the printJob
     */
    public PrintJobConfiguration getPrintJob() {
        return printJob;
    }

    /**
     * @param printJob the printJob to set
     */
    public void setPrintJob(PrintJobConfiguration printJob) {
        this.printJob = printJob;
    }

    /**
     * @return the controller
     */
    public StatusController getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(StatusController controller) {
        this.controller = controller;
    }

    /**
     * @return the exportButton
     */
    public JButton getExportButton() {
        return exportButton;
    }

    /**
     * @param exportButton the exportButton to set
     */
    public void setExportButton(JButton exportButton) {
        this.exportButton = exportButton;
    }

    /**
     * @return the startButton
     */
    public JButton getStartButton() {
        return startButton;
    }

    /**
     * @param startButton the startButton to set
     */
    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

}
