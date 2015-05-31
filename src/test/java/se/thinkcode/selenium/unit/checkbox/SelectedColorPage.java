package se.thinkcode.selenium.unit.checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectedColorPage {
    private final WebDriver browser;

    public SelectedColorPage(WebDriver browser) {
        this.browser = browser;

        String expectedTitle = "Selected colors";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public boolean isGreenSelected() {
        List<WebElement> selectedColors = browser.findElements(By.name("color"));
        for (WebElement element : selectedColors) {
            String text = element.getText();
            if (text.equals("green")) {
                return true;
            }

        }

        return false;
    }
}
