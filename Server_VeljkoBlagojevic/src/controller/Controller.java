/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Band;
import domain.Concert;
import domain.Song;
import domain.Stage;
import domain.User;
import exception.UserNotFoundException;
import java.util.List;
import operation.band.DeleteBand;
import operation.band.FindAllBands;
import operation.band.SaveBand;
import operation.band.UpdateBand;
import operation.concert.DeleteConcert;
import operation.concert.FindAllConcerts;
import operation.concert.FindConcertById;
import operation.concert.SaveConcert;
import operation.concert.UpdateConcert;
import operation.song.DeleteSong;
import operation.song.FindAllSongs;
import operation.song.FindAllSongsByBand;
import operation.song.SaveSong;
import operation.song.UpdateSong;
import operation.stage.DeleteStage;
import operation.stage.FindAllStages;
import operation.stage.SaveStage;
import operation.stage.UpdateStage;
import operation.user.FindAllUsers;
import operation.user.SaveUser;
import operation.band.FindAllBandsFiltered;
import operation.concert.FindAllConcertsFiltered;
import operation.song.FindAllSongsFiltered;
import operation.stage.FindAllStagesFiltered;

/**
 *
 * @author VeljkoBlagojevic
 */
public class Controller {

    private static Controller controller;

    private Controller() {
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public User login(String username, String password) throws Exception {

        FindAllUsers findAllUsers = new FindAllUsers();
        findAllUsers.execute(new User());
        List<User> users = findAllUsers.getUsers();
        return users.stream()
                .filter(user -> user.hasAdequateCredentials(username, password))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException());
//        for (User user : users) {
//            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//                return user;
//            }
//        }
//        //return null;
//        throw new Exception("Unknown user!");
    }

    public List<Band> findAllBands() throws Exception {
        FindAllBands findAllBands = new FindAllBands();
        findAllBands.execute(new Band());
        return findAllBands.getBands();
    }

    public List<Band> findAllBands(Band searchBandParam) throws Exception {
        FindAllBandsFiltered findAllBandsFiltered = new FindAllBandsFiltered();
        findAllBandsFiltered.execute(searchBandParam);
        return findAllBandsFiltered.getBands();
//        return findAllBands().stream()
//                .filter(band -> band.getName().contains(filteringCriteria))
//                .toList();
    }

    public List<Stage> findAllStages() throws Exception {
        FindAllStages findAllStages = new FindAllStages();
        findAllStages.execute(new Stage());
        return findAllStages.getStages();
    }

    public User register(User requestedUser) throws Exception {
        SaveUser saveUser = new SaveUser();
        saveUser.execute(requestedUser);
        return saveUser.getUser();
    }

    public Stage saveStage(Stage stage) throws Exception {
        SaveStage saveStage = new SaveStage();
        saveStage.execute(stage);
        return saveStage.getStage();
    }

    public Band saveBand(Band band) throws Exception {
        SaveBand saveBand = new SaveBand();
        saveBand.execute(band);
        return saveBand.getBand();
    }

    public boolean updateStage(Stage stage) throws Exception {
        UpdateStage updateStage = new UpdateStage();
        updateStage.execute(stage);
        return updateStage.isSuccessful();
    }

    public boolean deleteStage(Stage stage) throws Exception {
        DeleteStage deleteStage = new DeleteStage();
        deleteStage.execute(stage);
        return deleteStage.isSuccessful();
    }

    public boolean updateBand(Band band) throws Exception {
        UpdateBand updateBand = new UpdateBand();
        updateBand.execute(band);
        return updateBand.isSuccessful();
    }

    public boolean deleteBand(Band band) throws Exception {
        DeleteBand deleteBand = new DeleteBand();
        deleteBand.execute(band);
        return deleteBand.isSuccessful();
    }

    public Song saveSong(Song song) throws Exception {
        SaveSong saveSong = new SaveSong();
        saveSong.execute(song);
        return saveSong.getSong();
    }

    public List<Song> findAllSongs() throws Exception {
        FindAllSongs findAllSongs = new FindAllSongs();
        findAllSongs.execute(new Song());
        return findAllSongs.getSongs();
    }

    public boolean updateSong(Song song) throws Exception {
        UpdateSong updateSong = new UpdateSong();
        updateSong.execute(song);
        return updateSong.isSuccessful();
    }

    public boolean deleteSong(Song song) throws Exception {
        DeleteSong deleteSong = new DeleteSong();
        deleteSong.execute(song);
        return deleteSong.isSuccessful();
    }

    public List<Song> findAllSongs(Band band) throws Exception {
        FindAllSongsByBand findAllSongsByBand = new FindAllSongsByBand();
        findAllSongsByBand.execute(band);
        return findAllSongsByBand.getSongsByBand();
    }

    public List<Song> findAllSongs(Song song) throws Exception {
        FindAllSongsFiltered findAllSongsFiltered = new FindAllSongsFiltered();
        findAllSongsFiltered.execute(song);
        return findAllSongsFiltered.getSongs();
    }

    public Concert saveConcert(Concert concert) throws Exception {
        SaveConcert saveConcert = new SaveConcert();
        saveConcert.execute(concert);
        return saveConcert.getConcert();
    }

    public List<Concert> findAllConcerts() throws Exception {
        FindAllConcerts findAllConcerts = new FindAllConcerts();
        findAllConcerts.execute(new Concert());
        return findAllConcerts.getConcerts();
    }

    public Concert updateConcert(Concert concert) throws Exception {
        UpdateConcert updateConcert = new UpdateConcert();
        updateConcert.execute(concert);
        return updateConcert.getUpdatedConcert();
    }

    public boolean deleteConcert(Concert concert) throws Exception {
        DeleteConcert deleteConcert = new DeleteConcert();
        deleteConcert.execute(concert);
        return deleteConcert.isSuccessful();
    }

    public Concert findConcertByID(Long concertID) throws Exception {
        FindConcertById findConcertByID = new FindConcertById();
        findConcertByID.execute(concertID);
        return findConcertByID.getConcert();
    }

    public List<Stage> findAllStages(Stage stage) throws Exception {
        FindAllStagesFiltered findAllStagesFiltered = new FindAllStagesFiltered();
        findAllStagesFiltered.execute(stage);
        return findAllStagesFiltered.getStages();
    }

    public List<Concert> findAllConcerts(Concert concert) throws Exception {
        FindAllConcertsFiltered findAllConcertsFiltered = new FindAllConcertsFiltered();
        findAllConcertsFiltered.execute(concert);
        return findAllConcertsFiltered.getConcerts();
    }

}
