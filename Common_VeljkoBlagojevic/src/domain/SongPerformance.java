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
public class SongPerformance /* Izvodjenje pesme */ implements GenericEntity {

    private Long songPerformanceID;     //izvodjenjeID
    private Integer length;             //trajanje
    private Song originalSong;          //originalna (studijska) pesma
    private Concert concert;            //koncert / nastup

    public SongPerformance() {
    }

    public SongPerformance(Integer length, Song originalSong, Concert concert) {
        this.length = length;
        this.originalSong = originalSong;
        this.concert = concert;
    }

    public SongPerformance(Long songPerformanceID, Integer length, Song originalSong, Concert concert) {
        this.songPerformanceID = songPerformanceID;
        this.length = length;
        this.originalSong = originalSong;
        this.concert = concert;
    }

    public Long getSongPerformanceID() {
        return songPerformanceID;
    }

    public void setSongPerformanceID(Long songPerformanceID) {
        this.songPerformanceID = songPerformanceID;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Song getOriginalSong() {
        return originalSong;
    }

    public void setOriginalSong(Song originalSong) {
        this.originalSong = originalSong;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.songPerformanceID);
        hash = 73 * hash + Objects.hashCode(this.originalSong);
        hash = 73 * hash + Objects.hashCode(this.concert);
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
        final SongPerformance other = (SongPerformance) obj;
        if (!Objects.equals(this.originalSong, other.originalSong)) {
            return false;
        }
        return Objects.equals(this.concert, other.concert);
    }

    @Override
    public String toString() {
        return originalSong.getTitle() + " performed by " + concert.getBand().getName() + " on " + concert;
    }

    @Override
    public String getTableName() {
        return "song_performance";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "length, original_song_id, concert_id";
    }

    @Override
    public String getInsertValues() {
        return length + ", " + originalSong.getId() + ", " + concert.getId();
    }

    @Override
    public void setId(Long id) {
        this.songPerformanceID = id;
    }

    @Override
    public Long getId() {
        return songPerformanceID;
    }

    @Override
    public Iterable<GenericEntity> selectList(ResultSet rs) throws SQLException {
        List<GenericEntity> dbSetlist = new ArrayList<>();
        try (rs) {
            while (rs.next()) {

                Band dbOriginalBand = new Band(
                        rs.getLong("original_band.id"),
                        rs.getString("original_band.name"),
                        rs.getInt("original_band.formation_year"),
                        rs.getString("original_band.biography"),
                        rs.getString("original_band.website"));

                Song dbOriginalSong = new Song(
                        rs.getLong("original_song.id"),
                        rs.getString("original_song.title"),
                        rs.getInt("original_song.length"),
                        dbOriginalBand);

                Band dbPerformingBand = new Band(
                        rs.getLong("performing_band.id"),
                        rs.getString("performing_band.name"),
                        rs.getInt("performing_band.formation_year"),
                        rs.getString("performing_band.biography"),
                        rs.getString("performing_band.website"));

                Stage dbStage = new Stage(
                        rs.getLong("stage_id"),
                        rs.getString("stage.name"),
                        rs.getString("location"),
                        rs.getInt("audience_capacity"),
                        rs.getInt("surface_area"));

                Concert dbConcert = new Concert(
                        rs.getLong("concert_id"),
                        rs.getDate("c.start_time"),
                        dbPerformingBand,
                        dbStage,
                        new ArrayList<>());

                SongPerformance dbSongPerformance = new SongPerformance(
                        rs.getLong("sp.id"),
                        rs.getInt("sp.length"),
                        dbOriginalSong,
                        dbConcert);

                dbSetlist.add(dbSongPerformance);
            }
        }
        return dbSetlist;
    }

    @Override
    public String getUpdateValues() {
        return "length = " + length + ", original_song_id = " + originalSong.getId() + ", concert_id = " + concert.getId();
    }

    @Override
    public String getAlias() {
        return "sp";
    }

    @Override
    public String getJoinClause(FetchType fetch) {
        if (fetch.equals(FetchType.LAZY)) {
            return "JOIN concert c ON (sp.concert_id = c.id)"
                    + " JOIN song original_song ON (sp.original_song_id = original_song.id)";
        }
        return "JOIN concert c ON (sp.concert_id = c.id)"
                + " JOIN song original_song ON (sp.original_song_id = original_song.id)"
                + " JOIN band original_band ON (original_song.band_id = original_band.id)"
                + " JOIN band performing_band ON (c.band_id = performing_band.id)"
                + " JOIN stage stage ON (c.stage_id = stage.id)";
    }

    @Override
    public Optional<GenericEntity> selectObject(ResultSet rs) {
        SongPerformance songPerformance;
        try {
            if (rs.next()) {

                Band originalBand = new Band(
                        rs.getLong("original_band.id"),
                        rs.getString("original_band.name"),
                        rs.getInt("original_band.formation_year"),
                        rs.getString("original_band.biography"),
                        rs.getString("original_band.website"));

                Song originalSong = new Song(
                        rs.getLong("original_song.id"),
                        rs.getString("original_song.title"),
                        rs.getInt("original_song.length"),
                        null
                );

                Band performingBand = new Band(
                        rs.getLong("performing_band.id"),
                        rs.getString("performing_band.name"),
                        rs.getInt("performing_band.formation_year"),
                        rs.getString("performing_band.biography"),
                        rs.getString("performing_band.website"));

                Stage stage = new Stage(
                        rs.getLong("stage.id"),
                        rs.getString("stage.name"),
                        rs.getString("stage.location"),
                        rs.getInt("stage.audience_capacity"),
                        rs.getInt("stage.surface_area"));

                Concert concert = new Concert(
                        rs.getLong("c.id"),
                        rs.getDate("c.start_time"),
                        performingBand,
                        stage,
                        null
                );

                songPerformance = new SongPerformance(
                        rs.getLong("sp.id"),
                        rs.getInt("sp.length"),
                        originalSong,
                        concert
                );
            } else {
                return Optional.empty();
            }
            return Optional.of(songPerformance);
        } catch (SQLException ex) {
            Logger.getLogger(Band.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return Optional.empty();
        }
    }

    @Override
    public void prepareParametrizedValues(PreparedStatement preparedStatement) {
        try {
            preparedStatement.setInt(1, length);
            preparedStatement.setLong(2, originalSong.getId());
            preparedStatement.setLong(3, concert.getId());
        } catch (SQLException ex) {
            Logger.getLogger(SongPerformance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
