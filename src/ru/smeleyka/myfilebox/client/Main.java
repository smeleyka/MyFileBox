package ru.smeleyka.myfilebox.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        window = primaryStage;
        window.setTitle("MyDropBox");
        window.setScene(new Scene(root,600,400));
        window.setResizable(false);
        window.show();


    }


    public static void main(String[] args) {
        try {
            new GlobalData();
            launch(args);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                GlobalData.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
