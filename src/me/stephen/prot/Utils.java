package me.stephen.prot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    private static String getIP() throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(new URL("https://checkip.amazonaws.com").openStream()));
        final StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        br.close();
        return sb.toString();
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] getHwid() {
        MessageDigest hash = null;
        try {
            hash = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        String s = System.getProperty("os.name") +
                System.getProperty("os.arch") +
                System.getProperty("os.version") +
                Runtime.getRuntime().availableProcessors() +
                System.getenv("PROCESSOR_IDENTIFIER") +
                System.getenv("PROCESSOR_ARCHITECTURE") +
                System.getenv("PROCESSOR_ARCHITEW6432") +
                System.getenv("NUMBER_OF_PROCESSORS");
        return hash.digest(s.getBytes());
    }

}
