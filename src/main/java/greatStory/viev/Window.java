package greatStory.viev;

import greatStory.ServerGreatStory.ClientGreatStory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Onlin on 12.10.2016.
 */
public class Window extends Application {
    private ClientGreatStory client;
    private Label serverText;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GreatStory");
        serverText = new Label();

        serverText.setId("server_text");
        client = new ClientGreatStory(8585);
        client = new ClientGreatStory(8585, serverText);
//        client.setName("Denni -  ");
        client.start();
        Scene scene = mainScene();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        initializeUser(client);

    }

    public Scene mainScene() {
        Group group = new Group();
        group.getChildren().add(southGroup());
        group.getChildren().add(northGroup());
//        ((Label)group.lookup("server_text")).setText("LOL");
        return new Scene(group, 400, 400);
    }

    public static void main(String[] args) {
        launch();

    }


    public Group southGroup() {
        Group southGroup = new Group();
//        TextField clientText = new TextField();
        TextArea clientText = new TextArea();
        clientText.setWrapText(true);
        System.out.println(clientText.getText());
//        clientText.setAlignment(Pos.TOP_LEFT);
        clientText.endOfNextWord();
        clientText.setLayoutX(10);
        clientText.setLayoutY(220);
        clientText.setPrefSize(390, 130);
        southGroup.getChildren().add(clientText);
        Button send = new Button("Send");
        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client.sendTextFromClientMessage(clientText);

            }
        });
        send.setLayoutX(300);
        send.setLayoutY(360);
        send.setPrefSize(50, 15);
        southGroup.getChildren().add(send);
        return southGroup;

    }

    public Group northGroup() {
        Group northGroup = new Group();
//
//  TextArea serverText = new TextArea();
        serverText.setWrapText(true);
        serverText.setAlignment(Pos.TOP_LEFT);
        serverText.setBorder(new Border(new BorderStroke(new Color(0.5, 0.125, 1, 1), BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS)));
        serverText.setLayoutX(10);
        serverText.setLayoutY(10);
        serverText.setPrefSize(390, 180);
//        serverText.setText(serverText.getText() + client.getInMessage());
        northGroup.getChildren().add(serverText);
        return northGroup;
    }

    private void initializeUser(ClientGreatStory client) {
        Stage window = new Stage();
        window.setResizable(false);
        window.setTitle("User nickname");
        window.initModality(Modality.APPLICATION_MODAL);
        Group group = new Group();
        Label label = new Label("Enter your nickname");
        label.setMinWidth(230);
        label.setAlignment(Pos.CENTER);
        TextArea userNickName = new TextArea();
        userNickName.setWrapText(true);
        userNickName.setLayoutX(10);
        userNickName.setLayoutY(30);
        userNickName.setPrefWidth(200);
        userNickName.setPrefHeight(10);
        Button btn = new Button("OK");
        btn.setLayoutX(230);
        btn.setLayoutY(30);
        btn.setPrefSize(50, 35);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client.setName(userNickName.getText()+" - ");
                window.close();
            }
        });
        group.getChildren().add(label);
        group.getChildren().add(userNickName);
        group.getChildren().add(btn);


        Scene scene = new Scene(group, 300, 100);

        window.setScene(scene);

        window.showAndWait();

    }


}











