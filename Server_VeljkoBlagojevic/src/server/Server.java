/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domain.User;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import thread.ProcessClientRequests;

/**
 *
 * @author VeljkoBlagojevic
 */
public class Server extends Thread {

    private ServerSocket serverSocket;
    public static List<ProcessClientRequests> loggedClients;

    public Server() {
        try {
            serverSocket = new ServerSocket(9000);
            loggedClients = new ArrayList<>();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Port is occupied by another instance of the server application", "Port Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected!");
                handleClient(socket);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        cancelClients();
    }

    private void handleClient(Socket socket) throws Exception {
        try {
            ProcessClientRequests processClientsRequests = new ProcessClientRequests(socket);
            //        loggedClients.add(processClientsRequests);
            processClientsRequests.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public List<User> getActiveUsers() {
//        List<User> users = new ArrayList<>();
//        for (ProcessClientRequests c : loggedClients) {
//            users.add(c.getUser());
//        }
//
//        return users;
//        
        return loggedClients.stream()
                .map(ProcessClientRequests::getUser)
                .collect(Collectors.toList());
    }

    private void cancelClients() {
        //TODO..
//        for (ProcessClientRequests k : loggedClients) {
//            try {
//                k.getSocket().close();
//                loggedClients.remove(k);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }

        loggedClients.forEach(activeClient -> {
            //                activeClient.getSocket().close();
            loggedClients.remove(activeClient);
        });

    }

}
