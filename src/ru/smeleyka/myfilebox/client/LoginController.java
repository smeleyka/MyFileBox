package ru.smeleyka.myfilebox.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by smeleyka on 22.09.17.
 */
public class LoginController {

    private static UUID sessionId;
    public TextField loginField;
    public TextField passwordField;

    public LoginController() {
        this.sessionId = null;
    }

    public void initialize() throws IOException {
        FXMLLoader.load(getClass().getResource("main.fxml"));
    }

    public void startLogin(ActionEvent actionEvent) {


    }

    public void changeSceneToMain(){

    }
}
