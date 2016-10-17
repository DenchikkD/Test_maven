package greatStory.ServerGreatStory;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Onlin on 12.10.2016.
 */
public class MessageListener extends Thread {
    private Socket socket;
    private ServerGreatStory server;
    private boolean isNewMessage = false;
    private String message = "";

    public MessageListener(Socket socket, ServerGreatStory server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                message = dis.readUTF();

                setNewMessage(true);
                System.out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isNewMessage() {
        return isNewMessage;
    }

    public synchronized void setNewMessage(boolean newMessage) {
        isNewMessage = newMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
