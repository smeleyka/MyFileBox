package ru.smeleyka.myfilebox.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import static javafx.scene.input.KeyCode.ENTER;

public class Controller {
    private static final String SERVER_IP="127.0.0.1";
    private static final int SERVER_PORT=2017;
    private Socket socket;
    private OutputStreamWriter os;
    private InputStreamReader is;
    @FXML
    private TextField textField;
    @FXML
    private Button loginButton;
    @FXML
    private TextArea textArea;


    public void initialize() {
        try {
            socket = new Socket(SERVER_IP,SERVER_PORT);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        while (true){
                            String s = br.readLine();
                            if (s!=null){
                                textArea.appendText(s+"\n");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();



            //is = new InputStreamReader(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginAction() throws Exception{
        os = new OutputStreamWriter(socket.getOutputStream());
        os.write(textField.getText()+"\n");
        os.flush();
        textField.clear();
        textField.getCursor();


    }

    public void recieveMessage(ActionEvent actionEvent) throws Exception {


    }

    public void sendMessage(ActionEvent actionEvent) {
    }

}
