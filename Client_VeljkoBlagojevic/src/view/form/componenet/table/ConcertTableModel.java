/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.componenet.table;

import domain.Band;
import domain.Concert;
import domain.Stage;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VeljkoBlagojevic
 */
public class ConcertTableModel extends AbstractTableModel {

    private final List<Concert> concerts;

    private final String[] columnNames = {"ID", "Start time", "Band", "Stage"};
    private final Class<?>[] classes = {Long.class, Date.class, Band.class, Stage.class};

    public ConcertTableModel(List<Concert> concerts) {
        this.concerts = concerts;
    }

    @Override
    public int getRowCount() {
        return Objects.isNull(concerts) ? 0 : concerts.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Concert concert = concerts.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                concert.getConcertID();
            case 1 ->
                concert.getStartTime();
            case 2 ->
                concert.getBand();
            case 3 ->
                concert.getStage();
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
        Concert concert = concerts.get(rowIndex);
        switch (columnIndex) {
            case 0 ->
                concert.setConcertID((Long) aValue);
            case 1 ->
                concert.setStartTime((Date) aValue);
            case 2 ->
                concert.setBand((Band) aValue);
            case 3 ->
                concert.setStage((Stage) aValue);
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

    public void addConcert(Concert concert) {
        concerts.add(concert);
        //fireTableDataChanged();
        fireTableRowsInserted(concerts.size() - 1, concerts.size() - 1);
    }

    public Concert getConcertAt(int row) {
        return concerts.get(row);
    }
}
