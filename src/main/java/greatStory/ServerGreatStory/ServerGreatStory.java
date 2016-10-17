package greatStory.ServerGreatStory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Onlin on 12.10.2016.
 */
public class ServerGreatStory extends Thread {
    private int port;
    private List<MessageListener> list;
    private List<Socket> socketList;


    public ServerGreatStory(int port) {
        this.port = port;
        list = new LinkedList();
        socketList = new LinkedList<>();
        new ServerOutMessager(this).start();
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();
                socketList.add(socket);
                MessageListener messageListener = new MessageListener(socket, this);
                list.add(messageListener);
                messageListener.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<MessageListener> getList() {
        return list;
    }

    public List<Socket> getSocketList() {
        return socketList;
    }
}
