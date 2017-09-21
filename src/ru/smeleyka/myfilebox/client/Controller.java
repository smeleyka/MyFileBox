package ru.smeleyka.myfilebox.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.smeleyka.myfilebox.shared_classes.TextDataMessage;


import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;


public class Controller {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 2017;
    private UUID sessionId;
    private Socket socket;
    private ObjectOutputStream obOut;
    private ObjectInputStream obIn;
    @FXML
    public TextField textFieldUser;
    @FXML
    public TextField textFieldPassword;
    @FXML
    private TextArea textArea;


    public void initialize() {
        System.out.println("Controller");
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Before Thread");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread");
                    try {
                        obIn = new ObjectInputStream(socket.getInputStream());
                        obOut = new ObjectOutputStream(socket.getOutputStream());

                        while (true) {
                            obIn.readObject();

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
            System.out.println("Thread Started");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginAction() throws Exception {
        os = new OutputStreamWriter(socket.getOutputStream());
        os.write(textFieldUser.getText() + "\n");
        os.flush();
        textFieldUser.clear();
        textFieldUser.getCursor();


    }

    public void recieveMessage(ActionEvent actionEvent) throws Exception {


    }

    public void sendMessage(ActionEvent actionEvent) throws Exception {

        String s = textFieldPassword.getText() + " " + textFieldUser.getText();
        TextDataMessage textMessage = new TextDataMessage(s);
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


        System.out.println(file.getAbsoluteFile());
        System.out.println(file.hashCode());
    }
}
