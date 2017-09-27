package ru.smeleyka.myfilebox.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * Created by smeleyka on 22.09.17.
 */
public class LoginController {

    public TextField loginField;
    public TextField passwordField;

    public LoginController() {
    }

    public void initialize() throws IOException {


    }

    public void startLogin(ActionEvent actionEvent) throws IOException {
        connectToServer();

        changeSceneToMain();

    }

    public void changeSceneToMain() throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene mainScene = new Scene(mainParent);
        GlobalData.getStage().setScene(mainScene);

    }

    public void connectToServer() throws IOException {
        Socket socket = new Socket(GlobalData.getServerIp(), GlobalData.getServerPort());
        ObjectInputStream obIn = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream obOut = new ObjectOutputStream(socket.getOutputStream());
        GlobalData.setObIn(obIn);
        GlobalData.setObOut(obOut);

    }
}
