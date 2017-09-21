package ru.smeleyka.myfilebox.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * Created by smele on 19.09.2017.
 */
public class Server {
    private static final int SERVER_PORT = 2017;
    private static Vector <ClientHandler> clients;
    public Server() {

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
           while (true) {
               Socket socket = serverSocket.accept();
               System.out.println("Client Connected");
               new Thread(new ClientHandler(this, socket)).start();
           }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void clientsAdd(ClientHandler client){
        clients.add(client);
    }

}


