package se.thinkcode.selenium.unit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.thinkcode.selenium.unit.checkbox.SelectColorPage;
import se.thinkcode.selenium.unit.form.RequestPasswordPage;
import se.thinkcode.selenium.unit.locate.HelloWorldPage;
import se.thinkcode.selenium.unit.popup.AlertPage;
import se.thinkcode.selenium.unit.radiobutton.SelectBeveragePage;
import se.thinkcode.selenium.unit.select.SelectCondimentPage;
import se.thinkcode.selenium.unit.slow.resource.RequestExchangeRatePage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IndexPage {
    private final WebDriver browser;

    public IndexPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl();
        browser.get(page);

        String expectedTitle = "Index";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public SelectColorPage selectColor() {
        WebElement selectedCondiment = browser.findElement(By.id("selectColor"));
        selectedCondiment.click();

        return new SelectColorPage(browser);
    }

    public SelectCondimentPage selectCondiment() {
        WebElement selectedCondiment = browser.findElement(By.id("selectCondiment"));
        selectedCondiment.click();

        return new SelectCondimentPage(browser);
    }

    public AlertPage alert() {
        WebElement alert = browser.findElement(By.id("alert"));
        alert.click();

        return new AlertPage(browser);
    }

    public HelloWorldPage helloWorld() {
        WebElement helloWorld = browser.findElement(By.id("helloWorld"));
        helloWorld.click();

        return new HelloWorldPage(browser);
    }

    public SelectBeveragePage selectBeverage() {
        WebElement buyCurrency = browser.findElement(By.id("selectBeverage"));
        buyCurrency.click();

        return new SelectBeveragePage(browser);
    }

    public RequestPasswordPage requestPassword() {
        WebElement requestNewPassword = browser.findElement(By.id("requestPassword"));
        requestNewPassword.click();

        return new RequestPasswordPage(browser);
    }

    public RequestExchangeRatePage requestExchangeRate() {
        WebElement requestExchangeRate = browser.findElement(By.id("requestExchangeRate"));
        requestExchangeRate.click();

        return new RequestExchangeRatePage(browser);
    }
}
