/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import transfer.DTO;

/**
 *
 * @author VeljkoBlagojevic
 */
public class Receiver {

    private final Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }

    public @DTO Object receive() throws Exception {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (IOException ex) {
            throw new Exception("Error in receiving the data!");
        }
    }

}
