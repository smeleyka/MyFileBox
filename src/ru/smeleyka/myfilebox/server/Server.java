package ru.smeleyka.myfilebox.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");
           new Thread(new ClientHandler(this,socket)).start();

//            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
//            while(true) {
//                String s = br.readLine();
//                if (s!=null){
//                    System.out.println(s);
//                    os.write(s+"\n");
//                    os.flush();
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}


