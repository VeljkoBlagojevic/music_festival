/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.form.song;

import controller.Controller;
import domain.Band;
import domain.Song;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import transfer.Response;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FormInsertSong extends javax.swing.JDialog {

    private Song song;

    /**
     * Creates new form FormInsertSong
     */
    public FormInsertSong(java.awt.Frame parent, boolean modal) {
        initComponents();
        prepareForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSong = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblLength = new javax.swing.JLabel();
        lblBand = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtLength = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        cmbBand = new javax.swing.JComboBox();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlSong.setBorder(javax.swing.BorderFactory.createTitledBorder("Song:"));

        lblID.setText("ID:");

        lblTitle.setText("Title:");

        lblLength.setText("Length");

        lblBand.setText("Band:");

        txtID.setEnabled(false);

        javax.swing.GroupLayout pnlSongLayout = new javax.swing.GroupLayout(pnlSong);
        pnlSong.setLayout(pnlSongLayout);
        pnlSongLayout.setHorizontalGroup(
            pnlSongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSongLayout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSongLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSongLayout.createSequentialGroup()
                        .addComponent(lblLength, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLength, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSongLayout.createSequentialGroup()
                        .addComponent(lblBand, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbBand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlSongLayout.setVerticalGroup(
            pnlSongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlSongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLength)
                    .addComponent(txtLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBand)
                    .addComponent(cmbBand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (Objects.isNull(song)) {
            song = new Song();
        }

        try {
            updateSongInfo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Insert proper format for date\n" + ex.getMessage(), "Parse Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        final int selectedOption = JOptionPane.showConfirmDialog(this, "Are you sure you want to save " + this.song + "!?", "Save", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selectedOption != JOptionPane.OK_OPTION) {
            return;
        }

        try {
            Response response = Controller.getInstance().saveSong(this.song);

            if (response.getException() == null) {
                this.song = (Song) response.getResult();
                updateSongFormInfo();
                JOptionPane.showMessageDialog(this, "Song " + this.song + " is succesuflly saved!", "Success!", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "System could not save the song\n" + response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "System could not save the song\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void updateSongFormInfo() {
        if (Objects.isNull(song)) {
            return;
        }

        txtID.setText(String.valueOf(song.getSongID()));
        txtTitle.setText(song.getTitle());
        txtLength.setText(String.valueOf(song.getLength()));
        cmbBand.setSelectedItem(song.getBand());
    }

    private void updateSongInfo() throws Exception {
        if (Objects.nonNull(song) && Objects.nonNull(song.getSongID())) {
            song.setSongID(Long.valueOf(txtID.getText()));
        }
        song.setTitle(txtTitle.getText());
        song.setLength(Integer.valueOf(txtLength.getText()));
        song.setBand((Band) cmbBand.getSelectedItem());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbBand;
    private javax.swing.JLabel lblBand;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLength;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlSong;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLength;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        prepareBandsCombobox();
    }

    private void prepareBandsCombobox() {
        List<Band> bands = getAllBands();
        cmbBand.setModel(new DefaultComboBoxModel<>(bands.toArray()));
    }

    private List<Band> getAllBands() {
        try {
            Response response = Controller.getInstance().getAllBands();
            if (response.getException() == null) {
                var bands = (List<Band>) response.getResult();
                if (bands.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ssstem could not found bands\n", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Ssstem has found bands\n", "Found bands", JOptionPane.INFORMATION_MESSAGE);
                }
                return bands;
            } else {
                JOptionPane.showMessageDialog(this, "Ssstem could not find bands\n" + response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return Collections.EMPTY_LIST;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ssstem could not find bands\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return Collections.EMPTY_LIST;

        }
    }
}
