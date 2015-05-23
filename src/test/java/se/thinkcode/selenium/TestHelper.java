package se.thinkcode.selenium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestHelper {
    private static Properties properties;

    private static void init() throws IOException {
        properties = new Properties();
        InputStream inStream = TestHelper.class.getResourceAsStream("/test.properties");
        properties.load(inStream);
    }

    public static String getBaseUrl() throws IOException {
        if (properties == null) {
            init();
        }

        return properties.getProperty("baseUrl");
    }
}
