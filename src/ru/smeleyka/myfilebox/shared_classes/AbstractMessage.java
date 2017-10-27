package ru.smeleyka.myfilebox.shared_classes;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by smele on 17.09.2017.
 */
public abstract class AbstractMessage implements Serializable {
    private UUID sessionId = null;

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }
}
