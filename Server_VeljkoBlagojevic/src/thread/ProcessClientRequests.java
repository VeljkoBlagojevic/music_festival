/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Sender;
import domain.User;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Request;
import transfer.Response;
import server.Server;
import transfer.StatusCode;

/**
 *
 * @author student2
 */
public class ProcessClientRequests extends Thread {

    private final Sender sender;
    private final Receiver receiver;
    private final ClientHandlerController controller;
    private User user;
    private Date loginTime;

    public ProcessClientRequests(Socket socket) {
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
        this.controller = new ClientHandlerController();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Request request = (Request) receiver.receive();
                handleRequest(request);
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("One client disconnected");
            Server.loggedClients.remove(this);
        } catch (Exception ex) {
            Logger.getLogger(ProcessClientRequests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handleRequest(Request request) {
        Response response = null;
        try {
            switch (request.getOperation()) {
                case LOGIN -> {
                    response = controller.loginUser(request);
                    addActiveClient(response);
                }
                case REGISTER -> {
                    response = controller.register(request);
                }
                case LOGOUT -> {
                    Server.loggedClients.remove(this);
                    this.interrupt();
                }
                case SAVE_STAGE -> {
                    response = controller.saveStage(request);
                }
                case GET_ALL_STAGES -> {
                    response = controller.getAllStages(request);
                }
                case GET_ALL_STAGES_FILTERED -> {
                    response = controller.getAllStagesFiltered(request);
                }
                case UPDATE_STAGE -> {
                    response = controller.updateStage(request);
                }
                case DELETE_STAGE -> {
                    response = controller.deleteStage(request);
                }

                case SAVE_BAND -> {
                    response = controller.saveBand(request);
                }
                case GET_ALL_BANDS -> {
                    response = controller.getAllBands(request);
                }
                case GET_ALL_BANDS_FILTERED -> {
                    response = controller.getAllBandsFiltered(request);
                }
                case UPDATE_BAND -> {
                    response = controller.updateBand(request);
                }
                case DELETE_BAND -> {
                    response = controller.deleteBand(request);
                }

                case SAVE_SONG -> {
                    response = controller.saveSong(request);
                }
                case GET_ALL_SONGS -> {
                    response = controller.getAllSongs(request);
                }
                case GET_ALL_SONGS_FILTERED -> {
                    response = controller.getAllSongsFiltered(request);
                }
                case UPDATE_SONG -> {
                    response = controller.updateSong(request);
                }
                case DELETE_SONG -> {
                    response = controller.deleteSong(request);
                }
                case GET_ALL_SONGS_BY_BAND -> {
                    response = controller.getAllSongsByBand(request);
                }

                case SAVE_CONCERT -> {
                    response = controller.saveConcert(request);
                }
                case GET_ALL_CONCERTS -> {
                    response = controller.getAllConcerts(request);
                }
                case GET_ALL_CONCERTS_FILTERED -> {
                    response = controller.getAllConcertsFiltered(request);
                }
                case UPDATE_CONCERT -> {
                    response = controller.updateConcert(request);
                }
                case DELETE_CONCERT -> {
                    response = controller.deleteConcert(request);
                }
                case FIND_CONCERT_BY_ID -> {
                    response = controller.findConcertById(request);
                }
            }
            sender.send(response);
        } catch (Exception ex) {
            try {
                sender.send(new Response(null, ex, StatusCode.BAD_REQUEST));
            } catch (Exception ex1) {
                Logger.getLogger(ProcessClientRequests.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

    public User getUser() {
        return user;
    }

    private void addActiveClient(Response response) {
        if (response.getException() != null) {
            return;
        }
        user = (User) response.getResult();
        loginTime = new Date();
        Server.loggedClients.add(this);
    }

    public Date getLoginTime() {
        return loginTime;
    }

}
