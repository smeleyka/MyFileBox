package ru.smeleyka.myfilebox.server;

import ru.smeleyka.myfilebox.shared_classes.AbstractMessage;
import ru.smeleyka.myfilebox.shared_classes.AuthMessage;
import ru.smeleyka.myfilebox.shared_classes.TextDataMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by smele on 18.09.2017.
 */
public class ClientHandler implements Runnable {
    private static Socket socket;
    private static Server server;
    private ObjectInputStream obIn;
    private ObjectOutputStream obOut;
    private AbstractMessage mess;


    public ClientHandler(Server server, Socket socket) throws Exception {
        this.socket = socket;
        this.server = server;
        obOut = new ObjectOutputStream(socket.getOutputStream());
        obIn = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        System.out.printf("Client Handler Started");
        try {
            while (true) {

                Object obj = obIn.readObject();
                messageHandler(obj);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                obIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void messageHandler(Object obj) {
        if (obj instanceof AuthMessage) {
            AuthMessage authMessage = (TextDataMessage) obj;
            System.out.println(authMessage.getCommand());
        }
        if (obj instanceof TextDataMessage) {
            TextDataMessage textMessage = (TextDataMessage) obj;
            System.out.println(textMessage.getCommand());
        }

    }
}
