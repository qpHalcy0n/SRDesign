/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Extruder;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.UserInterface.MainMenu.BadFieldException;
import ink3d.Util.InputValidationUtility;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class ExtruderGUI extends javax.swing.JPanel {
    private ExtruderController controller;
    /**
     * Creates new form ExtruderGUI
     */
    public ExtruderGUI() {
        this.controller = new ExtruderController();
        initComponents();
        loadExtruderConfigurationList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        commandPanel = new javax.swing.JPanel();
        newBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        loadBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        namePanel = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        selectionPanel = new javax.swing.JPanel();
        selectionScrollPane = new javax.swing.JScrollPane();
        extrudList = new javax.swing.JList();
        configPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel19 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nozzDiameterExtrudText = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        offsetYExtrudText = new javax.swing.JTextField();
        offsetXExtrudText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        customGCodeLbl = new javax.swing.JLabel();
        startGCodeLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        startGCodeTxtArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        endGCodeTxtArea = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        retractLengthExtrudeText = new javax.swing.JTextField();
        retractSpeedExtrudSpinner = new javax.swing.JSpinner();
        retractLayerChangeExtrudCheckBox = new javax.swing.JCheckBox();
        retractWipeExtrudCheckBox = new javax.swing.JCheckBox();
        retractLiftZExtrudeText = new javax.swing.JTextField();
        retractExtraLengthExtrudText = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        javax.swing.JTextField toolDisabledExtraLengthExtrudText = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerPanel.setLayout(new javax.swing.BoxLayout(headerPanel, javax.swing.BoxLayout.PAGE_AXIS));

        commandPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });
        commandPanel.add(newBtn);

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        commandPanel.add(saveBtn);

        loadBtn.setText("Load");
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });
        commandPanel.add(loadBtn);

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        commandPanel.add(deleteBtn);

        headerPanel.add(commandPanel);

        namePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        nameLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameLbl.setText("Name:");
        namePanel.add(nameLbl);

        nameTxt.setColumns(50);
        namePanel.add(nameTxt);

        headerPanel.add(namePanel);

        add(headerPanel, java.awt.BorderLayout.NORTH);

        selectionPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        selectionPanel.setPreferredSize(new java.awt.Dimension(200, 555));
        selectionPanel.setLayout(new java.awt.BorderLayout());

        selectionScrollPane.setMaximumSize(new java.awt.Dimension(32767, 33));
        selectionScrollPane.setPreferredSize(new java.awt.Dimension(200, 132));

        extrudList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        selectionScrollPane.setViewportView(extrudList);

        selectionPanel.add(selectionScrollPane, java.awt.BorderLayout.CENTER);

        add(selectionPanel, java.awt.BorderLayout.WEST);

        configPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        configPanel.setPreferredSize(new java.awt.Dimension(600, 555));
        configPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(600, 400));

        jPanel19.setBackground(new java.awt.Color(153, 153, 153));
        jPanel19.setFocusTraversalPolicyProvider(true);
        jPanel19.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel19.setPreferredSize(new java.awt.Dimension(400, 551));
        jPanel19.setLayout(new javax.swing.BoxLayout(jPanel19, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 10));
        jPanel17.setPreferredSize(new java.awt.Dimension(400, 121));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Size");

        jLabel7.setText("Nozzle diameter:");

        jLabel67.setText("mm");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(54, 54, 54)
                        .addComponent(nozzDiameterExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel67))
                    .addComponent(jLabel22))
                .addContainerGap(554, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nozzDiameterExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addGap(37, 37, 37))
        );

        jPanel19.add(jPanel17);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 10));
        jPanel11.setPreferredSize(new java.awt.Dimension(400, 90));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Position");

        jLabel5.setText("Extruder offset:");

        jLabel9.setText("x:");

        jLabel10.setText("y:");

        jLabel3.setText("mm");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(offsetXExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(offsetYExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(505, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(offsetYExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offsetXExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.add(jPanel11);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 10));
        jPanel1.setPreferredSize(new java.awt.Dimension(826, 800));

        customGCodeLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        customGCodeLbl.setText("Custom G-Code");

        startGCodeLbl.setText("Start G-Code");

        startGCodeTxtArea.setColumns(20);
        startGCodeTxtArea.setRows(5);
        jScrollPane1.setViewportView(startGCodeTxtArea);

        jLabel1.setText("End G-Code");

        endGCodeTxtArea.setColumns(20);
        endGCodeTxtArea.setRows(5);
        jScrollPane2.setViewportView(endGCodeTxtArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(startGCodeLbl)
                    .addComponent(customGCodeLbl)
                    .addComponent(jLabel1))
                .addContainerGap(410, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(customGCodeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startGCodeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel19.add(jPanel1);

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 10));
        jPanel12.setPreferredSize(new java.awt.Dimension(400, 298));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setText("Retraction");

        jLabel49.setText("Length:");

        jLabel50.setText("Lift Z:");

        jLabel51.setText("Speed:");

        jLabel52.setText("Extra length on restart:");

        jLabel53.setText("Minimum travel after retraction:");

        jLabel54.setText("Retract on layer change:");

        jLabel55.setText("Wipe while retracting:");

        jLabel56.setText("mm (zero disables)");

        jLabel57.setText("mm");

        jLabel58.setText("mm/s");

        jLabel59.setText("mm");

        jLabel60.setText("mm");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel48)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(retractLengthExtrudeText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(retractLiftZExtrudeText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(retractSpeedExtrudSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(retractExtraLengthExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel60))
                    .addComponent(retractLayerChangeExtrudCheckBox)
                    .addComponent(retractWipeExtrudCheckBox))
                .addContainerGap(459, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(retractLengthExtrudeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(retractLiftZExtrudeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(9, 9, 9)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(retractSpeedExtrudSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(retractExtraLengthExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retractLayerChangeExtrudCheckBox)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retractWipeExtrudCheckBox)
                    .addComponent(jLabel55))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.add(jPanel12);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 10));
        jPanel13.setPreferredSize(new java.awt.Dimension(400, 109));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel61.setText("Retraction when tool is disabled");

        jLabel62.setText("Length:");

        jLabel63.setText("Extra length on restart:");

        jLabel64.setText("mm (zero disables)");

        jLabel65.setText("mm");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addGap(73, 73, 73)
                                .addComponent(toolDisabledExtraLengthExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65))))
                .addContainerGap(457, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(toolDisabledExtraLengthExtrudText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel65)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.add(jPanel13);

        jScrollPane4.setViewportView(jPanel19);

        configPanel.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        add(configPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        // TODO add your handling code here:
        String extruderName = (String) extrudList.getSelectedValue();
        ExtruderConfiguration extruder = controller.loadExtruderConfiguration(extruderName);
        loadExtruder(extruder);
    }//GEN-LAST:event_loadBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            // TODO add your handling code here:
            ExtruderConfiguration extruder = getExtruderConfiguration();
            controller.saveExtruderConfiguration(extruder);
            loadExtruderConfigurationList();
        } catch (BadFieldException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), ex.getMessage(), JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ExtruderGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        String extruderName = (String) extrudList.getSelectedValue();
        controller.deleteExtruderConfiguration(extruderName);
        loadExtruderConfigurationList();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        // TODO add your handling code here:
        loadExtruder(new ExtruderConfiguration());
    }//GEN-LAST:event_newBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel commandPanel;
    private javax.swing.JPanel configPanel;
    private javax.swing.JLabel customGCodeLbl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextArea endGCodeTxtArea;
    private javax.swing.JList extrudList;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JButton loadBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JPanel namePanel;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JButton newBtn;
    private javax.swing.JTextField nozzDiameterExtrudText;
    private javax.swing.JTextField offsetXExtrudText;
    private javax.swing.JTextField offsetYExtrudText;
    private javax.swing.JTextField retractExtraLengthExtrudText;
    private javax.swing.JCheckBox retractLayerChangeExtrudCheckBox;
    private javax.swing.JTextField retractLengthExtrudeText;
    private javax.swing.JTextField retractLiftZExtrudeText;
    private javax.swing.JSpinner retractSpeedExtrudSpinner;
    private javax.swing.JCheckBox retractWipeExtrudCheckBox;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel selectionPanel;
    private javax.swing.JScrollPane selectionScrollPane;
    private javax.swing.JLabel startGCodeLbl;
    private javax.swing.JTextArea startGCodeTxtArea;
    // End of variables declaration//GEN-END:variables

    public ExtruderConfiguration getExtruderConfiguration() throws BadFieldException {
        ExtruderConfiguration extruder = new ExtruderConfiguration();
        
        String name = nameTxt.getText();
        if(InputValidationUtility.isStringEmpty(name)) {
            throw new BadFieldException("The name of the extruder must not be empty.");
        }

        double nozzleDiameter = InputValidationUtility.parseDouble("Nozzle Diameter", 
                nozzDiameterExtrudText.getText());
        extruder.setNozzleDiameter(nozzleDiameter);

        double offsetX = InputValidationUtility.parseDouble("Offset X", 
                offsetXExtrudText.getText());
        extruder.setxOffset(offsetX);

        double offsetY = InputValidationUtility.parseDouble("Offset Y", 
                offsetXExtrudText.getText());
        extruder.setxOffset(offsetY);

        // Does not matter if start/end G-Code is empty/null
        String startGCode = startGCodeTxtArea.getText();
        extruder.setStartGCode(startGCode);
        String endGCode = endGCodeTxtArea.getText();
        extruder.setEndGCode(endGCode);

        return extruder;
    }

    private void loadExtruder(ExtruderConfiguration extruder) {
        nameTxt.setText(extruder.getName());
        nozzDiameterExtrudText.setText(String.valueOf(extruder.getNozzleDiameter()));
        offsetXExtrudText.setText(String.valueOf(extruder.getxOffset()));
        offsetYExtrudText.setText(String.valueOf(extruder.getyOffset()));
        startGCodeTxtArea.setText(String.valueOf(extruder.getStartGCode()));
        endGCodeTxtArea.setText(String.valueOf(extruder.getEndGCode()));
    }

    private void loadExtruderConfigurationList() {
        this.extrudList.setModel(new AbstractListModel() {
            private final ExtruderController eController = new ExtruderController();

            @Override
            public int getSize() {
                // TODO:  Why is loadExtruderConfigurations returning null???
                // return this.eController.loadExtruderConfigurationList().size();

                // hardcode to make the supermenu load
                return 0;
            }

            @Override
            public Object getElementAt(int index) {
                return this.eController.loadExtruderConfigurationList().get(index);
            }
        });
    }

}
