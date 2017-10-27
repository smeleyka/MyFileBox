package ru.smeleyka.myfilebox.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.smeleyka.myfilebox.shared_classes.AuthMessage;
import ru.smeleyka.myfilebox.shared_classes.FileDataMessage;
import ru.smeleyka.myfilebox.shared_classes.TextDataMessage;


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
        System.out.println("MainController");

            System.out.println("Before Thread");

            obIn = GlobalData.getObIn();
            obOut = GlobalData.getObOut();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Thread");
                        while (true) {

                            messageHandler(obIn.readObject());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println("Thread Started");


    }

    public void loginAction() throws Exception {
        String login = textFieldUser.getText();
        String pass = textFieldPassword.getText();
        AuthMessage authMessage = new AuthMessage(login,pass);
        obOut.writeObject(authMessage);
        obOut.flush();
    }

    public void recieveMessage(ActionEvent actionEvent) throws Exception {


    }

    public void messageHandler(Object obj) {
        if (obj instanceof AuthMessage) {
            AuthMessage authMessage = (AuthMessage)obj;
            if (authMessage.getSessionId()!=null){
                GlobalData.setSessionId(authMessage.getSessionId());
                textFieldUser.setVisible(false);
                textFieldPassword.setVisible(false);
                loginButton.setVisible(false);
            }
        }
        if (obj instanceof TextDataMessage) {

        }

    }

    public void sendMessage(ActionEvent actionEvent) throws Exception {

        String s = textFieldPassword.getText() + " " + textFieldUser.getText();
        TextDataMessage textMessage = new TextDataMessage(GlobalData.getSessionId(),s);
        System.out.println("1");
        //obOut = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("2");
        obOut.writeObject(textMessage);
        obOut.flush();
        System.out.println("3");

    }


    public void openFile(ActionEvent actionEvent) {
        Stage stage = new Stage();
        File file;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file = fileChooser.showOpenDialog(stage);
        try {
        if (file !=null && file.exists()) {
            Path pFile = file.toPath();
            byte[] byteFile = Files.readAllBytes(pFile);
            System.out.println(pFile.getFileName());

            //MessageService.sendMessage(new FileDataMessage(pFile.getFileName()))
        }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }



        //System.out.println(file.getAbsoluteFile());
        //System.out.println(file.hashCode());

}
