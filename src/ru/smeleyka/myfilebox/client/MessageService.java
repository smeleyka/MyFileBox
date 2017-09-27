package ru.smeleyka.myfilebox.client;

import ru.smeleyka.myfilebox.shared_classes.AuthMessage;
import ru.smeleyka.myfilebox.shared_classes.FileDataMessage;
import ru.smeleyka.myfilebox.shared_classes.FileStructureMessage;
import ru.smeleyka.myfilebox.shared_classes.TextDataMessage;

/**
 * Created by smele on 26.09.2017.
 */
public class MessageService {


    public static boolean sendMessage(AuthMessage msg) {
        GlobalData.getObOut();
        return true;
    }

    public static boolean sendMessage(FileDataMessage msg) {
        return true;
    }

    public static boolean sendMessage(FileStructureMessage msg) {
        return true;
    }

    public static boolean sendMessage(TextDataMessage msg) {
        return true;
    }
}
