/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Import;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author courtney
 */
public class ImportGUI extends javax.swing.JPanel {
    private ImportController controller;
       
    /**
     * Creates new form ImportPanel
     */
    public ImportGUI() {
        this.controller = new ImportController();
        initComponents();
        StlList = new javax.swing.JList();
        StlList.setModel(
                new javax.swing.AbstractListModel() {
                    private ImportController controller = new ImportController();
                    @Override
                    public int getSize() { return controller.getStlFiles().size(); }
                    @Override
                    public Object getElementAt(int i) { return controller.getStlFiles().get(i); }
                    }
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        StlList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ImportButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();

        StlList.setModel(new javax.swing.AbstractListModel() {
            private ImportController  controller = new ImportController();
            public int getSize() { return controller.getStlFiles().size(); }
            public Object getElementAt(int i) { return controller.getStlFiles().get(i); }
        });
        jScrollPane1.setViewportView(StlList);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("STL Models");

        ImportButton.setText("Import");
        ImportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ImportButtonMouseReleased(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(207, 207, 207)
                            .addComponent(ImportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(44, 44, 44)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ImportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeleteButton))
                    .addGap(1, 1, 1)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(20, 20, 20)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ImportButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButtonMouseReleased
    final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if(!importController.importStl(file.getPath())){
                JOptionPane.showMessageDialog(null, "File Read Error", "InfoBox: " + "Unable to read file", JOptionPane.INFORMATION_MESSAGE);
            }         
            this.StlList.setModel(new javax.swing.AbstractListModel() {
                    private final ImportController  controller = new ImportController();
                    @Override
                    public int getSize() { return controller.getStlFiles().size(); }
                    @Override
                    public Object getElementAt(int i) { return controller.getStlFiles().get(i); }
                }
            );
            this.updateUI();
        }      
    }//GEN-LAST:event_ImportButtonMouseReleased

    private void DeleteButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseReleased
        String fileName = (String)StlList.getSelectedValue();
        if(!importController.deleteStl(fileName)){
            System.out.println(fileName);
            JOptionPane.showMessageDialog(null, "File Delete Error", "InfoBox: " + "Unable to delete file", JOptionPane.INFORMATION_MESSAGE);
        }
        this.StlList.setModel(new javax.swing.AbstractListModel() {
            private final ImportController  controller = new ImportController();
            @Override
            public int getSize() { return controller.getStlFiles().size(); }
            @Override
            public Object getElementAt(int i) { return controller.getStlFiles().get(i); }
        }
        );
    }//GEN-LAST:event_DeleteButtonMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton ImportButton;
    private javax.swing.JList StlList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
