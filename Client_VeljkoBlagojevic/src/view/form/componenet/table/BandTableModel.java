/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.componenet.table;

import domain.Band;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VeljkoBlagojevic
 */
public class BandTableModel extends AbstractTableModel {

    private final List<Band> bands;

    private final String[] columnNames = {"ID", "Name", "formationYear", "biography", "website"};
    private final Class<?>[] classes = {Long.class, String.class, Integer.class, String.class, String.class};

    public BandTableModel(List<Band> bands) {
        this.bands = bands;
    }

    @Override
    public int getRowCount() {
        return Objects.isNull(bands) ? 0 : bands.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Band band = bands.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                band.getBandID();
            case 1 ->
                band.getName();
            case 2 ->
                band.getFormationYear();
            case 3 ->
                band.getBiography();
            case 4 ->
                band.getWebsite();
            default ->
                "N/A";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Band band = bands.get(rowIndex);
        switch (columnIndex) {
            case 0 ->
                band.setBandID((Long) aValue);
            case 1 ->
                band.setName(String.valueOf(aValue));
            case 2 ->
                band.setFormationYear((Integer) aValue);
            case 3 ->
                band.setBiography(String.valueOf(aValue));
            case 4 ->
                band.setWebsite(String.valueOf(aValue));
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    public void addBand(Band band) {
        bands.add(band);
        //fireTableDataChanged();
        fireTableRowsInserted(bands.size() - 1, bands.size() - 1);
    }

    public Band getBandAt(int row) {
        return bands.get(row);
    }

    public List<Band> getBands() {
        return bands;
    }


}
