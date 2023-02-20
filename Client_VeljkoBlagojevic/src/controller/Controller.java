/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Communication;
import domain.Band;
import domain.Concert;
import domain.Song;
import domain.Stage;
import operation.Operation;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author VeljkoBlagojevic
 */
public class Controller {

    private static Controller instance;

    private Controller() throws Exception {
    }

    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void logout() throws Exception {
        Request request = new Request(null, Operation.LOGOUT);
        Communication.getInstance().getSender().send(request);
    }

    public Response deleteBand(Band band) throws Exception {
        Request request = new Request(band, Operation.DELETE_BAND);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response updateBand(Band band) throws Exception {
        Request request = new Request(band, Operation.UPDATE_BAND);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response getAllSongsByBand(Band band) throws Exception {
        Request request = new Request(band, Operation.GET_ALL_SONGS_BY_BAND);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response saveBand(Band band) throws Exception {
        Request request = new Request(band, Operation.SAVE_BAND);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response getAllBandsFiltered(Band searchBandParam) throws Exception {
        Request request = new Request(searchBandParam, Operation.GET_ALL_BANDS_FILTERED);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response getAllBands() throws Exception {
        Request request = new Request(null, Operation.GET_ALL_BANDS);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response deleteConcert(Concert concert) throws Exception {
        Request request = new Request(concert, Operation.DELETE_CONCERT);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response updateConcert(Concert concert) throws Exception {
        Request request = new Request(concert, Operation.UPDATE_CONCERT);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response getAllStages() throws Exception {
        Request request = new Request(null, Operation.GET_ALL_STAGES);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response getAllSongs() throws Exception {
        Request request = new Request(null, Operation.GET_ALL_SONGS);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response saveConcert(Concert concert) throws Exception {
        Request request = new Request(concert, Operation.SAVE_CONCERT);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response findConcertByID(Long id) throws Exception {
        Request request = new Request(id, Operation.FIND_CONCERT_BY_ID);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response getAllConcertsFiltered(Concert searchConcertParam) throws Exception {
        Request request = new Request(searchConcertParam, Operation.GET_ALL_CONCERTS_FILTERED);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response getAllConcerts() throws Exception {
        Request request = new Request(null, Operation.GET_ALL_CONCERTS);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response saveSong(Song song) throws Exception {
        Request request = new Request(song, Operation.SAVE_SONG);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response deleteSong(Song song) throws Exception {
        Request request = new Request(song, Operation.DELETE_SONG);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response updateSong(Song song) throws Exception {
        Request request = new Request(song, Operation.UPDATE_SONG);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response getAllSongsFiltered(Song searchSongParam) throws Exception {
        Request request = new Request(searchSongParam, Operation.GET_ALL_SONGS_FILTERED);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response saveStage(Stage stage) throws Exception {
        Request request = new Request(stage, Operation.SAVE_STAGE);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response deleteStage(Stage stage) throws Exception {
        Request request = new Request(stage, Operation.DELETE_STAGE);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response updateStage(Stage stage) throws Exception {
        Request request = new Request(stage, Operation.UPDATE_STAGE);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

    public Response getAllStagesFiltered(Stage searchStageParam) throws Exception {
        Request request = new Request(searchStageParam, Operation.GET_ALL_STAGES_FILTERED);
        Communication.getInstance().getSender().send(request);
        return (Response) Communication.getInstance().getReceiver().receive();
    }

}
