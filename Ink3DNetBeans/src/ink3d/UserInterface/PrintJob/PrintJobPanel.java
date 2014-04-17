/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrintJob;

import ink3d.UserInterface.MainMenu.BadFieldException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author courtney
 */
public class PrintJobPanel extends javax.swing.JPanel {
    private PrintJobController printJobController = new PrintJobController();
    public static ArrayList<String> extruderMaterialArrayListForPrintJob = new ArrayList<>();

    /**
     * Creates new form PrintJobPanel
     */
    public PrintJobPanel() {
        initComponents();
    }
    public MasterSubsectionPane getMasterSubsectionPane(){
        return (MasterSubsectionPane) this.masterSubsectionPane;
    }
    
    private void updateSubsectionPanels(){
        for(SubsectionPanel panel: ((MasterSubsectionPane)this.masterSubsectionPane).getSubsectoions()){
            panel.updateComboBoxes();
            panel.updateUI();
        }
        this.updateUI();
    }
    public javax.swing.JComboBox getPrinterComboBox(){
        return this.materialSelectionPrintJobComboBox;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        masterSubsectionPane = new MasterSubsectionPane();
        startPrintPrintJobButton = new javax.swing.JButton();
        newPrintJobButton = new javax.swing.JButton();
        savePrintJobButton = new javax.swing.JButton();
        deletePrintJobButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        printJobLList = new javax.swing.JList();
        addSubsection = new javax.swing.JButton();
        namePrintJobText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        materialSelectionPrintJobComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        extruderMaterialMapList = new javax.swing.JList();
        removeMaterialPrintJobButton = new javax.swing.JButton();
        addMaterialPrintJobButton = new javax.swing.JButton();
        printerSelectionPrintJobComboBox = new javax.swing.JComboBox();
        loadPrintJobButton = new javax.swing.JButton();

        startPrintPrintJobButton.setText("Start Print");

        newPrintJobButton.setText("New");
        newPrintJobButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                newPrintJobButtonMouseReleased(evt);
            }
        });

        savePrintJobButton.setText("Save");
        savePrintJobButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                savePrintJobButtonMouseReleased(evt);
            }
        });

        deletePrintJobButton.setText("Delete");

        jLabel4.setText("Print Job Configs");

        printJobLList.setModel(new javax.swing.AbstractListModel() {
            private PrintJobController  controller = new PrintJobController();
            public int getSize() { return controller.loadAvailablePrintJobs().size(); }
            public Object getElementAt(int i) { return controller.loadAvailablePrintJobs().get(i); }
        });
        jScrollPane2.setViewportView(printJobLList);

        addSubsection.setText("Add Sebsection");
        addSubsection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addSubsectionMouseReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Name:");

        materialSelectionPrintJobComboBox.setModel(new DefaultComboBoxModel(this.printJobController.loadAvailableMaterials().toArray()));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Printer:");

        jLabel5.setText("Extruder - Material");

        extruderMaterialMapList.setModel(new javax.swing.AbstractListModel() {
            @Override
            public int getSize() { return PrintJobPanel.extruderMaterialArrayListForPrintJob.size(); }
            @Override
            public Object getElementAt(int i) {
                if(i<10)return "0"+i+"-"+PrintJobPanel.extruderMaterialArrayListForPrintJob.get(i);
                else return i+"-"+PrintJobPanel.extruderMaterialArrayListForPrintJob.get(i);
            }
        });
        jScrollPane3.setViewportView(extruderMaterialMapList);

        removeMaterialPrintJobButton.setText("Remove Material");
        removeMaterialPrintJobButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removeMaterialPrintJobButtonMouseReleased(evt);
            }
        });

        addMaterialPrintJobButton.setText("Add Material");
        addMaterialPrintJobButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addMaterialPrintJobButtonMouseReleased(evt);
            }
        });

        printerSelectionPrintJobComboBox.setModel(new DefaultComboBoxModel(this.printJobController.loadAvailablePrinters().toArray()));

        loadPrintJobButton.setText("Load");
        loadPrintJobButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loadPrintJobButtonMouseReleased(evt);
            }
        });
        loadPrintJobButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadPrintJobButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(masterSubsectionPane, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(materialSelectionPrintJobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(removeMaterialPrintJobButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addMaterialPrintJobButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namePrintJobText)
                            .addComponent(printerSelectionPrintJobComboBox, 0, 235, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(loadPrintJobButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletePrintJobButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(savePrintJobButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startPrintPrintJobButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newPrintJobButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addSubsection, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addSubsection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startPrintPrintJobButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPrintJobButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namePrintJobText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(materialSelectionPrintJobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(printerSelectionPrintJobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(masterSubsectionPane))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(addMaterialPrintJobButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeMaterialPrintJobButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(savePrintJobButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deletePrintJobButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(loadPrintJobButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addSubsectionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSubsectionMouseReleased
        ((MasterSubsectionPane)this.masterSubsectionPane).addNewSubsectionPanel();
        this.masterSubsectionPane.revalidate();
    }//GEN-LAST:event_addSubsectionMouseReleased

    private void newPrintJobButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPrintJobButtonMouseReleased
        ((MasterSubsectionPane)this.masterSubsectionPane).removeAllSubsectionsAndCreateNew();
        PrintJobPanel.extruderMaterialArrayListForPrintJob = new ArrayList<>();
        this.namePrintJobText.setText(null);
        this.updateUI();
    }//GEN-LAST:event_newPrintJobButtonMouseReleased

    private void addMaterialPrintJobButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMaterialPrintJobButtonMouseReleased
        int newExtruderNumber = PrintJobPanel.extruderMaterialArrayListForPrintJob.size()+1;
        if(newExtruderNumber > 99){
            JOptionPane.showMessageDialog(null, "Too many materials mapped to extruders please remove some before adding more." , "InfoBox: " + "Bad Field Data",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        PrintJobPanel.extruderMaterialArrayListForPrintJob.add(this.materialSelectionPrintJobComboBox.getSelectedItem().toString());
        this.extruderMaterialMapList.setModel(new javax.swing.AbstractListModel() {
                    @Override
                    public int getSize() { return PrintJobPanel.extruderMaterialArrayListForPrintJob.size(); }
                    @Override
                    public Object getElementAt(int i) { 
                        if(i<10)return "0"+i+"-"+PrintJobPanel.extruderMaterialArrayListForPrintJob.get(i); 
                        else return i+"-"+PrintJobPanel.extruderMaterialArrayListForPrintJob.get(i); 
                    }
                });
        updateSubsectionPanels();
        this.updateUI();
    }//GEN-LAST:event_addMaterialPrintJobButtonMouseReleased

    private void removeMaterialPrintJobButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMaterialPrintJobButtonMouseReleased
        if(this.extruderMaterialMapList.getSelectedIndex() == -1)return;
        PrintJobPanel.extruderMaterialArrayListForPrintJob.remove(this.extruderMaterialMapList.getSelectedIndex());
        this.updateUI();
    }//GEN-LAST:event_removeMaterialPrintJobButtonMouseReleased

    private void savePrintJobButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savePrintJobButtonMouseReleased
        if(this.namePrintJobText.getText()== null || this.namePrintJobText.getText()== ""){
            JOptionPane.showMessageDialog(null, "Please enter a name before saving." , "InfoBox: " + "Bad Field Data",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(this.printerSelectionPrintJobComboBox.getSelectedItem().toString()== null || this.printerSelectionPrintJobComboBox.getSelectedItem().toString()== ""){
            JOptionPane.showMessageDialog(null, "Please select a printer name before saving." , "InfoBox: " + "Bad Field Data",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            printJobController.savePrintJobConfiguration(this.namePrintJobText.getText(),this.printerSelectionPrintJobComboBox.getSelectedItem().toString() ,this.getMasterSubsectionPane().getPanels() );
        } catch (BadFieldException e) {
             JOptionPane.showMessageDialog(null, e.getMessage() , "InfoBox: " + "Bad Field Data",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_savePrintJobButtonMouseReleased

    private void loadPrintJobButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadPrintJobButtonMouseReleased
        if(this.printJobLList.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null, "Please select a print job before loading." , "InfoBox: " + "Bad Field Data",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ArrayList<String> varList = printJobController.loadPrintJobSelection(this.printJobLList.getSelectedValue().toString());
        this.namePrintJobText.setText(varList.get(0));
        System.out.println(varList.get(1));
        this.printerSelectionPrintJobComboBox.setSelectedItem(varList.get(1));
        this.extruderMaterialMapList.setModel(new javax.swing.AbstractListModel() {
                    @Override
                    public int getSize() { return PrintJobPanel.extruderMaterialArrayListForPrintJob.size(); }
                    @Override
                    public Object getElementAt(int i) { 
                        if(i<10)return "0"+i+"-"+PrintJobPanel.extruderMaterialArrayListForPrintJob.get(i); 
                        else return i+"-"+PrintJobPanel.extruderMaterialArrayListForPrintJob.get(i); 
                    }
                });
        this.updateUI();
    }//GEN-LAST:event_loadPrintJobButtonMouseReleased

    private void loadPrintJobButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPrintJobButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadPrintJobButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMaterialPrintJobButton;
    private javax.swing.JButton addSubsection;
    private javax.swing.JButton deletePrintJobButton;
    private javax.swing.JList extruderMaterialMapList;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton loadPrintJobButton;
    private javax.swing.JScrollPane masterSubsectionPane;
    private javax.swing.JComboBox materialSelectionPrintJobComboBox;
    private javax.swing.JTextField namePrintJobText;
    private javax.swing.JButton newPrintJobButton;
    private javax.swing.JList printJobLList;
    private javax.swing.JComboBox printerSelectionPrintJobComboBox;
    private javax.swing.JButton removeMaterialPrintJobButton;
    private javax.swing.JButton savePrintJobButton;
    private javax.swing.JButton startPrintPrintJobButton;
    // End of variables declaration//GEN-END:variables
}
