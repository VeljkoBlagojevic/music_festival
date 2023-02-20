/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.DTO;

/**
 *
 * @author VeljkoBlagojevic
 */
public class Sender {

    private final Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void send(@DTO Object data) throws Exception {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(data);
            out.flush();
        } catch (IOException ex) {
            throw new Exception("Error sending the data!");
        }

    }

}
