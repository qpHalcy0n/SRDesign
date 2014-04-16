/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrintJob;

import ink3d.UserInterface.MainMenu.MainWindow;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Dan
 */
public class SubsectionPanel extends javax.swing.JPanel {
    private ArrayList<String> fileList;
    private ArrayList<String> extruderList;
    public PrintJobController printJobController;

    public ArrayList<String> getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList<String> fileList) {
        this.fileList = fileList;
    }

    public ArrayList<String> getExtruderList() {
        return extruderList;
    }

    public void setExtruderList(ArrayList<String> extruderList) {
        this.extruderList = extruderList;
    }
    
    /**
     * Creates new form SubsectionPanel
     */
    public SubsectionPanel() {
        fileList = new ArrayList<>();
        extruderList = new ArrayList<>();
        printJobController = new PrintJobController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        startSubsectionPrintJob = new javax.swing.JTextField();
        finishSubsectionPrintJob = new javax.swing.JTextField();
        removeSubsectionButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        fileListSubsection = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        extruderMaterialListSubsecion = new javax.swing.JList();
        fileSeletionSubsectoinComboBox = new javax.swing.JComboBox();
        extruderMaterailSubsectionComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        addFileSubsection = new javax.swing.JButton();
        removeFileSubsection = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        addExtruderSubsection = new javax.swing.JButton();
        removeExtruderSubsection = new javax.swing.JButton();

        jLabel1.setText("Subsection from:");

        startSubsectionPrintJob.setText("0");
        startSubsectionPrintJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSubsectionPrintJobActionPerformed(evt);
            }
        });

        finishSubsectionPrintJob.setText("0");

        removeSubsectionButton.setText("Remove");
        removeSubsectionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removeSubsectionButtonMouseReleased(evt);
            }
        });

        jLabel3.setText("Print Config:");

        jComboBox1.setModel(new DefaultComboBoxModel(this.printJobController.loadAvailablePrints().toArray()));

        fileListSubsection.setModel(new PrintJobListModel(fileList));
        jScrollPane2.setViewportView(fileListSubsection);

        extruderMaterialListSubsecion.setModel(new PrintJobListModel(extruderList));
        jScrollPane3.setViewportView(extruderMaterialListSubsecion);

        fileSeletionSubsectoinComboBox.setModel(new DefaultComboBoxModel(this.printJobController.loadAvailableFiles().toArray()));

        extruderMaterailSubsectionComboBox.setModel(new MaterialFileMatchingComboBoxModel());
        extruderMaterailSubsectionComboBox.setSelectedItem(1);

        jLabel4.setText("Associated Extruder");

        addFileSubsection.setText("Add File");
        addFileSubsection.setToolTipText("");
        addFileSubsection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addFileSubsectionMouseReleased(evt);
            }
        });
        addFileSubsection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileSubsectionActionPerformed(evt);
            }
        });

        removeFileSubsection.setText("Remove File");
        removeFileSubsection.setToolTipText("");
        removeFileSubsection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removeFileSubsectionMouseReleased(evt);
            }
        });
        removeFileSubsection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFileSubsectionActionPerformed(evt);
            }
        });

        jLabel5.setText("Files");

        addExtruderSubsection.setText("Add Extruder");
        addExtruderSubsection.setToolTipText("");
        addExtruderSubsection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExtruderSubsectionActionPerformed(evt);
            }
        });

        removeExtruderSubsection.setText("Remove Extruder");
        removeExtruderSubsection.setToolTipText("");
        removeExtruderSubsection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeExtruderSubsectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addFileSubsection, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeFileSubsection, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(fileSeletionSubsectoinComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(extruderMaterailSubsectionComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addExtruderSubsection, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(removeExtruderSubsection))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(startSubsectionPrintJob, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(finishSubsectionPrintJob, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeSubsectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeSubsectionButton)
                    .addComponent(finishSubsectionPrintJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startSubsectionPrintJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFileSubsection)
                    .addComponent(removeFileSubsection)
                    .addComponent(addExtruderSubsection)
                    .addComponent(removeExtruderSubsection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileSeletionSubsectoinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extruderMaterailSubsectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startSubsectionPrintJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSubsectionPrintJobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startSubsectionPrintJobActionPerformed

    private void removeFileSubsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFileSubsectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeFileSubsectionActionPerformed

    private void addExtruderSubsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExtruderSubsectionActionPerformed
        extruderList.add((String)this.extruderMaterailSubsectionComboBox.getSelectedItem());
        this.extruderMaterialListSubsecion.setModel(new PrintJobListModel(this.extruderList));
        updateUI();
    }//GEN-LAST:event_addExtruderSubsectionActionPerformed

    private void removeExtruderSubsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeExtruderSubsectionActionPerformed
        if(this.extruderMaterialListSubsecion.getSelectedIndex() ==-1){
            JOptionPane.showMessageDialog(null, "Please select an item to remove." , "InfoBox: " + "Invalid Remove",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        this.extruderList.remove(this.extruderMaterialListSubsecion.getSelectedIndex());
        this.extruderMaterialListSubsecion.setModel(new PrintJobListModel(this.extruderList));
        this.updateUI();
    }//GEN-LAST:event_removeExtruderSubsectionActionPerformed

    private void removeSubsectionButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeSubsectionButtonMouseReleased
        MainWindow.printJobPanel.getMasterSubsectionPane().removeSubsection(this);
        MainWindow.printJobPanel.updateUI();
    }//GEN-LAST:event_removeSubsectionButtonMouseReleased

    private void addFileSubsectionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addFileSubsectionMouseReleased
        if(fileList.contains((String)fileSeletionSubsectoinComboBox.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "There can be only one instance of a file per subsection." , "InfoBox: " + "Invalid Add",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        fileList.add((String)fileSeletionSubsectoinComboBox.getSelectedItem());
        fileListSubsection.setModel(new PrintJobListModel(this.fileList));
        updateUI();
    }//GEN-LAST:event_addFileSubsectionMouseReleased

    private void removeFileSubsectionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeFileSubsectionMouseReleased
        if(this.fileListSubsection.getSelectedIndex() ==-1){
            JOptionPane.showMessageDialog(null, "Please select an item to remove." , "InfoBox: " + "Invalid Remove",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        this.fileList.remove(this.fileListSubsection.getSelectedIndex());
        this.fileListSubsection.setModel(new PrintJobListModel(this.fileList));
        this.updateUI();
    }//GEN-LAST:event_removeFileSubsectionMouseReleased

    private void addFileSubsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileSubsectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addFileSubsectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExtruderSubsection;
    private javax.swing.JButton addFileSubsection;
    private javax.swing.JComboBox extruderMaterailSubsectionComboBox;
    private javax.swing.JList extruderMaterialListSubsecion;
    private javax.swing.JList fileListSubsection;
    private javax.swing.JComboBox fileSeletionSubsectoinComboBox;
    private javax.swing.JTextField finishSubsectionPrintJob;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton removeExtruderSubsection;
    private javax.swing.JButton removeFileSubsection;
    private javax.swing.JButton removeSubsectionButton;
    private javax.swing.JTextField startSubsectionPrintJob;
    // End of variables declaration//GEN-END:variables
}
