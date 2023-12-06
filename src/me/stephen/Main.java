package me.stephen;

import me.stephen.gui.LoginPage;
import me.stephen.prot.AntiDump;
import me.stephen.prot.JarHashCheck;
import me.stephen.prot.VMDetector;

public class Main {
    public static void main(String[] args) {
        JarHashCheck.checkHash();
        if (VMDetector.isRunningOnVM()) {
            System.exit(75);
        }
         AntiDump.check(); // Comment this out in dev environment
        Database db = new Database();
        LoginPage loginPage = new LoginPage(db.getLoginInfo());
    }
}