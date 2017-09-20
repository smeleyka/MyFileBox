package ru.smeleyka.myfilebox.shared_classes;


/**
 * Created by smele on 17.09.2017.
 */
public class AuthMessage extends AbstractMessage{
    private String login;
    private String password;
    private boolean isAuthorised;
    private int sessionId;

    public AuthMessage(String login, String password, boolean isAuthorised) {
        this.login = login;
        this.password = password;
        this.isAuthorised = isAuthorised;
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

    public boolean isAuthorised() {
        return isAuthorised;
    }

    public void setAuthorised(boolean authorised) {
        isAuthorised = authorised;
    }
}
