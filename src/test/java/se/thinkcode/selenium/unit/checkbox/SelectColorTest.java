package se.thinkcode.selenium.unit.checkbox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.unit.IndexPage;

import static org.junit.Assert.assertTrue;

public class SelectColorTest {
    private WebDriver browser;
    private SelectColorPage selectColor;

    @Before
    public void setUp() {
        browser = new FirefoxDriver();
        String baseUrl = "http://selenium.thinkcode.se";
        browser.get(baseUrl);
        IndexPage indexPage = new IndexPage(browser);
        selectColor = indexPage.selectColor();
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    public void select_green() {
        selectColor.selectGreen();
        SelectedColorPage selectedColor = selectColor.submit();

        assertTrue("Green should have been selected", selectedColor.isGreenSelected());
    }
}
