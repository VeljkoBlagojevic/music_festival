package view.form.concert;

import controller.Controller;
import domain.Band;
import domain.Concert;
import domain.Stage;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import transfer.Response;
import view.form.componenet.table.ConcertTableModel;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FormViewConcerts extends javax.swing.JFrame {

    private TableModel model;

    /**
     * Creates new form FormViewBands
     */
    public FormViewConcerts() {
        initComponents();
        fillTableConcerts();
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
        tblConcerts = new javax.swing.JTable();
        btnDetails = new javax.swing.JButton();
        txtBandFilter = new javax.swing.JTextField();
        lblSearchBand = new javax.swing.JLabel();
        lblSearchStage = new javax.swing.JLabel();
        txtStageFilter = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(tblConcerts);

        btnDetails.setText("Details");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        txtBandFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBandFilterKeyTyped(evt);
            }
        });

        lblSearchBand.setText("Search band by name:");

        lblSearchStage.setText("Search stage by name:");

        txtStageFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStageFilterKeyTyped(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSearchBand)
                                    .addComponent(lblSearchStage))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStageFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                                    .addComponent(txtBandFilter))
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 511, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSearchBand)
                            .addComponent(txtBandFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStageFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearchStage)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnSearch)
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDetails)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        final int selectedItemsCount = tblConcerts.getSelectionModel().getSelectedItemsCount();
        if (selectedItemsCount == 0) {
            JOptionPane.showMessageDialog(this, "You have not selected concert you want to see details for!", "Invalid selection", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (selectedItemsCount > 1) {
            JOptionPane.showMessageDialog(this, "You have selected multiple concerts. Please select only one band you want to see details for!", "Invalid selection", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int selectedRow = tblConcerts.getSelectionModel().getSelectedIndices()[0];

        Concert concertWithoutSetlist = ((ConcertTableModel) tblConcerts.getModel()).getConcertAt(selectedRow);

        try {
            Response response = Controller.getInstance().findConcertByID(concertWithoutSetlist.getId());

            if (response.getException() == null) {
                Concert concertWithSetlist = (Concert) response.getResult();
                JOptionPane.showMessageDialog(this, "System has found the concert", "Found concert", JOptionPane.INFORMATION_MESSAGE);
                new FormConcert(this, false, concertWithSetlist).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "System has not found the concert\n" + response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "System has not found the concert\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void txtBandFilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBandFilterKeyTyped
//        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
//        tblConcerts.setRowSorter(sorter);
//
//        String text = txtFilter.getText();
//        if (text.length() == 0) {
//            sorter.setRowFilter(null);
//        } else {
//            try {
//                sorter.setRowFilter(RowFilter.regexFilter(text));
//            } catch (PatternSyntaxException pse) {
//                System.out.println("Bad regex pattern");
//            }
//        }

    }//GEN-LAST:event_txtBandFilterKeyTyped

    private void txtStageFilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStageFilterKeyTyped

    }//GEN-LAST:event_txtStageFilterKeyTyped

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        Band searchBandParam = new Band();
        searchBandParam.setName(txtBandFilter.getText());
        Stage searchStageParam = new Stage();
        searchStageParam.setName(txtStageFilter.getText());

        Concert searchConcertParam = new Concert();
        searchConcertParam.setBand(searchBandParam);
        searchConcertParam.setStage(searchStageParam);

        try {
            Response response = Controller.getInstance().getAllConcertsFiltered(searchConcertParam);

            if (response.getException() == null) {
                List<Concert> concerts = (List<Concert>) response.getResult();
                if (concerts.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "System has not found concerts with search criteria.\n", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "System has found concerts with search criteria.", "Found concerts", JOptionPane.INFORMATION_MESSAGE);
                }
                model = new ConcertTableModel(concerts);
                tblConcerts.setModel(model);
            } else {
                JOptionPane.showMessageDialog(this, "System has not found concerts with search criteria.\n" + response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "System has not found concerts with search criteria.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearchBand;
    private javax.swing.JLabel lblSearchStage;
    private javax.swing.JTable tblConcerts;
    private javax.swing.JTextField txtBandFilter;
    private javax.swing.JTextField txtStageFilter;
    // End of variables declaration//GEN-END:variables

    public void fillTableConcerts() {
        try {
            Response response = Controller.getInstance().getAllConcerts();

            if (response.getException() == null) {
                List<Concert> concerts = (List<Concert>) response.getResult();
                if (concerts.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "System has not found concerts.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "System has found concerts.", "Found concerts", JOptionPane.INFORMATION_MESSAGE);
                }
                model = new ConcertTableModel(concerts);
                tblConcerts.setModel(model);
            } else {
                JOptionPane.showMessageDialog(this, "System could not find concerts\n" + response.getException().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "System could not find concerts\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
