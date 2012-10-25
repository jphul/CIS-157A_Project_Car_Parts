/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.carPart.gui;

import project.carPart.query_db.*;
import project.carPart.code.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
        carMake.setSelectedIndex(-1);
        carModel.setEnabled(false);
        carYear.setEnabled(false);
        //TODO: Disable and then enable if engine table has data
        jTable_engineDesc.setEnabled(true);
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
        lblCarModel = new javax.swing.JLabel();
        carModel = new javax.swing.JComboBox();
        carMake = new javax.swing.JComboBox();
        lblCarMake = new javax.swing.JLabel();
        lblModelYear = new javax.swing.JLabel();
        carYear = new javax.swing.JComboBox();
        pane_engineDesc = new javax.swing.JScrollPane();
        jTable_engineDesc = new javax.swing.JTable();
        lblEngineDesc = new javax.swing.JLabel();
        lblEnginePart = new javax.swing.JLabel();
        pane_partDesc = new javax.swing.JScrollPane();
        jTable_partDesc = new javax.swing.JTable();
        lblVendor = new javax.swing.JLabel();
        cmbVendor = new javax.swing.JComboBox();
        cmbPart = new javax.swing.JComboBox();
        lblPart = new javax.swing.JLabel();
        frameVendor = new javax.swing.JInternalFrame();
        jLabel7 = new javax.swing.JLabel();
        partVendorComboBox = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        partNumberComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

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

        lblCarModel.setFont(lblCarModel.getFont().deriveFont(lblCarModel.getFont().getStyle() | java.awt.Font.BOLD));
        lblCarModel.setText("Car Model");

        carModel.setFont(carModel.getFont().deriveFont(carModel.getFont().getStyle() & ~java.awt.Font.BOLD));
        carModel.setDoubleBuffered(true);
        carModel.setEnabled(false);
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

        lblCarMake.setFont(lblCarMake.getFont().deriveFont(lblCarMake.getFont().getStyle() | java.awt.Font.BOLD));
        lblCarMake.setText("Car Make");

        lblModelYear.setFont(lblModelYear.getFont().deriveFont(lblModelYear.getFont().getStyle() | java.awt.Font.BOLD));
        lblModelYear.setText("Model Year");

        carYear.setFont(carYear.getFont().deriveFont(carYear.getFont().getStyle() & ~java.awt.Font.BOLD));
        carYear.setEnabled(false);
        carYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carYearActionPerformed(evt);
            }
        });

        jTable_engineDesc.setFont(jTable_engineDesc.getFont().deriveFont(jTable_engineDesc.getFont().getStyle() & ~java.awt.Font.BOLD));
        jTable_engineDesc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pane_engineDesc.setViewportView(jTable_engineDesc);

        lblEngineDesc.setFont(lblEngineDesc.getFont().deriveFont(lblEngineDesc.getFont().getStyle() | java.awt.Font.BOLD));
        lblEngineDesc.setText("Engine Description");

        lblEnginePart.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEnginePart.setText("Part Description");

        jTable_partDesc.setFont(jTable_partDesc.getFont().deriveFont(jTable_partDesc.getFont().getStyle() & ~java.awt.Font.BOLD));
        jTable_partDesc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pane_partDesc.setViewportView(jTable_partDesc);

        lblVendor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblVendor.setText("Vendor");

        cmbVendor.setEnabled(false);
        cmbVendor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbVendorItemStateChanged(evt);
            }
        });
        cmbVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVendorActionPerformed(evt);
            }
        });

        cmbPart.setEnabled(false);
        cmbPart.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPartItemStateChanged(evt);
            }
        });

        lblPart.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPart.setText("Part Number");

        javax.swing.GroupLayout frameMakerLayout = new javax.swing.GroupLayout(frameMaker.getContentPane());
        frameMaker.getContentPane().setLayout(frameMakerLayout);
        frameMakerLayout.setHorizontalGroup(
            frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameMakerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pane_engineDesc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pane_partDesc)
                    .addGroup(frameMakerLayout.createSequentialGroup()
                        .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEnginePart)
                            .addComponent(lblEngineDesc)
                            .addGroup(frameMakerLayout.createSequentialGroup()
                                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCarMake)
                                    .addComponent(carMake, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carModel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCarModel))
                                .addGap(18, 18, 18)
                                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblModelYear)
                                    .addComponent(carYear, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(frameMakerLayout.createSequentialGroup()
                                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblVendor))
                                .addGap(18, 18, 18)
                                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPart)
                                    .addComponent(cmbPart, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 203, Short.MAX_VALUE)))
                .addContainerGap())
        );
        frameMakerLayout.setVerticalGroup(
            frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameMakerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarMake)
                    .addComponent(lblCarModel)
                    .addComponent(lblModelYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEngineDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pane_engineDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVendor)
                    .addComponent(lblPart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameMakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEnginePart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pane_partDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabMaker.addTab("Maker", frameMaker);

        frameVendor.setVisible(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Vendors");
        jLabel7.setName("vendorLabel"); // NOI18N

        partVendorComboBox.setModel(new javax.swing.DefaultComboBoxModel(Menu_partMake.menu_partVendors()));
        partVendorComboBox.setName("vendorComboBox"); // NOI18N
        partVendorComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                partVendorComboBoxItemStateChanged(evt);
            }
        });
        partVendorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partVendorComboBoxActionPerformed(evt);
            }
        });
        partVendorComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                partVendorComboBoxFocusLost(evt);
            }
        });
        partVendorComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                partVendorComboBoxKeyReleased(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setCellSelectionEnabled(true);
        jScrollPane4.setViewportView(jTable2);

        partNumberComboBox.setName("partNumberComboBox"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Part Number");
        jLabel8.setName("partNumberLabel"); // NOI18N

        javax.swing.GroupLayout frameVendorLayout = new javax.swing.GroupLayout(frameVendor.getContentPane());
        frameVendor.getContentPane().setLayout(frameVendorLayout);
        frameVendorLayout.setHorizontalGroup(
            frameVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameVendorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(frameVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(partVendorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frameVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(partNumberComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        frameVendorLayout.setVerticalGroup(
            frameVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameVendorLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(frameVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frameVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameVendorLayout.createSequentialGroup()
                        .addGroup(frameVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(partVendorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(partNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                .addContainerGap())
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
            .addComponent(tabMaker, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carMakeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_carMakeItemStateChanged
        //Update the Car Make drop down with values from the DB
        
        carModel.setEnabled(false);
        
        carYear.setEnabled(false);
        jTable_engineDesc.setModel(new javax.swing.table.DefaultTableModel());
        cmbVendor.setEnabled(false);
        cmbVendor.setSelectedIndex(-1);
        cmbPart.setEnabled(false);
        cmbPart.setSelectedIndex(-1);
        jTable_partDesc.setModel(new javax.swing.table.DefaultTableModel());
        
        try {
            carModel.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_carModel(carMake.getSelectedItem().toString())));
            carModel.setSelectedIndex(-1);
            carModel.setEnabled(true);
        } catch (Exception e) {
            System.err.printf("ERROR in carMakeItemStateChanged: " + e.toString());
            carModel.setEnabled(false);
        }
    }//GEN-LAST:event_carMakeItemStateChanged

    private void carYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carYearActionPerformed
        // TODO add your handling code here:
        
        cmbVendor.setEnabled(false);
        cmbVendor.setSelectedIndex(-1);
        cmbPart.setEnabled(false);
        cmbPart.setSelectedIndex(-1);
        jTable_partDesc.setModel(new javax.swing.table.DefaultTableModel());
        
        try {
            //grab the values as objects from the drop downs
            Object carModel = this.carModel.getSelectedItem();
            Object carMake = this.carMake.getSelectedItem();
            Object carYear = this.carYear.getSelectedItem();

            if (carMake != null && carModel != null && carYear != null) { //if not null, let's update the year menu
                jTable_engineDesc.setModel(DbUtils.resultSetToTableModel(Table_carEngineDesc.table_carEngineDesc(carMake.toString(), carModel.toString(), carYear.toString())));
                jTable_engineDesc.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            JTable target = (JTable) e.getSource();
                            int row = target.getSelectedRow();
                            // pass this on to handler
                            engineSelectAction(target.getModel().getValueAt(row, DBQuery.RLINKCOL).toString());
                        }
                    }
                });
                jTable_engineDesc.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
                jTable_engineDesc.getActionMap().put("enter", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTable target = (JTable) e.getSource();
                        int row = target.getSelectedRow();
                        // pass this on to handler
                        engineSelectAction(target.getModel().getValueAt(row, DBQuery.RLINKCOL).toString());
                    }
                });
            }
        } catch (Exception e) {
            System.err.println("ERROR: in carYearActionPerformed: " + e.toString());
        }
    }//GEN-LAST:event_carYearActionPerformed

    private void engineSelectAction(String rlink) {
        // will handle the selection of an engine; populate vendor pulldown     
        cmbVendor.setEnabled(true);
        try {
            cmbVendor.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_vendor(rlink)));
            cmbVendor.setSelectedIndex(-1);
        } catch (Exception e) {
            System.err.printf("ERROR in engineSelectAction: " + e.toString());
        }
    }

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
            System.err.println("ERROR in carModelChanged: " + e.toString());
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
        
        jTable_engineDesc.setModel(new javax.swing.table.DefaultTableModel());
        cmbVendor.setEnabled(false);
        cmbVendor.setSelectedIndex(-1);
        cmbPart.setEnabled(false);
        cmbPart.setSelectedIndex(-1);
        jTable_partDesc.setModel(new javax.swing.table.DefaultTableModel());
        
        try {
            //grab the values as objects from the drop downs
            Object carModel = this.carModel.getSelectedItem();
            Object carMake = this.carMake.getSelectedItem();

            if (carMake != null && carModel != null) { //if not null, let's update the year menu
                System.out.println("attempting to update car year for: " + carMake.toString() + " , " + carModel.toString());
                carYear.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_carYears(carMake.toString(), carModel.toString())));
            }
        } catch (Exception e) {
            System.err.println("ERROR in carModelItemStateChanged: " + e.toString());
        }
        carYear.setEnabled(true);
    }//GEN-LAST:event_carModelItemStateChanged

    private void partVendorComboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_partVendorComboBoxKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_partVendorComboBoxKeyReleased

    private void partVendorComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_partVendorComboBoxItemStateChanged
        // TODO add your handling code here:
        String[] listItems = {"Item 1", "Item 2", "Item 3", "Item 4"};
        if(this.partVendorComboBox.getSelectedItem().toString().toUpperCase().contains("MOD"))
            listItems = this.modParts;
        if(this.partVendorComboBox.getSelectedItem().toString().toUpperCase().contains("ARS"))
            listItems = this.arsParts;
        if(this.partVendorComboBox.getSelectedItem().toString().toUpperCase().contains("BEH"))
            listItems = this.behParts;
        if(this.partVendorComboBox.getSelectedItem().toString().toUpperCase().contains("DAN"))
            listItems = this.danParts;
        this.partNumberComboBox.setModel(new DefaultComboBoxModel(listItems));
        //String currentSelectedPartVendor = this.partVendorComboBox.getSelectedItem().toString();
        //this.partNumberComboBox.setModel(new javax.swing.DefaultComboBoxModel(Menu_partMake.menu_PartNumbers(currentSelectedPartVendor)));
    }//GEN-LAST:event_partVendorComboBoxItemStateChanged

    private void cmbVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVendorActionPerformed
        cmbPart.setSelectedIndex(-1);
        cmbPart.setEnabled(true);
    }//GEN-LAST:event_cmbVendorActionPerformed

    private void cmbVendorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbVendorItemStateChanged
        cmbPart.setEnabled(false);
        
        cmbPart.setModel(new javax.swing.DefaultComboBoxModel());
        jTable_partDesc.setModel(new javax.swing.table.DefaultTableModel()); // clears table
        
        if (carMake.getSelectedItem() != null && carModel.getSelectedItem() != null && carYear.getSelectedItem() != null && jTable_engineDesc.getSelectedRow() != -1) {
            try {
                //grab the values as objects from the drop downs
                Object carPartVendor = cmbVendor.getSelectedItem();

                System.out.println("attempting to get parts for: " + carPartVendor.toString());
                String rlink = jTable_engineDesc.getModel().getValueAt(jTable_engineDesc.getSelectedRow(), DBQuery.RLINKCOL).toString();
                cmbPart.setModel(new javax.swing.DefaultComboBoxModel(Menu_carMake.menu_part(carPartVendor.toString(), rlink)));
                cmbPart.setSelectedIndex(-1);
            } catch (Exception e) {
                System.err.println("ERROR in cmbVendorItemStateChanged: " + e.toString());
            }
            cmbPart.setEnabled(true);
        }
    }//GEN-LAST:event_cmbVendorItemStateChanged

    private void cmbPartItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPartItemStateChanged
        try {
            if (carMake.getSelectedItem() != null && carModel.getSelectedItem() != null && carYear.getSelectedItem() != null && jTable_engineDesc.getSelectedRow() != -1 && cmbPart.getSelectedItem() != null) {
                Object carPart = cmbPart.getSelectedItem();

                System.out.println("attempting to get description for part: " + carPart.toString());
                jTable_partDesc.setModel(DbUtils.resultSetToTableModel(Table_partDesc.table_partDesc(cmbVendor.getSelectedItem().toString(), carPart.toString())));
            }
        } catch (Exception e) {
            System.err.println("ERROR: in cmbPartItemStateChanged: " + e.toString());
        }
    }//GEN-LAST:event_cmbPartItemStateChanged

    private void partVendorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partVendorComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partVendorComboBoxActionPerformed

    private void partVendorComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_partVendorComboBoxFocusLost
        // TODO add your handling code here:
        // update the list of part numbers

    }//GEN-LAST:event_partVendorComboBoxFocusLost

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
    private javax.swing.JComboBox cmbPart;
    private javax.swing.JComboBox cmbVendor;
    private javax.swing.JInternalFrame frameMaker;
    private javax.swing.JInternalFrame frameVendor;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable_engineDesc;
    private javax.swing.JTable jTable_partDesc;
    private javax.swing.JLabel lblCarMake;
    private javax.swing.JLabel lblCarModel;
    private javax.swing.JLabel lblEngineDesc;
    private javax.swing.JLabel lblEnginePart;
    private javax.swing.JLabel lblModelYear;
    private javax.swing.JLabel lblPart;
    private javax.swing.JLabel lblVendor;
    private javax.swing.JScrollPane pane_engineDesc;
    private javax.swing.JScrollPane pane_partDesc;
    private javax.swing.JComboBox partNumberComboBox;
    private javax.swing.JComboBox partVendorComboBox;
    private javax.swing.JTabbedPane tabMaker;
    // End of variables declaration//GEN-END:variables
        String[] arsParts = {"ARS1", "ARS2", "ARS3", "ARS4"};
        String[] modParts = {"MOD1", "MOD2", "MOD3", "MOD4"};
        String[] behParts = {"BEH1", "BEH2", "BEH3", "BEH4"};
        String[] danParts = {"DAN1", "DAN2", "DAN3", "DAN4"};
}
