package ru.smeleyka.myfilebox.shared_classes;

/**
 * Created by smele on 17.09.2017.
 */
public class TextDataMessage extends AbstractMessage {

    private String command;

    public TextDataMessage(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
