/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.form.concert;

import view.form.componenet.table.SetlistTableModel;
import domain.Band;
import domain.Concert;
import domain.Song;
import domain.SongPerformance;
import domain.Stage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import operation.Operation;
import transfer.Response;
import controller.Controller;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FormConcert extends javax.swing.JDialog {
    
    private Concert concert;

    /**
     * Creates new form FormConcert2
     */
    public FormConcert(java.awt.Frame owner, boolean modal, Concert concert) {
        initComponents();
        this.concert = concert;
        fillConcertInfo();
        fillSongsCombobox();
        updateConcertFormInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConcert = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblStartTime = new javax.swing.JLabel();
        lblBand = new javax.swing.JLabel();
        lblStage = new javax.swing.JLabel();
        txtStartTime = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        cmbBand = new javax.swing.JComboBox<>();
        cmbStage = new javax.swing.JComboBox<>();
        pnlSetlist = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbOriginalSong = new javax.swing.JComboBox();
        txtLength = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSetlist = new javax.swing.JTable();
        btnAddToSetlist = new javax.swing.JButton();
        btnRemoveSong = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnEnableChanges = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlConcert.setBorder(javax.swing.BorderFactory.createTitledBorder("Concert"));

        lblID.setText("ID:");

        lblStartTime.setText("Start time:");

        lblBand.setText("Band:");

        lblStage.setText("Stage:");

        txtStartTime.setEnabled(false);

        txtID.setEnabled(false);

        cmbBand.setEnabled(false);

        cmbStage.setEnabled(false);

        pnlSetlist.setBorder(javax.swing.BorderFactory.createTitledBorder("Setlist"));

        jLabel1.setText("Original song:");

        jLabel2.setText("Length:");

        cmbOriginalSong.setEnabled(false);

        txtLength.setEnabled(false);

        tblSetlist.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSetlist);

        btnAddToSetlist.setText("Add to setlist");
        btnAddToSetlist.setEnabled(false);
        btnAddToSetlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToSetlistActionPerformed(evt);
            }
        });

        btnRemoveSong.setText("Remove from setlist");
        btnRemoveSong.setEnabled(false);
        btnRemoveSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSetlistLayout = new javax.swing.GroupLayout(pnlSetlist);
        pnlSetlist.setLayout(pnlSetlistLayout);
        pnlSetlistLayout.setHorizontalGroup(
            pnlSetlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSetlistLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlSetlistLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlSetlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(46, 46, 46)
                .addGroup(pnlSetlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSetlistLayout.createSequentialGroup()
                        .addComponent(btnAddToSetlist, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveSong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cmbOriginalSong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLength))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSetlistLayout.setVerticalGroup(
            pnlSetlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSetlistLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlSetlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbOriginalSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSetlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSetlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddToSetlist)
                    .addComponent(btnRemoveSong))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout pnlConcertLayout = new javax.swing.GroupLayout(pnlConcert);
        pnlConcert.setLayout(pnlConcertLayout);
        pnlConcertLayout.setHorizontalGroup(
            pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConcertLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStartTime)
                    .addComponent(lblBand)
                    .addComponent(lblID)
                    .addComponent(lblStage))
                .addGap(61, 61, 61)
                .addGroup(pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID)
                    .addComponent(txtStartTime)
                    .addComponent(cmbBand, 0, 256, Short.MAX_VALUE)
                    .addComponent(cmbStage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(pnlConcertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConcertLayout.createSequentialGroup()
                        .addComponent(pnlSetlist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlConcertLayout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnableChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlConcertLayout.setVerticalGroup(
            pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConcertLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartTime)
                    .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBand)
                    .addComponent(cmbBand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStage)
                    .addComponent(cmbStage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlSetlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlConcertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel)
                    .addComponent(btnEnableChanges))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConcert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConcert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToSetlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToSetlistActionPerformed
        try {
            Integer length = Integer.valueOf(txtLength.getText().trim());
            Song originalSong = (Song) cmbOriginalSong.getSelectedItem();
            SongPerformance songPerformance = new SongPerformance(length, originalSong, concert);
            ((SetlistTableModel) tblSetlist.getModel()).addSongPerformance(songPerformance);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please insert length in correct manner" + ex.getMessage(), "Parsing error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Parsing error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddToSetlistActionPerformed

    private void btnRemoveSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSongActionPerformed
        int[] selectedRows = tblSetlist.getSelectedRows();
        System.out.println("selected rows: " + Arrays.stream(selectedRows)
                .mapToObj(selectedRow -> String.valueOf(selectedRow))
                .collect(Collectors.joining(", ")));
        
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "You must select columns to delete from table", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (selectedRows.length > 1) {
            JOptionPane.showMessageDialog(this, "You can only delete one item at the  time", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Arrays.stream(selectedRows).forEach(selectedRow -> {
            ((SetlistTableModel) tblSetlist.getModel()).removeAt(selectedRow);
            //            concert.getSetlist().remove(selectedRow);
            ((SetlistTableModel) tblSetlist.getModel()).setSetlist(concert.getSetlist());
        });
    }//GEN-LAST:event_btnRemoveSongActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        updateConcertFormInfo();
        
        final int selectedOption = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + this.concert + "!?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selectedOption != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            Response response = Controller.getInstance().deleteConcert(this.concert);

            if (response.getException() == null && response.getResult().equals(true)) {
                JOptionPane.showMessageDialog(this, "Concert " + this.concert + " is successfully deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            updateConcertInfo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Insert proper format for date\n" + ex.getMessage(), "Parse Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        final int selectedOption = JOptionPane.showConfirmDialog(this, "Are you sure you want to update " + this.concert + "!?", "Update", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (selectedOption != JOptionPane.OK_OPTION) {
            return;
        }
        
        try {
            Response response = Controller.getInstance().updateConcert(this.concert);
            if (response.getException() == null) {
                this.concert = (Concert) response.getResult();
                updateConcertFormInfo();
                JOptionPane.showMessageDialog(this, "Concert " + this.concert + " is successfully updated!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnEnableChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnableChangesActionPerformed
        txtStartTime.setEnabled(true);
        cmbStage.setEnabled(true);
        
        cmbOriginalSong.setEnabled(true);
        txtLength.setEnabled(true);
        btnAddToSetlist.setEnabled(true);
        btnRemoveSong.setEnabled(true);
        
        btnCancel.setEnabled(true);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_btnEnableChangesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToSetlist;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEnableChanges;
    private javax.swing.JButton btnRemoveSong;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Band> cmbBand;
    private javax.swing.JComboBox cmbOriginalSong;
    private javax.swing.JComboBox<Stage> cmbStage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBand;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblStage;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JPanel pnlConcert;
    private javax.swing.JPanel pnlSetlist;
    private javax.swing.JTable tblSetlist;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLength;
    private javax.swing.JTextField txtStartTime;
    // End of variables declaration//GEN-END:variables

    private void updateConcertFormInfo() {
        if (Objects.isNull(concert)) {
            return;
        }
        txtID.setText(String.valueOf(concert.getId()));
        txtStartTime.setText(new SimpleDateFormat("yyyy-MM-dd").format(concert.getStartTime()));
        cmbBand.setSelectedItem(concert.getBand());
        cmbStage.setSelectedItem(concert.getStage());
        tblSetlist.setModel(new SetlistTableModel(concert.getSetlist()));
    }
    
    private void updateConcertInfo() throws Exception {
        if (Objects.nonNull(concert) && Objects.nonNull(concert.getId())) {
            concert.setId(Long.valueOf(txtID.getText()));
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date starttime = dateFormat.parse(txtStartTime.getText().trim());
            concert.setStartTime(starttime);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Please insert date in proper format(yyyy-MM-dd)" + ex.getMessage(), "Parse Error", JOptionPane.ERROR_MESSAGE);
            throw ex;
        }
        
        concert.setBand((Band) cmbBand.getSelectedItem());
        concert.setStage((Stage) cmbStage.getSelectedItem());
        concert.setSetlist(((SetlistTableModel) tblSetlist.getModel()).getSetlist());
    }
    
    private void fillConcertInfo() {
        fillID();
        fillStartTime();
        fillComboBoxBands();
        filComboBoxStages();
        setComboBoxes();
        fillTableSetlist();
        
    }
    
    private void fillID() {
        if (concert != null) {
            txtID.setText(String.valueOf(concert.getConcertID()));
        }
    }
    
    private void fillStartTime() {
        if (concert != null) {
            txtStartTime.setText(new SimpleDateFormat("yyyy-MM-dd").format(concert.getStartTime()));
        }
    }
    
    private void fillComboBoxBands() {
        try {
            Response response = Controller.getInstance().getAllBands();
            if (response.getException() == null) {
                List<Band> allBands = (List<Band>) response.getResult();
                cmbBand.removeAllItems();
//                cmbBand.addItem(null);
                allBands.forEach(band -> cmbBand.addItem(band));
            } else {
                JOptionPane.showMessageDialog(this, response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void filComboBoxStages() {
        try {
            Response response = Controller.getInstance().getAllStages();
            if (response.getException() == null) {
                List<Stage> allStages = (List<Stage>) response.getResult();
                cmbStage.removeAllItems();
//                cmbStage.addItem(null);
                allStages.forEach(stage -> cmbStage.addItem(stage));
            } else {
                JOptionPane.showMessageDialog(this, response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void fillTableSetlist() {
        if (concert != null) {
            tblSetlist.setModel(new SetlistTableModel(concert.getSetlist()));
        }
    }
    
    private void setComboBoxes() {
        if (Objects.isNull(concert) || Objects.isNull(concert.getConcertID())) {
            return;
        }
        cmbBand.setSelectedItem(concert.getBand());
        cmbStage.setSelectedItem(concert.getStage());
    }
    
    private void fillSongsCombobox() {
        List<Song> songs = getAllSongs();
        cmbOriginalSong.setModel(new DefaultComboBoxModel<>(songs.toArray()));
    }
    
    private List<Song> getAllSongs() {
        try {
            Response response = Controller.getInstance().getAllSongs();
            if (response.getException() == null) {
                return (List<Song>) response.getResult();
            } else {
                JOptionPane.showMessageDialog(this, response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return Collections.EMPTY_LIST;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return Collections.EMPTY_LIST;
        }
    }
    
}
