package se.thinkcode.selenium.unit.screenshot;

import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.ScreenShotRule;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.unit.radiobutton.SelectBeveragePage;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FailingTest {
    private FirefoxDriver browser;

    @Rule
    public ScreenShotRule screenShootRule;

    public FailingTest() {
        browser = new FirefoxDriver();
        screenShootRule = new ScreenShotRule(browser);
    }

    @Before
    public void setUp() {
        ApplicationHelper.start();

        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        ApplicationHelper.shutdown();
        browser.close();
    }

    @Test
    @Ignore
    public void find_beverages_to_choose_from() {
        SelectBeveragePage selectBeveragePage = new SelectBeveragePage(browser);

        List<String> expected = new LinkedList<>();
        expected.add("coffee");
        expected.add("tea");
        expected.add("chocolate");

        List<String> actual = selectBeveragePage.getAvailableBeverages();

        assertThat(actual, is(expected));
    }
}
