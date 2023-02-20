/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.componenet.table;

import domain.Band;
import domain.Song;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VeljkoBlagojevic
 */
public class SongTableModel extends AbstractTableModel {

    private List<Song> songs;

    private final String[] columnNames = {"ID", "Title", "Length", "Band"};
    private final Class<?>[] classes = {Long.class, String.class, Integer.class, Band.class};

    public SongTableModel(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public int getRowCount() {
        return Objects.isNull(songs) ? 0 : songs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Song song = songs.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                song.getSongID();
            case 1 ->
                song.getTitle();
            case 2 ->
                song.getLength();
            case 3 ->
                song.getBand();
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
        Song song = songs.get(rowIndex);
        switch (columnIndex) {
            case 0 ->
                song.setSongID((Long) aValue);
            case 1 ->
                song.setTitle(String.valueOf(aValue));
            case 2 ->
                song.setLength((Integer) aValue);
            case 3 ->
                song.setBand((Band) aValue);
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

    public void addSong(Song song) {
        songs.add(song);
        //fireTableDataChanged();
        fireTableRowsInserted(songs.size() - 1, songs.size() - 1);
    }

    public Song getSongAt(int row) {
        return songs.get(row);
    }

}
