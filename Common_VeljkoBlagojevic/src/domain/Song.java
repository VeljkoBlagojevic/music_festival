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
public class Song /* Pesma */ implements GenericEntity {
    
    private Long songID;    //pesmaID
    private String title;   //naslov
    private Integer length; //trajanje
    private Band band;      //bend/izvodjac

    public Song() {
    }
    
    public Song(String title, Integer length, Band band) {
        this.title = title;
        this.length = length;
        this.band = band;
    }
    
    public Song(Long songID, String title, Integer length, Band band) {
        this.songID = songID;
        this.title = title;
        this.length = length;
        this.band = band;
    }
    
    public Long getSongID() {
        return songID;
    }
    
    public void setSongID(Long songID) {
        this.songID = songID;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Integer getLength() {
        return length;
    }
    
    public void setLength(Integer length) {
        this.length = length;
    }
    
    public Band getBand() {
        return band;
    }
    
    public void setBand(Band band) {
        this.band = band;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.songID);
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.length);
        hash = 67 * hash + Objects.hashCode(this.band);
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
        final Song other = (Song) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.songID, other.songID)) {
            return false;
        }
        if (!Objects.equals(this.length, other.length)) {
            return false;
        }
        return Objects.equals(this.band, other.band);
    }
    
    @Override
    public String toString() {
        return title + " by " + band;
    }
    
    @Override
    public String getTableName() {
        return "song";
    }
    
    @Override
    public String getColumnNamesForInsert() {
        return "title, length, band_id";
    }
    
    @Override
    public String getInsertValues() {
        return "'" + title + "', " + length + ", " + band.getId();
    }
    
    @Override
    public void setId(Long id) {
        this.songID = id;
    }
    
    @Override
    public Long getId() {
        return songID;
    }
    
    @Override
    public Iterable<GenericEntity> selectList(ResultSet rs) throws SQLException {
        List<GenericEntity> songs = new ArrayList<>();
        try (rs) {
            while (rs.next()) {
                Band band = new Band(
                        rs.getLong("band_id"),
                        rs.getString("name"),
                        rs.getInt("formation_year"),
                        rs.getString("biography"),
                        rs.getString("website"));
                Song song = new Song(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getInt("length"),
                        band);
                songs.add(song);
            }
        }
        return songs;
    }
    
    @Override
    public String getUpdateValues() {
        return "title = '" + title + "', " + "length = " + length + ", band_id = " + band.getId();
    }
    
    @Override
    public String getAlias() {
        return "song";
    }
    
    @Override
    public String getJoinClause(FetchType fetch) {
        return "JOIN band b ON (song.band_id = b.id)";
    }
    
    @Override
    public Optional<GenericEntity> selectObject(ResultSet rs) {
        Song song;
        try {
            if (rs.next()) {
                
                Band band = new Band(
                        rs.getLong("band_id"),
                        rs.getString("name"),
                        rs.getInt("formation_year"),
                        rs.getString("biography"),
                        rs.getString("website"));
                
                song = new Song(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getInt("length"),
                        band
                );
            } else {
                return Optional.empty();
            }
            return Optional.of(song);
        } catch (SQLException ex) {
            Logger.getLogger(Band.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return Optional.empty();
        }
    }
    
}
