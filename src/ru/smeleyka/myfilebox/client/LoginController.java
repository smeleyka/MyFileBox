package ru.smeleyka.myfilebox.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import ru.smeleyka.myfilebox.shared_classes.AuthMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * Created by smeleyka on 22.09.17.
 */
public class LoginController {
    private MessageService messageService;
    public TextField loginField;
    public TextField passwordField;


    public LoginController() {
    }

    public void initialize() {
        GlobalData.setLoginController(this);
        MessageService.INSTANCE.startMessageListener();
        messageService = GlobalData.getMessageService();
    }

    public void startLogin(ActionEvent actionEvent) {
        //connectToServer();
        String login = loginField.getText();
        String pass = passwordField.getText();
        AuthMessage authMessage = new AuthMessage(login, pass);
        messageService.sendMessage(authMessage);

    }

    public void changeSceneToMain() {
        try {
            Parent mainParent = null;
            mainParent = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene mainScene = new Scene(mainParent);
            GlobalData.getStage().setScene(mainScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void connectToServer() throws IOException {
//        Socket socket = new Socket(GlobalData.getServerIp(), GlobalData.getServerPort());
//        ObjectInputStream obIn = new ObjectInputStream(socket.getInputStream());
//        ObjectOutputStream obOut = new ObjectOutputStream(socket.getOutputStream());
//        GlobalData.setObIn(obIn);
//        GlobalData.setObOut(obOut);
//
//    }
}
