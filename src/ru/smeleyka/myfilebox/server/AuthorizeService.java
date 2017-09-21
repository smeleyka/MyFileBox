package ru.smeleyka.myfilebox.server;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by smeleyka on 19.09.17.
 */
public class AuthorizeService {

    private static HashMap<String, String> passDb;
    private static HashMap<UUID, String> sessionDb;

    public AuthorizeService() {
        passDb = new HashMap<String, String>();
        sessionDb = new HashMap<UUID, String>();
    }

    public static boolean addLoginPass(String login, String pass) {
        if (passDb.containsKey(login)) {
            return false;
        }
        passDb.put(login, pass);
        return true;
    }

    public static boolean checkUuid(UUID uuid) {
        return sessionDb.containsValue(uuid);
    }

    public static UUID authorize(String login, String pass) {
        UUID uuid = null;
        if (passDb.get(login).equals(pass)) {
            uuid = UUID.randomUUID();
            sessionDb.put(uuid, login);
            return UUID.randomUUID();
        }
        return uuid;
    }

    public static boolean deAuthorize(UUID uuid) {
       return (sessionDb.remove(uuid) != null);
    }

}
