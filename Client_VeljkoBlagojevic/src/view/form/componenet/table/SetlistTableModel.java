/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.componenet.table;

import domain.Band;
import domain.SongPerformance;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VeljkoBlagojevic
 */
public class SetlistTableModel extends AbstractTableModel {

    private List<SongPerformance> setlist;

    private final String[] columnNames = {"ID", "Title", "Original band", "Length"};
    private final Class<?>[] classes = {Long.class, String.class, Band.class, Integer.class};

    public SetlistTableModel(List<SongPerformance> setlist) {
        this.setlist = setlist;
    }

    @Override
    public int getRowCount() {
        return Objects.isNull(setlist) ? 0 : setlist.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SongPerformance song = setlist.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                song.getSongPerformanceID();
            case 1 ->
                song.getOriginalSong().getTitle();
            case 2 ->
                song.getOriginalSong().getBand();
            case 3 ->
                song.getLength();
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
        SongPerformance song = setlist.get(rowIndex);
        switch (columnIndex) {
            case 0 ->
                song.setSongPerformanceID((Long) aValue);
            case 1 ->
                song.getOriginalSong().setTitle(String.valueOf(aValue));
            case 2 ->
                song.getOriginalSong().setBand((Band) aValue);
            case 3 ->
                song.setLength((Integer) aValue);
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

    public void addSongPerformance(SongPerformance songPerformance) {
        setlist.add(songPerformance);
        //fireTableDataChanged();
        fireTableRowsInserted(setlist.size() - 1, setlist.size() - 1);
    }

    public void removeAt(int index) {
        setlist.remove(index);
        fireTableDataChanged();
    }

    public SongPerformance getSongPerformanceAt(int row) {
        return setlist.get(row);
    }

    public List<SongPerformance> getSetlist() {
        return setlist;
    }

    public void setSetlist(List<SongPerformance> setlist) {
        this.setlist = setlist;
    }

}
