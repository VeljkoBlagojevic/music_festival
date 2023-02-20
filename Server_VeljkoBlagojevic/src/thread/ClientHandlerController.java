/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.Controller;
import domain.Band;
import domain.Concert;
import domain.Song;
import domain.Stage;
import domain.User;
import java.util.List;
import transfer.Request;
import transfer.Response;
import transfer.StatusCode;

/**
 *
 * @author VeljkoBlagojevic
 */
public class ClientHandlerController {

    Response loginUser(Request request) throws Exception {
        User requestedUser = (User) request.getArgument();
        User loggedInUser = Controller.getInstance().login(requestedUser.getUsername(), requestedUser.getPassword());
        return new Response(loggedInUser, null, StatusCode.OK);
    }

    Response register(Request request) throws Exception {
        User requestedUser = (User) request.getArgument();
        User registeredUser = Controller.getInstance().register(requestedUser);
        return new Response(registeredUser, null, StatusCode.CREATED);
    }

    Response saveStage(Request request) throws Exception {
        Stage stage = (Stage) request.getArgument();
        Stage savedStage = Controller.getInstance().saveStage(stage);
        return new Response(savedStage, null, StatusCode.CREATED);
    }

    Response getAllStages(Request request) throws Exception {
        List<Stage> stages = Controller.getInstance().findAllStages();
        return new Response(stages, null, StatusCode.OK);
    }

    Response getAllStagesFiltered(Request request) throws Exception {
        List<Stage> stages = Controller.getInstance().findAllStages((Stage) request.getArgument());
        return new Response(stages, null, StatusCode.OK);
    }

    Response updateStage(Request request) throws Exception {
        boolean isStageSuccessfullyUpdated = Controller.getInstance().updateStage((Stage) request.getArgument());
        return new Response(isStageSuccessfullyUpdated, null, StatusCode.OK);
    }

    Response deleteStage(Request request) throws Exception {
        Stage stage = (Stage) request.getArgument();
        boolean isStageSuccessfullyDeleted = Controller.getInstance().deleteStage(stage);
        return new Response(isStageSuccessfullyDeleted, null, StatusCode.NO_CONTENT);
    }

    Response saveBand(Request request) throws Exception {
        Band band = (Band) request.getArgument();
        Band savedBand = Controller.getInstance().saveBand(band);
        return new Response(savedBand, null, StatusCode.CREATED);
    }

    Response getAllBands(Request request) throws Exception {
        List<Band> bands = Controller.getInstance().findAllBands();
        return new Response(bands, null, StatusCode.OK);
    }

    Response getAllBandsFiltered(Request request) throws Exception {
        List<Band> bands = Controller.getInstance().findAllBands((Band) request.getArgument());
        return new Response(bands, null, StatusCode.OK);
    }

    Response updateBand(Request request) throws Exception {
        boolean isBandSuccessfullyUpdated = Controller.getInstance().updateBand((Band) request.getArgument());
        return new Response(isBandSuccessfullyUpdated, null, StatusCode.OK);
    }

    Response deleteBand(Request request) throws Exception {
        Band band = (Band) request.getArgument();
        boolean isBandSuccessfullyDeleted = Controller.getInstance().deleteBand(band);
        return new Response(isBandSuccessfullyDeleted, null, StatusCode.NO_CONTENT);
    }

    Response saveSong(Request request) throws Exception {
        Song song = (Song) request.getArgument();
        Song savedSong = Controller.getInstance().saveSong(song);
        return new Response(savedSong, null, StatusCode.CREATED);
    }

    Response getAllSongs(Request request) throws Exception {
        List<Song> songs = Controller.getInstance().findAllSongs();
        return new Response(songs, null, StatusCode.OK);
    }

    Response getAllSongsFiltered(Request request) throws Exception {
        List<Song> songs = Controller.getInstance().findAllSongs((Song) request.getArgument());
        return new Response(songs, null, StatusCode.OK);
    }

    Response updateSong(Request request) throws Exception {
        boolean isSongSuccessfullyUpdated = Controller.getInstance().updateSong((Song) request.getArgument());
        return new Response(isSongSuccessfullyUpdated, null, StatusCode.OK);
    }

    Response deleteSong(Request request) throws Exception {
        Song song = (Song) request.getArgument();
        boolean isSongSuccessfullyDeleted = Controller.getInstance().deleteSong(song);
        return new Response(isSongSuccessfullyDeleted, null, StatusCode.NO_CONTENT);
    }

    Response getAllSongsByBand(Request request) throws Exception {
        Band band = (Band) request.getArgument();
        List<Song> songs = Controller.getInstance().findAllSongs(band);
        return new Response(songs, null, StatusCode.OK);
    }

    Response saveConcert(Request request) throws Exception {
        Concert concert = (Concert) request.getArgument();
        Concert savedConcert = Controller.getInstance().saveConcert(concert);
        return new Response(savedConcert, null, StatusCode.CREATED);
    }

    Response getAllConcerts(Request request) throws Exception {
        List<Concert> concerts = Controller.getInstance().findAllConcerts();
        return new Response(concerts, null, StatusCode.OK);
    }

    Response getAllConcertsFiltered(Request request) throws Exception {
        List<Concert> concerts = Controller.getInstance().findAllConcerts((Concert) request.getArgument());
        return new Response(concerts, null, StatusCode.OK);
    }

    Response updateConcert(Request request) throws Exception {
        Concert updatedConcert = Controller.getInstance().updateConcert((Concert) request.getArgument());
        return new Response(updatedConcert, null, StatusCode.OK);
    }

    Response deleteConcert(Request request) throws Exception {
        Concert concert = (Concert) request.getArgument();
        boolean isConcertSuccessfullyDeleted = Controller.getInstance().deleteConcert(concert);
        return new Response(isConcertSuccessfullyDeleted, null, StatusCode.NO_CONTENT);
    }

    Response findConcertById(Request request) throws Exception {
        Long concertID = (Long) request.getArgument();
        Concert concertByID = Controller.getInstance().findConcertByID(concertID);
        return new Response(concertByID, null, StatusCode.OK);
    }

}
