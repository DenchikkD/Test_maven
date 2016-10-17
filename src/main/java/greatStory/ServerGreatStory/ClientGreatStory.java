package greatStory.ServerGreatStory;

import greatStory.viev.Window;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Onlin on 12.10.2016.
 */
public class ClientGreatStory extends Thread {
    private int port;
    private String message = "";
    private boolean isNewMessage = false;
    private String inMessage = "";
    private Label serverText;

    public ClientGreatStory(int port) {
        this.port = port;
    }

    public ClientGreatStory(int port, Label serverText) {
        this.port = port;
        this.serverText = serverText;
//        Label label = new Label();
//        label.setWrapText(true);
//        label.setAlignment(Pos.TOP_LEFT);
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket("localhost", port);
            OutputStream os = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
//            Scanner scn = new Scanner(System.in);
            while (true) {
                if (is.available() > 0) {
                    System.out.println(is.available());
                    inMessage = dis.readUTF();
//                    if (serverText.getText().equals("")) {
//                        Platform.runLater(serverText.setText(inMessage + "\n"));
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                serverText.setText(serverText.getText()+inMessage + "\n");
                            }
                        });
//                    }else {
//                        serverText.setText(serverText.getText() + inMessage + "\n");
//                    }

                    System.out.println("пришло" + inMessage);
                }
                if (isNewMessage()) {
                    dos.writeUTF(currentThread().getName() + message);
                    setIsNewMessage(false);
                } else {
                    currentThread().sleep(100);
//                String str = scn.nextLine();
//                dos.writeUTF(currentThread().getName() + str);

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendTextFromClientMessage(TextArea text) {
        message = text.getText();
        setIsNewMessage(true);
        text.setText("");

    }

    private void setIsNewMessage(boolean isNewMessage) {
        this.isNewMessage = isNewMessage;
    }

    private boolean isNewMessage() {
        return isNewMessage;
    }

    public String getInMessage() {
        return inMessage;
    }
}
