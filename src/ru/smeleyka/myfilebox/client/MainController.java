package ru.smeleyka.myfilebox.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class MainController {
    private static ObjectOutputStream obOut;
    private static ObjectInputStream obIn;
    @FXML
    public TextField textFieldUser;
    @FXML
    public TextField textFieldPassword;
    @FXML
    public TextArea textArea;
    public Button loginButton;


    public void initialize() {

    }

    public void openFile(ActionEvent actionEvent) {
        Stage stage = new Stage();
        File file;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file = fileChooser.showOpenDialog(stage);
        try {
            if (file != null && file.exists()) {
                Path pFile = file.toPath();
                byte[] byteFile = Files.readAllBytes(pFile);
                System.out.println(pFile.getFileName());

                //MessageService.sendMessage(new FileDataMessage(pFile.getFileName()))
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(ActionEvent actionEvent) {

    }

    public void recieveMessage(ActionEvent actionEvent) {
    }


    //System.out.println(file.getAbsoluteFile());
    //System.out.println(file.hashCode());

}
