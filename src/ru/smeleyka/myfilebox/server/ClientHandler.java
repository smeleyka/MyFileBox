package ru.smeleyka.myfilebox.server;

import ru.smeleyka.myfilebox.shared_classes.AbstractMessage;
import ru.smeleyka.myfilebox.shared_classes.TextDataMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by smele on 18.09.2017.
 */
public class ClientHandler implements Runnable {
    Socket socket;
    Server server;
    ObjectInputStream obIn;
    ObjectOutputStream obOut;
    AbstractMessage mess;


    public ClientHandler(Server server,Socket socket) throws Exception{
        this.socket = socket;
        this.server = server;
        obOut = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        System.out.printf("Client Handler Started");
        while (true){
            try {
                obIn = new ObjectInputStream(socket.getInputStream());
                Object obj = obIn.readObject();
                messageHandler(obj);
                obIn.available();




            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }



    }
    public void messageHandler (Object obj){
        if(obj instanceof TextDataMessage){
            TextDataMessage textmessage = (TextDataMessage) obj;
            System.out.println(textmessage.getCommand());
        };
    }
}
