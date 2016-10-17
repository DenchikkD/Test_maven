package greatStory.ServerGreatStory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Onlin on 15.10.2016.
 */
public class ServerOutMessager extends Thread {
    private ServerGreatStory greatStory;
    private String newMessage = "";
    private OutputStream os;
    private DataOutputStream dos;

    public ServerOutMessager(ServerGreatStory greatStory) {
        this.greatStory = greatStory;
    }

    @Override
    public void run() {

        while (true) {
            for (MessageListener messager : greatStory.getList()) {
                if (messager.isNewMessage()) {
                    newMessage = messager.getMessage();

                    for (Socket socket : greatStory.getSocketList()) {
                        try {
                            os = socket.getOutputStream();
                            dos = new DataOutputStream(os);
                            System.out.println("+");
                            dos.writeUTF(newMessage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    messager.setNewMessage(false);
                    messager.setMessage("");

                }

            }

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
