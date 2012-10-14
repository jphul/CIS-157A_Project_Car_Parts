/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.carPart.gui;


import java.sql.*;
import project.carPart.query_db.*;
import project.carPart.code.*;
import javax.swing.table.*;


/**
 *
 * @author Jerry Phul
 */
public class CarPartMainScreen extends javax.swing.JFrame {

    /**
     * Creates new form CarPartMainScreen
     */
    public CarPartMainScreen() {
        initComponents();
        carMake.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_carMake()));
        carMake.setSelectedIndex(-1);
        carModel.setEnabled(false);
        carYear.setEnabled(false);
        //TODO: Disable and then enable if engine table has data
        jTable_enginePart.setEnabled(true);
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
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        tabMaker = new javax.swing.JTabbedPane();
        frameMaker = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        carModel = new javax.swing.JComboBox();
        carMake = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        carYear = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_enginePart = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_engineDesc = new javax.swing.JTable();
        frameVendor = new javax.swing.JInternalFrame();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabMaker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        frameMaker.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frameMaker.setVisible(true);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel1.setText("Car Model");

        carModel.setFont(carModel.getFont().deriveFont(carModel.getFont().getStyle() & ~java.awt.Font.BOLD));
        carModel.setDoubleBuffered(true);
        carModel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                carModelItemStateChanged(evt);
            }
        });
        carModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carModelActionPerformed(evt);
            }
        });
        carModel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                carModelChanged(evt);
            }
        });

        carMake.setFont(carMake.getFont().deriveFont(carMake.getFont().getStyle() & ~java.awt.Font.BOLD));
        carMake.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_carMake()));
        carMake.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                populateCarMakeMenu(evt);
            }
        });
        carMake.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                carMakeItemStateChanged(evt);
            }
        });

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel2.setText("Car Make");

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel3.setText("Model Year");

        carYear.setFont(carYear.getFont().deriveFont(carYear.getFont().getStyle() & ~java.awt.Font.BOLD));
        carYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carYearActionPerformed(evt);
            }
        });

        jTable_enginePart.setFont(jTable_enginePart.getFont().deriveFont(jTable_enginePart.getFont().getStyle() & ~java.awt.Font.BOLD));
        jScrollPane2.setViewportView(jTable_enginePart);

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel4.setText("Engine Description");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Engine Part");

        jTable_engineDesc.setFont(jTable_engineDesc.getFont().deriveFont(jTable_engineDesc.getFont().getStyle() & ~java.awt.Font.BOLD));
        jScrollPane3.setViewportView(jTable_engineDesc);

        javax.swing.GroupLayout frameMakerLayout = new javax.swing.GroupLayout(frameMaker.getContentPane());
        frameMaker.getContentPane().setLayout(frameMakerLayout);
        frameMakerLayout.setHorizontalGroup(
            frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameMakerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(frameMakerLayout.createSequentialGroup()
                        .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addGroup(frameMakerLayout.createSequentialGroup()
                                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(carMake, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carModel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(carYear, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 203, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        frameMakerLayout.setVerticalGroup(
            frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameMakerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabMaker.addTab("Maker", frameMaker);

        frameVendor.setVisible(true);

        javax.swing.GroupLayout frameVendorLayout = new javax.swing.GroupLayout(frameVendor.getContentPane());
        frameVendor.getContentPane().setLayout(frameVendorLayout);
        frameVendorLayout.setHorizontalGroup(
            frameVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        frameVendorLayout.setVerticalGroup(
            frameVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        tabMaker.addTab("Vendor", frameVendor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMaker, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMaker, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carMakeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_carMakeItemStateChanged
        //Update the Car Make drop down with values from the DB
        carModel.setEnabled(false);
        try {
            carModel.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_carModel(carMake.getSelectedItem().toString())));
            carModel.setSelectedIndex(-1);
            carModel.setEnabled(true);
        } catch (Exception e) {
            System.err.printf("ERROR: " + e.toString());
            carModel.setEnabled(false);
        }
    }//GEN-LAST:event_carMakeItemStateChanged

    private void carYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carYearActionPerformed
        // TODO add your handling code here:
        try {
            //grab the values as objects from the drop downs
            Object carModel = this.carModel.getSelectedItem();
            Object carMake = this.carMake.getSelectedItem();
            Object carYear = this.carYear.getSelectedItem();

            if(carMake != null && carModel != null && carYear != null) { //if not null, let's update the year menu
                jTable_enginePart.setModel(DbUtils.resultSetToTableModel(Table_carEngineDesc.table_carEngineDesc(carMake.toString(), carModel.toString(), carYear.toString())));
            }
        } catch(Exception e) {
            System.err.println("ERROR:" + e.toString());
        }
    }//GEN-LAST:event_carYearActionPerformed

    private void carModelChanged(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_carModelChanged
        //update the year drop down if the car make and model drop downs have changed and are populated
        carYear.setEnabled(false);
        try {
            //grab the values as objects from the drop downs
            Object carModel = this.carModel.getSelectedItem();
            Object carMake = this.carMake.getSelectedItem();

            if (carMake != null && carModel != null) { //if not null, let's update the year menu
                System.out.println("attempting to update car year for: " + carMake.toString() + " , " + carModel.toString());
                carYear.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_carYears(carMake.toString(), carModel.toString())));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        carYear.setEnabled(true);
    }//GEN-LAST:event_carModelChanged

    private void carModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carModelActionPerformed
        carYear.setSelectedIndex(-1);
        carYear.setEnabled(true);
    }//GEN-LAST:event_carModelActionPerformed

    private void populateCarMakeMenu(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_populateCarMakeMenu
        carMake.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_carMake()));
    }//GEN-LAST:event_populateCarMakeMenu

    private void carModelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_carModelItemStateChanged
        // TODO add your handling code here:
        carYear.setEnabled(false);
        try {
            //grab the values as objects from the drop downs
            Object carModel = this.carModel.getSelectedItem();
            Object carMake = this.carMake.getSelectedItem();

            if(carMake != null && carModel != null) { //if not null, let's update the year menu
                System.out.println("attempting to update car year for: " + carMake.toString() + " , " + carModel.toString());
                carYear.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_carYears(carMake.toString(), carModel.toString())));
            }
        } catch(Exception e) {
            System.err.println(e.toString());
        }
        carYear.setEnabled(true);
    }//GEN-LAST:event_carModelItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarPartMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarPartMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarPartMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarPartMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarPartMainScreen().setVisible(true);
            }
        });
        

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox carMake;
    private javax.swing.JComboBox carModel;
    private javax.swing.JComboBox carYear;
    private javax.swing.JInternalFrame frameMaker;
    private javax.swing.JInternalFrame frameVendor;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable_engineDesc;
    private javax.swing.JTable jTable_enginePart;
    private javax.swing.JTabbedPane tabMaker;
    // End of variables declaration//GEN-END:variables
}
