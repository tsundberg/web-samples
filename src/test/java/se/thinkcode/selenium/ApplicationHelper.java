package se.thinkcode.selenium;

import se.thinkcode.selenium.Main;

public class ApplicationHelper {

    public static void start() {
        String[] args = {};
        Main.main(args);
    }

    public static void shutdown() {
        Main.shutdown();
    }

}
