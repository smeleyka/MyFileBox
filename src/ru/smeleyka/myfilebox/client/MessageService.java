package ru.smeleyka.myfilebox.client;

import ru.smeleyka.myfilebox.shared_classes.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.RunnableScheduledFuture;

/**
 * Created by smele on 26.09.2017.
 */
public class MessageService {

//    public void connectToServer() throws IOException {
//        Socket socket = new Socket(GlobalData.getServerIp(), GlobalData.getServerPort());
//        ObjectInputStream obIn = new ObjectInputStream(socket.getInputStream());
//        ObjectOutputStream obOut = new ObjectOutputStream(socket.getOutputStream());
//        GlobalData.setObIn(obIn);
//        GlobalData.setObOut(obOut);

    private Socket socket;
    private ObjectInputStream obIn;
    private ObjectOutputStream obOut;
    private Thread listenerThread;
    private boolean isInterrupted = false;

    public static final MessageService INSTANCE = new MessageService();

    private MessageService() {
        try {
            this.socket = new Socket(GlobalData.getServerIp(), GlobalData.getServerPort());
            this.obIn = new ObjectInputStream(socket.getInputStream());
            this.obOut = new ObjectOutputStream(socket.getOutputStream());
            GlobalData.setMessageService(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public <T extends AbstractMessage> void sendMessage(T msg) {
        Thread sendThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    msg.setSessionId(GlobalData.getSessionId());
                    obOut.writeObject(msg);
                    obOut.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        sendThread.setDaemon(true);
        sendThread.start();

    }

    public <T extends AbstractMessage> void startMessageListener() {
        if (this.listenerThread == null || !this.listenerThread.isAlive()) {
            this.listenerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (!isInterrupted) {
                            System.out.println("Message Listener Started");
                            MesageHandler.incommingMessage((AbstractMessage)obIn.readObject());
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
            });
        }
        listenerThread.setDaemon(true);
        listenerThread.start();

    }

    public void shutdown(){
        isInterrupted = true;
    }
}


