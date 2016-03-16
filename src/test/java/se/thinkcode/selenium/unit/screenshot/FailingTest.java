package se.thinkcode.selenium.unit.screenshot;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.unit.radiobutton.SelectBeveragePage;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FailingTest {
    private WebDriver browser;

    @Rule
    public ScreenShotRule screenShootRule;

    public FailingTest() {
        browser = new FirefoxDriver();
        screenShootRule = new ScreenShotRule(browser);
    }

    @Before
    public void setUp() {
        String baseUrl = "http://selenium.thinkcode.se";
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
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
