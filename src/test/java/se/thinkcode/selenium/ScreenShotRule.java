package se.thinkcode.selenium;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotRule extends TestWatcher {
    private static final String SCREENSHOT_DESTINATION_DIR = "target/screenshots";
    private WebDriver browser;

    public ScreenShotRule(WebDriver browser) {
        this.browser = browser;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) browser;
        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = getDestinationFile(description);
        try {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    @Override
    protected void finished(Description description) {
        browser.close();
    }

    private File getDestinationFile(Description description) {
        File destDir = new File(SCREENSHOT_DESTINATION_DIR);
        destDir.mkdirs();
        String screenShotName = description.getClassName() + "." + description.getMethodName() + ".png";
        String absoluteFileName = destDir.getPath() + "/" + screenShotName;

        return new File(absoluteFileName);
    }
}
