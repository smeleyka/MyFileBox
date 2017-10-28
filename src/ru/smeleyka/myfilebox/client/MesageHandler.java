package ru.smeleyka.myfilebox.client;

import javafx.event.ActionEvent;
import ru.smeleyka.myfilebox.shared_classes.AbstractMessage;
import ru.smeleyka.myfilebox.shared_classes.AuthMessage;
import ru.smeleyka.myfilebox.shared_classes.TextDataMessage;

import java.io.IOException;

/**
 * Created by smeleyka on 28.10.17.
 */
public class MesageHandler {

    public static <T extends AbstractMessage> void incommingMessage(T msg) {
        if (msg instanceof AuthMessage) {
            authMessageMethod((AuthMessage)msg);
        }


    }

//    public void sendMessage(ActionEvent actionEvent) throws Exception {
//
//        String s = textFieldPassword.getText() + " " + textFieldUser.getText();
//        TextDataMessage textMessage = new TextDataMessage(GlobalData.getSessionId(),s);
//        System.out.println("1");
//        //obOut = new ObjectOutputStream(socket.getOutputStream());
//        System.out.println("2");
//        obOut.writeObject(textMessage);
//        obOut.flush();
//        System.out.println("3");
//
//    }

    private static void authMessageMethod(AuthMessage msg) {
        GlobalData.setSessionId(msg.getSessionId());
        if (GlobalData.getSessionId() != null){
            GlobalData.getLoginController().changeSceneToMain();
        }
    }
}
