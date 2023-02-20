/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class Concert /* Koncert / Nastup */ implements GenericEntity {

    private Long concertID;                         //koncertID
    private Date startTime;                         //vremePocetka
    private Band band;                              //bend/izvodjac
    private Stage stage;                            //bina
    private List<SongPerformance> setlist;          //izvodjenje pesmi 

    public Concert() {
        setlist = new ArrayList<>();
    }

    public Concert(Date startTime, Band band, Stage stage, List<SongPerformance> setlist) {
        this.startTime = startTime;
        this.band = band;
        this.stage = stage;
        this.setlist = setlist;
    }

    public Concert(Long concertID, Date startTime, Band band, Stage stage, List<SongPerformance> setlist) {
        this.concertID = concertID;
        this.startTime = startTime;
        this.band = band;
        this.stage = stage;
        this.setlist = setlist;
    }

    public Long getConcertID() {
        return concertID;
    }

    public void setConcertID(Long concertID) {
        this.concertID = concertID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public List<SongPerformance> getSetlist() {
        return setlist;
    }

    public void setSetlist(List<SongPerformance> setlist) {
        this.setlist = setlist;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Concert other = (Concert) obj;
        return Objects.equals(this.band, other.band);
    }

    @Override
    public String toString() {
        return "Concert of " + band + " starting at " + startTime + " on " + stage;
    }

    @Override
    public String getTableName() {
        return "concert";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "start_time, band_id, stage_id";
    }

    @Override
    public String getInsertValues() {
        return "'" + new SimpleDateFormat("yyyy-MM-dd").format(startTime) + "', " + band.getId() + ", " + stage.getId();
    }

    @Override
    public void setId(Long id) {
        this.concertID = id;
    }

    @Override
    public Long getId() {
        return concertID;
    }

    @Override
    public Iterable<GenericEntity> selectList(ResultSet rs) throws SQLException {
        List<GenericEntity> concerts = new ArrayList<>();
        try (rs) {
            while (rs.next()) {

                Band band = new Band(
                        rs.getLong("band_id"),
                        rs.getString("b.name"),
                        rs.getInt("formation_year"),
                        rs.getString("biography"),
                        rs.getString("website"));

                Stage stage = new Stage(
                        rs.getLong("stage_id"),
                        rs.getString("stage.name"),
                        rs.getString("location"),
                        rs.getInt("audience_capacity"),
                        rs.getInt("surface_area"));

                List<SongPerformance> setlist = new ArrayList<>();

                Concert concert = new Concert(
                        rs.getLong("id"),
                        rs.getDate("start_time"),
                        band,
                        stage,
                        setlist);

                concerts.add(concert);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return concerts;
    }

    @Override
    public String getUpdateValues() {
        return "start_time = '" + new SimpleDateFormat("yyyy-MM-dd").format(startTime) + "', band_id = " + band.getId() + ", stage_id = " + stage.getId();
    }

    @Override
    public String getAlias() {
        return "c";
    }

    @Override
    public String getJoinClause(FetchType fetch) {
        if (fetch.equals(FetchType.LAZY)) {
            return "JOIN band b ON (c.band_id = b.id)"
                    + " JOIN stage stage ON (c.stage_id = stage.id)";
        }
        return "JOIN band b ON (c.band_id = b.id)"
                + " JOIN stage stage ON (c.stage_id = stage.id)"
                + " JOIN song_performance sp ON (c.id = sp.concert_id)"
                + " JOIN song song ON (sp.original_song_id = song.id)"
                + " JOIN band original_band ON (song.band_id = original_band.id)";
    }

    @Override
    public Optional<GenericEntity> selectObject(ResultSet rs) {
        Concert dbConcert = new Concert();
        Band dbBand = null;
        Stage dbStage = null;
        List<SongPerformance> dbSetlist = new ArrayList<>();
        Long dbConcertID = null;
        java.sql.Date dbStartTime = null;

        try {
            while (rs.next()) {

                dbConcertID = rs.getLong("c.id");
                dbStartTime = rs.getDate("start_time");

                dbBand = new Band(
                        rs.getLong("b.id"),
                        rs.getString("b.name"),
                        rs.getInt("b.formation_year"),
                        rs.getString("b.biography"),
                        rs.getString("b.website"));

                dbStage = new Stage(
                        rs.getLong("stage.id"),
                        rs.getString("stage.name"),
                        rs.getString("stage.location"),
                        rs.getInt("stage.audience_capacity"),
                        rs.getInt("stage.surface_area"));

                Band dbOriginalBand = new Band(
                        rs.getLong("original_band.id"),
                        rs.getString("original_band.name"),
                        rs.getInt("original_band.formation_year"),
                        rs.getString("original_band.biography"),
                        rs.getString("original_band.website"));

                Song dbOriginalSong = new Song(
                        rs.getLong("song.id"),
                        rs.getString("song.title"),
                        rs.getInt("song.length"),
                        dbOriginalBand);

                SongPerformance dbSongPerformance = new SongPerformance(
                        rs.getLong("sp.id"),
                        rs.getInt("sp.length"),
                        dbOriginalSong,
                        dbConcert);

                dbSetlist.add(dbSongPerformance);
            }

            dbConcert.setId(dbConcertID);
            dbConcert.setStartTime(new java.util.Date(dbStartTime.getTime()));

            dbConcert.setBand(dbBand);
            dbConcert.setStage(dbStage);
            dbConcert.setSetlist(dbSetlist);

            return Optional.of(dbConcert);

        } catch (Exception ex) {
            Logger.getLogger(Band.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return Optional.empty();
        }
    }

}
