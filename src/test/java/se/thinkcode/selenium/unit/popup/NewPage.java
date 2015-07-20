package se.thinkcode.selenium.unit.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NewPage {
    private final WebDriver browser;

    public NewPage(WebDriver browser) {
        this.browser = browser;

        WebElement linkToPopupPage = browser.findElement(By.partialLinkText("Pop up - New page"));
        linkToPopupPage.click();

        switchToNewPage(browser);

        String expectedTitle = "New pop-up";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    private void switchToNewPage(WebDriver browser) {
        String origin = browser.getWindowHandle();

        Set<String> windows = browser.getWindowHandles();

        for (String windowHandle : windows) {
            if (!windowHandle.equals(origin)) {
                browser.switchTo().window(windowHandle);
            }
        }
    }

    public String getHeadline() {
        WebElement resultParagraph = browser.findElement(By.id("headline"));

        return resultParagraph.getText();
    }
}
