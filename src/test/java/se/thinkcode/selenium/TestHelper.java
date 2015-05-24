package se.thinkcode.selenium;

import com.saucelabs.common.SauceOnDemandAuthentication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestHelper {
    public static String getBaseUrl() {
        // return "http://selenium.thinkcode.se";
        return "http://localhost:8080";
    }

    public static WebDriver getDefaultBrowser() {
        // return new HtmlUnitDriver(true);
        return new FirefoxDriver();
    }

    public static Collection<WebDriver[]> getCrossBrowsers() {
        setPathToChrome();

        List<WebDriver[]> browsers = new LinkedList<>();
        browsers.add(new WebDriver[]{new HtmlUnitDriver(true)});
        browsers.add(new WebDriver[]{new SafariDriver()});
        browsers.add(new WebDriver[]{new ChromeDriver()});
        browsers.add(new WebDriver[]{new FirefoxDriver()});

        return browsers;
    }

    private static void setPathToChrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/tsu/tools/chromedriver/chromedriver");
    }


    public static Collection<WebDriver[]> getRemoteCrossBrowsers(String jobName) {
        URL sauceLabs = getSauceLabsUrl();

        List<WebDriver[]> browsers = new LinkedList<>();
        for (DesiredCapabilities capabilities : browserSpecifications()) {
            capabilities.setCapability("name", jobName);
            RemoteWebDriver driver = new RemoteWebDriver(sauceLabs, capabilities);
            browsers.add(new WebDriver[]{driver});
        }

        return browsers;
    }

    public static List<DesiredCapabilities> browserSpecifications() {
        // https://docs.saucelabs.com/reference/platforms-configurator
        DesiredCapabilities caps;

        List<DesiredCapabilities> capabilities = new LinkedList<>();

        caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "18.0");
        capabilities.add(caps);

        caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("platform", "Windows 8.1");
        caps.setCapability("version", "11.0");
        capabilities.add(caps);

        caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 8");
        caps.setCapability("version", "42.0");
        capabilities.add(caps);

        caps = DesiredCapabilities.safari();
        caps.setCapability("platform", "Windows 7");
        caps.setCapability("version", "5.1");
        capabilities.add(caps);

        caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("version", "6.0");
        capabilities.add(caps);

        return capabilities;
    }


    private static URL getSauceLabsUrl() {
        SauceOnDemandAuthentication authentication = getSauceLabsAuthentication();
        try {
            String userName = authentication.getUsername();
            String accessKey = authentication.getAccessKey();
            String remoteHub = "@ondemand.saucelabs.com:80/wd/hub";
            return new URL("http://" + userName + ":" + accessKey + remoteHub);
        } catch (MalformedURLException e) {
            throw new SauceLabsConfigurationException(e.getMessage());
        }
    }

    public static SauceOnDemandAuthentication getSauceLabsAuthentication() {
        String userName = "tsundberg";
        String accessKey = "b6938bf6-61c6-4bde-96bb-c416ea8a3fa4";

        return new SauceOnDemandAuthentication(userName, accessKey);
    }
}
