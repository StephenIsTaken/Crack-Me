package me.stephen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Database {
    public static final URL hwidURL;

    static {
        try {
            hwidURL = new URL("https://pastebin.com/raw/kFqnpR3G");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    HashMap<String, String> logininfo = new HashMap<String, String>();
    Database() {
        logininfo.put("admin", "admin");
        logininfo.put("User", "PASSWORD123");
    }
    public HashMap getLoginInfo() {
        return logininfo;
    }
}