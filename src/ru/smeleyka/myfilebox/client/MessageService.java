package ru.smeleyka.myfilebox.client;

import ru.smeleyka.myfilebox.shared_classes.*;

/**
 * Created by smele on 26.09.2017.
 */
public class MessageService {

    public static <T extends AbstractMessage> boolean sendMessage(T msg) throws Exception {
        msg.setSessionId(GlobalData.getSessionId());
        GlobalData.getObOut().writeObject(msg);
        return true;
    }
}


