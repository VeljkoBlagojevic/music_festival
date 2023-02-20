package communication;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author VeljkoBlagojevic
 */
public class Communication {

    private static Communication instance;
    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    private Communication() {
        try {
            this.socket = new Socket("127.0.0.1", 9000);
            this.sender = new Sender(socket);
            this.receiver = new Receiver(socket);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Sender getSender() {
        return sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }
}
