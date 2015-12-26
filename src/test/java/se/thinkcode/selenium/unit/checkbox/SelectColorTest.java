package se.thinkcode.selenium.unit.checkbox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.unit.IndexPage;

import static org.junit.Assert.assertTrue;

public class SelectColorTest {
    private WebDriver browser;
    private SelectColorPage selectColor;

    @Before
    public void setUp() {
        ApplicationHelper.start();

        browser = TestHelper.getDefaultBrowser();
        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
        IndexPage indexPage = new IndexPage(browser);
        selectColor = indexPage.selectColor();
    }

    @After
    public void tearDown() {
        ApplicationHelper.shutdown();
        browser.close();
    }

    @Test
    public void select_green() {
        selectColor.selectGreen();
        SelectedColorPage selectedColor = selectColor.submit();

        assertTrue("Green should have been selected", selectedColor.isGreenSelected());
    }
}
