package se.thinkcode.selenium.actions.select.sweetening;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectSweeteningTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        ApplicationHelper.start();

        browser = new FirefoxDriver();
        String baseUrl = TestHelper.getBaseUrl();
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        ApplicationHelper.shutdown();
        browser.close();
    }

    @Test
    public void select_milk() {
        SelectSweeteningPage selectSweeteningPage = new SelectSweeteningPage(browser);

        String initialSelection = selectSweeteningPage.getSelectedSweetening();
        assertThat(initialSelection, is("none"));

        selectSweeteningPage.selectMilk();

        String selectedBeverage = selectSweeteningPage.getSelectedSweetening();
        assertThat(selectedBeverage, is("milk"));
    }

    @Test
    public void select_sugar() {
        SelectSweeteningPage selectSweeteningPage = new SelectSweeteningPage(browser);

        String initialSelection = selectSweeteningPage.getSelectedSweetening();
        assertThat(initialSelection, is("none"));

        selectSweeteningPage.selectSugar();

        String selectedBeverage = selectSweeteningPage.getSelectedSweetening();
        assertThat(selectedBeverage, is("sugar"));
    }

    @Test
    public void find_all_options() {
        SelectSweeteningPage selectSweeteningPage = new SelectSweeteningPage(browser);

        List<String> expected = new LinkedList<>();
        expected.add("none");
        expected.add("milk");
        expected.add("sugar");
        expected.add("milk & sugar");
        List<String> actual = selectSweeteningPage.getAvailableSweeteners();

        assertThat(actual, is(expected));
    }
}
