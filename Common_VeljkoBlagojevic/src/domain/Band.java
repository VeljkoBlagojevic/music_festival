/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class Band /* Bend / Izvodjac */ implements GenericEntity {

    private Long bandID;            //bendID
    private String name;            //naziv
    private Integer formationYear;  //godinaOsnivanja
    private String website;         //vebsajt
    private String biography;       //biografija

    public Band() {
    }

    public Band(String name, Integer formationYear, String biography, String website) {
        this.name = name;
        this.formationYear = formationYear;
        this.biography = biography;
        this.website = website;
    }

    public Band(Long bandID, String name, Integer formationYear, String biography, String website) {
        this.bandID = bandID;
        this.name = name;
        this.formationYear = formationYear;
        this.biography = biography;
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getFormationYear() {
        return formationYear;
    }

    public void setFormationYear(Integer formationYear) {
        this.formationYear = formationYear;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Long getBandID() {
        return bandID;
    }

    public void setBandID(Long bandID) {
        this.bandID = bandID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
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
        final Band other = (Band) obj;
        return Objects.equals(this.name, other.name);
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTableName() {
        return "band";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, formation_year, website, biography";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', " + formationYear + ", '" + website + "', '" + biography + "'";
    }

    @Override
    public Long getId() {
        return bandID;
    }

    @Override
    public void setId(Long id) {
        this.bandID = id;
    }

    @Override
    public Iterable<GenericEntity> selectList(ResultSet rs) throws SQLException {
        List<GenericEntity> bands = new ArrayList<>();
        try (rs) {
            while (rs.next()) {
                Band band = new Band(
                        rs.getLong("b.id"),
                        rs.getString("b.name"),
                        rs.getInt("b.formation_year"),
                        rs.getString("b.biography"),
                        rs.getString("b.website"));
                bands.add(band);
            }
        }
        return bands;
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', " + "formation_year = " + formationYear + ", website = '" + website + "', biography = '" + biography + "'";
    }

    @Override
    public String getAlias() {
        return "b";
    }

    @Override
    public String getJoinClause(FetchType fetch) {
        return "";
    }

    @Override
    public Optional<GenericEntity> selectObject(ResultSet rs) {
        Band band;
        try {
            if (rs.next()) {
                band = new Band(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("formation_year"),
                        rs.getString("biography"),
                        rs.getString("website"));
            } else {
                return Optional.empty();
            }
            return Optional.of(band);
        } catch (SQLException ex) {
            Logger.getLogger(Band.class.getName()).log(Level.SEVERE, null, ex);
            return Optional.empty();
        }
    }

}
