package ru.smeleyka.myfilebox.client;

import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * Created by smeleyka on 26.09.17.
 */
public class GlobalData {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 2017;
    private static final String LOGIN = "test";
    private static final String PASS = "pass";
    private static Stage stage;
    private static UUID sessionId = null;
    private static MessageService messageService;
    private static LoginController loginController;

    public static MessageService getMessageService() {
        return messageService;
    }

    public static void setMessageService(MessageService messageService) {
        GlobalData.messageService = messageService;
    }

    public static UUID getSessionId() {
        return sessionId;
    }

    public static void setSessionId(UUID sessionId) {
        GlobalData.sessionId = sessionId;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        GlobalData.stage = stage;
    }

    public static String getServerIp() {
        return SERVER_IP;
    }

    public static int getServerPort() {
        return SERVER_PORT;
    }

    public static LoginController getLoginController() {
        return loginController;
    }

    public static void setLoginController(LoginController loginController) {
        GlobalData.loginController = loginController;
    }

    public static void shutdown(){
        messageService.shutdown();
    }



//    private static Socket socket;
//    private static ObjectOutputStream obOut;
//    private static ObjectInputStream obIn;

//    public static ObjectOutputStream getObOut() {
//        return obOut;
//    }
//
//    public static void setObOut(ObjectOutputStream obOut) {
//        GlobalData.obOut = obOut;
//    }
//
//    public static ObjectInputStream getObIn() {
//        return obIn;
//    }
//
//    public static void setObIn(ObjectInputStream obIn) {
//        GlobalData.obIn = obIn;
//    }
//
//    public static Socket getSocket() {
//        return socket;
//    }
//
//    public static void setSocket(Socket socket) {
//        GlobalData.socket = socket;
//    }

}
