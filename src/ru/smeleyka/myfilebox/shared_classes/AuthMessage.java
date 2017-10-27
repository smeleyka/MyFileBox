package ru.smeleyka.myfilebox.shared_classes;


import java.util.UUID;

/**
 * Created by smele on 17.09.2017.
 */
public class AuthMessage extends AbstractMessage{
    private String login;
    private String password;

    public AuthMessage(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
