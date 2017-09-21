package ru.smeleyka.myfilebox.shared_classes;


import java.util.UUID;

/**
 * Created by smele on 17.09.2017.
 */
public class AuthMessage extends AbstractMessage{
    private UUID sessionId;
    private String login;
    private String password;

    public AuthMessage(String login, String password) {
        this.login = login;
        this.password = password;
        this.sessionId = null;
    }
    public AuthMessage(String login, String password,UUID sessionId) {
        this.login = login;
        this.password = password;
        this.sessionId = sessionId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }
}
