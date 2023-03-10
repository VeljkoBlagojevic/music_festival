/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.form.band;

import controller.Controller;
import domain.Band;
import domain.Song;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import view.form.componenet.table.SongTableModel;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FormBand extends javax.swing.JDialog {
    
    private Band band;

    /**
     * Creates new form FormBand
     */
    public FormBand(java.awt.Frame parent, boolean modal, Band band) {
        initComponents();
        this.band = band;
        updateBandFormInfo();
        prepareSongs();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBand = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblFormationYear = new javax.swing.JLabel();
        lblWebsite = new javax.swing.JLabel();
        lblBiopraphy = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtFormationYear = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtWebsite = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBiography = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnEnableChanges = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSongs = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBand.setBorder(javax.swing.BorderFactory.createTitledBorder("Band:"));

        lblID.setText("ID:");

        lblName.setText("Name:");

        lblFormationYear.setText("Formation year:");

        lblWebsite.setText("Website:");

        lblBiopraphy.setText("Biography:");

        txtID.setEnabled(false);

        txtFormationYear.setEnabled(false);

        txtName.setEnabled(false);

        txtWebsite.setEnabled(false);

        txtBiography.setColumns(20);
        txtBiography.setLineWrap(true);
        txtBiography.setRows(5);
        txtBiography.setEnabled(false);
        jScrollPane1.setViewportView(txtBiography);

        javax.swing.GroupLayout pnlBandLayout = new javax.swing.GroupLayout(pnlBand);
        pnlBand.setLayout(pnlBandLayout);
        pnlBandLayout.setHorizontalGroup(
            pnlBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBandLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBandLayout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBandLayout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBandLayout.createSequentialGroup()
                        .addComponent(lblFormationYear, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFormationYear, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBandLayout.createSequentialGroup()
                        .addComponent(lblWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBandLayout.createSequentialGroup()
                        .addComponent(lblBiopraphy, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlBandLayout.setVerticalGroup(
            pnlBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBandLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormationYear)
                    .addComponent(txtFormationYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWebsite)
                    .addComponent(txtWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBandLayout.createSequentialGroup()
                        .addComponent(lblBiopraphy)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnEnableChanges.setText("Enable changes");
        btnEnableChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnableChangesActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Songs:"));

        tblSongs.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSongs.setEnabled(false);
        jScrollPane2.setViewportView(tblSongs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnableChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlBand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel)
                    .addComponent(btnEnableChanges))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnableChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnableChangesActionPerformed
        txtFormationYear.setEnabled(true);
        txtWebsite.setEnabled(true);
        txtBiography.setEnabled(true);
        
        btnCancel.setEnabled(true);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_btnEnableChangesActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        updateBandFormInfo();
        
        final int selectedOption = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + this.band + "!?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selectedOption != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            var response = Controller.getInstance().deleteBand(this.band);
            
            if (response.getException() == null && response.getResult().equals(true)) {
                JOptionPane.showMessageDialog(this, "Band " + this.band + " is succesuflly deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "System has not been able to delete the band!\n" + response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "System has not been able to delete the band!\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            updateBandInfo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Make sure to input valid arguments" + ex.getMessage(), "Parse Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        final int selectedOption = JOptionPane.showConfirmDialog(this, "Are you sure you want to update " + this.band + "!?", "Update", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selectedOption != JOptionPane.OK_OPTION) {
            return;
        }
        
        try {
            var response = Controller.getInstance().updateBand(this.band);
            if (response.getException() == null && response.getResult().equals(true)) {
                JOptionPane.showMessageDialog(this, "Band " + this.band + " is succesfully updated!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "System has not been able to update the band!\n" + response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "System has not been able to update the band!\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEnableChanges;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBiopraphy;
    private javax.swing.JLabel lblFormationYear;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblWebsite;
    private javax.swing.JPanel pnlBand;
    private javax.swing.JTable tblSongs;
    private javax.swing.JTextArea txtBiography;
    private javax.swing.JTextField txtFormationYear;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtWebsite;
    // End of variables declaration//GEN-END:variables

    private void updateBandFormInfo() {
        if (Objects.isNull(band)) {
            txtID.setText("");
            txtName.setText("");
            txtFormationYear.setText("");
            txtWebsite.setText("");
            txtBiography.setText("");
            return;
        }
        
        txtID.setText(String.valueOf(band.getBandID()));
        txtName.setText(band.getName());
        txtFormationYear.setText(String.valueOf(band.getFormationYear()));
        txtWebsite.setText(band.getWebsite());
        txtBiography.setText(band.getBiography());
    }
    
    private void prepareSongs() {
        List<Song> songs = new ArrayList<>();
        
        try {
            var response = Controller.getInstance().getAllSongsByBand(this.band);
            if (response.getException() == null) {
                songs = (List<Song>) response.getResult();
            } else {
                JOptionPane.showMessageDialog(this, response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        tblSongs.setModel(new SongTableModel(songs));
    }
    
    private void updateBandInfo() throws Exception {
        if (Objects.isNull(band)) {
            band = new Band();
        }
        if (!txtID.getText().isBlank()) {
            band.setBandID(Long.valueOf(txtID.getText()));
        }
        band.setName(txtName.getText());
        band.setFormationYear(Integer.valueOf(txtFormationYear.getText()));
        band.setWebsite(txtWebsite.getText());
        band.setBiography(txtBiography.getText());
    }
}
