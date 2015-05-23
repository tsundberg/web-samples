package se.thinkcode.selenium.steps;

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
