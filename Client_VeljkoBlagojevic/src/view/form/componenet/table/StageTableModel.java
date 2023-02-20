/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.componenet.table;

import domain.Stage;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VeljkoBlagojevic
 */
public class StageTableModel extends AbstractTableModel {

    private final List<Stage> stages;

    private final String[] columnNames = {"ID", "Name", "Location", "Audience Capacity", "Surface Area"};
    private final Class<?>[] classes = {Long.class, String.class, String.class, Integer.class, Integer.class};

    public StageTableModel(List<Stage> stages) {
        this.stages = stages;
    }

    @Override
    public int getRowCount() {
        return Objects.isNull(stages) ? 0 : stages.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stage stage = stages.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                stage.getStageID();
            case 1 ->
                stage.getName();
            case 2 ->
                stage.getLocation();
            case 3 ->
                stage.getAudienceCapacity();
            case 4 ->
                stage.getSurfaceArea();
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
        Stage stage = stages.get(rowIndex);
        switch (columnIndex) {
            case 0 ->
                stage.setStageID((Long) aValue);
            case 1 ->
                stage.setName(String.valueOf(aValue));
            case 2 ->
                stage.setLocation(String.valueOf(aValue));
            case 3 ->
                stage.setAudienceCapacity((Integer) aValue);
            case 4 ->
                stage.setSurfaceArea((Integer) aValue);
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

    public void addStage(Stage stage) {
        stages.add(stage);
        //fireTableDataChanged();
        fireTableRowsInserted(stages.size() - 1, stages.size() - 1);
    }

    public Stage getStageAt(int row) {
        return stages.get(row);
    }
}
