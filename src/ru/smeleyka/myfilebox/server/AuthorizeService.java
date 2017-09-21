package ru.smeleyka.myfilebox.server;

import ru.smeleyka.myfilebox.shared_classes.AuthMessage;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by smeleyka on 19.09.17.
 */
public class AuthorizeService {

    private static HashMap<String, String> passDb = new HashMap<String, String>();
    private static HashMap<UUID, String> sessionDb = new HashMap<UUID, String>();

//    public AuthorizeService() {
//        passDb = new HashMap<String, String>();
//        sessionDb = new HashMap<UUID, String>();
//    }

    public static boolean addLoginPass(String login, String pass) {
        if (passDb.containsKey(login)) {
            return false;
        }
        passDb.put(login, pass);
        return true;
    }

    public static boolean checkUuid(UUID sessionId) {
        return sessionDb.containsValue(sessionId);
    }

    public static UUID authorize(String login, String pass) {
        UUID sessionId = null;
        if (passDb.get(login).equals(pass)) {
            sessionId = UUID.randomUUID();
            sessionDb.put(sessionId, login);
            return UUID.randomUUID();
        }
        return sessionId;
    }
    public static AuthMessage authorize(AuthMessage authMessage) {
        UUID sessionId = null;
        String login = authMessage.getLogin();
        String pass = authMessage.getPassword();
        if (passDb.get(login).equals(pass)) {
            sessionId = UUID.randomUUID();
            sessionDb.put(sessionId, login);
            authMessage.setSessionId(sessionId);
            return authMessage;
        }
        authMessage.setSessionId(null);
        return authMessage;
    }

    public static boolean deAuthorize(UUID sessionId) {
       return (sessionDb.remove(sessionId) != null);
    }

}
