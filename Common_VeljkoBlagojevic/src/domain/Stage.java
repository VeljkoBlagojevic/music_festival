/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class Stage /* Bina */ implements GenericEntity {

    private Long stageID;               //binaID
    private String name;                //naziv
    private String location;            //lokacija
    private Integer audienceCapacity;   //kapacitetPublike
    private Integer surfaceArea;        //povrsina

    public Stage() {
    }

    public Stage(String name, String location, Integer audienceCapacity, Integer surfaceArea) {
        this.name = name;
        this.location = location;
        this.audienceCapacity = audienceCapacity;
        this.surfaceArea = surfaceArea;
    }

    public Stage(Long stageID, String name, String location, Integer audienceCapacity, Integer surfaceArea) {
        this.stageID = stageID;
        this.name = name;
        this.location = location;
        this.audienceCapacity = audienceCapacity;
        this.surfaceArea = surfaceArea;
    }

    public Long getStageID() {
        return stageID;
    }

    public void setStageID(Long stageID) {
        this.stageID = stageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAudienceCapacity() {
        return audienceCapacity;
    }

    public void setAudienceCapacity(Integer audienceCapacity) {
        this.audienceCapacity = audienceCapacity;
    }

    public Integer getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Integer surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stage other = (Stage) obj;
        return Objects.equals(this.name, other.name);
    }


    @Override
    public String toString() {
        return name + " at " + location;
    }

    @Override
    public String getTableName() {
        return "stage";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, location, audience_capacity, surface_area";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', '" + location + "', " + audienceCapacity + ", " + surfaceArea;
    }

    @Override
    public void setId(Long id) {
        this.stageID = id;
    }

    @Override
    public Long getId() {
        return stageID;
    }

    @Override
    public Iterable<GenericEntity> selectList(ResultSet rs) throws SQLException {
        List<GenericEntity> stages = new ArrayList<>();
        try (rs) {
            while (rs.next()) {
                Stage stage = new Stage(
                        rs.getLong("stage.id"),
                        rs.getString("stage.name"),
                        rs.getString("stage.location"),
                        rs.getInt("stage.audience_capacity"),
                        rs.getInt("stage.surface_area"));
                stages.add(stage);
            }
        }
        return stages;
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', " + "location = '" + location + "', " + "audience_capacity = " + audienceCapacity + ", " + "surface_area = " + surfaceArea;
    }

    @Override
    public String getAlias() {
        return "stage";
    }

    @Override
    public String getJoinClause(FetchType fetch) {
        return "";
    }

    @Override
    public Optional<GenericEntity> selectObject(ResultSet rs) {
        Stage stage;
        try {
            if (rs.next()) {
                stage = new Stage(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("location"),
                        rs.getInt("surface_area")
                );
            } else {
                return Optional.empty();
            }
            return Optional.of(stage);
        } catch (SQLException ex) {
            Logger.getLogger(Band.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return Optional.empty();
        }
    }

}
