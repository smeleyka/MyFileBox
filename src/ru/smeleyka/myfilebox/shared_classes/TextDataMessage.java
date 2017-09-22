package ru.smeleyka.myfilebox.shared_classes;

import java.util.UUID;

/**
 * Created by smele on 17.09.2017.
 */
public class TextDataMessage extends AbstractMessage {
    private UUID sessionId;
    private String command;

    public TextDataMessage(UUID sessionId, String command) {
        this.command = command;
        this.sessionId = sessionId;
    }

    public String getCommand() {
        return command;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
