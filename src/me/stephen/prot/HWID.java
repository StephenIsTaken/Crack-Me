package me.stephen.prot;

import me.stephen.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HWID {
    public static boolean validHwid() {
        String hwid = Utils.bytesToHex(Utils.getHwid());
        try {
            URL url = Database.hwidURL;
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(hwid)) {
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
