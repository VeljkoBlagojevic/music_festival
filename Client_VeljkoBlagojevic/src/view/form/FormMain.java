package view.form;

import view.form.stage.FormViewStages;
import view.form.stage.FormInsertStage;
import view.form.song.FormInsertSong;
import view.form.song.FormViewSongs;
import view.form.concert.FormInsertConcert;
import view.form.concert.FormViewConcerts;
import view.form.band.FormViewBands;
import view.form.band.FormInsertBand;
import communication.Communication;
import controller.Controller;
import domain.User;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import operation.Operation;

public class FormMain extends javax.swing.JFrame {
    
    private User currentlyLoggedInUser;

    /**
     * Creates new form FrmMain
     */
    public FormMain(User user) {
        super("Music Festival Application");
        initComponents();
        currentlyLoggedInUser = user;
        addOnCloseListener();
        setCurrentUser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCurrentUser = new javax.swing.JLabel();
        lblPicture = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jmenuBarMain = new javax.swing.JMenuBar();
        menuStage = new javax.swing.JMenu();
        miStageNew = new javax.swing.JMenuItem();
        miStageShowAll = new javax.swing.JMenuItem();
        menuBand = new javax.swing.JMenu();
        miBandNew = new javax.swing.JMenuItem();
        miBandShowAll = new javax.swing.JMenuItem();
        menuSong = new javax.swing.JMenu();
        miSongNew = new javax.swing.JMenuItem();
        miSongShowAll = new javax.swing.JMenuItem();
        menuConcert = new javax.swing.JMenu();
        miConcertNew = new javax.swing.JMenuItem();
        miConcertShowAll = new javax.swing.JMenuItem();
        jmenuAbout = new javax.swing.JMenu();
        jmiAboutSoftware = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        lblCurrentUser.setText("Welcome!");

        lblPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/form/transparentSmall.png"))); // NOI18N

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        menuStage.setText("Stage");

        miStageNew.setText("New");
        miStageNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miStageNewActionPerformed(evt);
            }
        });
        menuStage.add(miStageNew);

        miStageShowAll.setText("Show all");
        miStageShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miStageShowAllActionPerformed(evt);
            }
        });
        menuStage.add(miStageShowAll);

        jmenuBarMain.add(menuStage);

        menuBand.setText("Band");

        miBandNew.setText("New");
        miBandNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBandNewActionPerformed(evt);
            }
        });
        menuBand.add(miBandNew);

        miBandShowAll.setText("Show all");
        miBandShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBandShowAllActionPerformed(evt);
            }
        });
        menuBand.add(miBandShowAll);

        jmenuBarMain.add(menuBand);

        menuSong.setText("Song");

        miSongNew.setText("New");
        miSongNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSongNewActionPerformed(evt);
            }
        });
        menuSong.add(miSongNew);

        miSongShowAll.setText("Show all");
        miSongShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSongShowAllActionPerformed(evt);
            }
        });
        menuSong.add(miSongShowAll);

        jmenuBarMain.add(menuSong);

        menuConcert.setText("Concert");

        miConcertNew.setText("New");
        miConcertNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConcertNewActionPerformed(evt);
            }
        });
        menuConcert.add(miConcertNew);

        miConcertShowAll.setText("Show all");
        miConcertShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConcertShowAllActionPerformed(evt);
            }
        });
        menuConcert.add(miConcertShowAll);

        jmenuBarMain.add(menuConcert);

        jmenuAbout.setText("About");

        jmiAboutSoftware.setText("Software");
        jmiAboutSoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAboutSoftwareActionPerformed(evt);
            }
        });
        jmenuAbout.add(jmiAboutSoftware);

        jmenuBarMain.add(jmenuAbout);

        setJMenuBar(jmenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(lblPicture)
                .addGap(396, 396, 396))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addComponent(lblCurrentUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblCurrentUser)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addGap(48, 48, 48)
                .addComponent(lblPicture)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miStageShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miStageShowAllActionPerformed
        new FormViewStages().setVisible(true);
    }//GEN-LAST:event_miStageShowAllActionPerformed

    private void miStageNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miStageNewActionPerformed
        new FormInsertStage(this, false).setVisible(true);
//        new FormStage(this, true).setVisible(true);
    }//GEN-LAST:event_miStageNewActionPerformed

    private void jmiAboutSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAboutSoftwareActionPerformed
        new AboutSoftwareForm().setVisible(true);
    }//GEN-LAST:event_jmiAboutSoftwareActionPerformed

    private void miBandShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBandShowAllActionPerformed
        new FormViewBands().setVisible(true);
    }//GEN-LAST:event_miBandShowAllActionPerformed

    private void miBandNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBandNewActionPerformed
        new FormInsertBand(this, true).setVisible(true);
//        new FormBand(this, true, null).setVisible(true);
    }//GEN-LAST:event_miBandNewActionPerformed

    private void miSongNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSongNewActionPerformed
        new FormInsertSong(this, false).setVisible(true);
//        new FormSong(this, true, null).setVisible(true);
    }//GEN-LAST:event_miSongNewActionPerformed

    private void miSongShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSongShowAllActionPerformed
        new FormViewSongs().setVisible(true);
    }//GEN-LAST:event_miSongShowAllActionPerformed

    private void miConcertShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConcertShowAllActionPerformed
        new FormViewConcerts().setVisible(true);
    }//GEN-LAST:event_miConcertShowAllActionPerformed

    private void miConcertNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConcertNewActionPerformed
        new FormInsertConcert(this, false).setVisible(true);
//        new FormConcert(null).setVisible(true);

    }//GEN-LAST:event_miConcertNewActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        
        try {
            Controller.getInstance().logout();
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JMenu jmenuAbout;
    private javax.swing.JMenuBar jmenuBarMain;
    private javax.swing.JMenuItem jmiAboutSoftware;
    private javax.swing.JLabel lblCurrentUser;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JMenu menuBand;
    private javax.swing.JMenu menuConcert;
    private javax.swing.JMenu menuSong;
    private javax.swing.JMenu menuStage;
    private javax.swing.JMenuItem miBandNew;
    private javax.swing.JMenuItem miBandShowAll;
    private javax.swing.JMenuItem miConcertNew;
    private javax.swing.JMenuItem miConcertShowAll;
    private javax.swing.JMenuItem miSongNew;
    private javax.swing.JMenuItem miSongShowAll;
    private javax.swing.JMenuItem miStageNew;
    private javax.swing.JMenuItem miStageShowAll;
    // End of variables declaration//GEN-END:variables

//    public JLabel getLblCurrentUser() {
//        return lblCurrentUser;
//    }
    public JMenuItem getJmiInvoiceNew() {
        return miBandNew;
    }
    
    private void addOnCloseListener() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    Controller.getInstance().logout();
                    System.exit(0);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
    }

//    private void setCurrentUser() {
//        lblCurrentUser.setText("Welcome:" + user);
//    }
    private void setCurrentUser() {
        lblCurrentUser.setText("Welcome " + currentlyLoggedInUser);
    }
    
}
