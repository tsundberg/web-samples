package se.thinkcode.selenium.unit.checkbox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;

import static org.junit.Assert.assertTrue;

public class SelectColorTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        ApplicationHelper.start();

        browser = TestHelper.getDefaultBrowser();
        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        ApplicationHelper.shutdown();
        browser.close();
    }

    @Test
    public void select_color() {
        SelectColorPage selectColor = new SelectColorPage(browser);

        selectColor.selectGreen();
        SelectedColorPage selectedColor = selectColor.submit();

        assertTrue("Green should have been selected", selectedColor.isGreenSelected());
    }
}
