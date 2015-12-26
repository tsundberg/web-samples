package se.thinkcode.selenium.unit.select;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.unit.IndexPage;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectCondimentTest {
    private WebDriver browser;
    private SelectCondimentPage selectCondimentPage;

    @Before
    public void setUp() {
        ApplicationHelper.start();

        browser = TestHelper.getDefaultBrowser();
        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
        IndexPage index = new IndexPage(browser);
        selectCondimentPage = index.selectCondiment();
    }

    @After
    public void tearDown() {
        ApplicationHelper.shutdown();
        browser.close();
    }

    @Test
    public void select_milk() {
        String initialSelection = selectCondimentPage.getSelectedCondiment();
        assertThat(initialSelection, is("none"));

        selectCondimentPage.selectMilk();

        String selectedBeverage = selectCondimentPage.getSelectedCondiment();
        assertThat(selectedBeverage, is("milk"));

    }

    @Test
    public void select_sugar() {
        String initialSelection = selectCondimentPage.getSelectedCondiment();
        assertThat(initialSelection, is("none"));

        selectCondimentPage.selectSugar();

        String selectedBeverage = selectCondimentPage.getSelectedCondiment();
        assertThat(selectedBeverage, is("sugar"));
    }

    @Test
    public void find_all_options() {
        List<String> expected = new LinkedList<>();
        expected.add("none");
        expected.add("milk");
        expected.add("sugar");
        expected.add("milk & sugar");
        List<String> actual = selectCondimentPage.getAvailableCondiments();

        assertThat(actual, is(expected));
    }
}
