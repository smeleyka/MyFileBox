package ru.smeleyka.myfilebox.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by smele on 17.09.2017.
 */
public class Main {
    private static final int SERVER_PORT = 2017;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");
//            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
//            System.out.println(streamReader.);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
            while(true) {
                String s = br.readLine();
                if (s!=null){
                    System.out.println(s);
                    os.write(s+"\n");
                    os.flush();
                }
//                if (s == null || s.trim().length() == 0) {
//                    break;
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
