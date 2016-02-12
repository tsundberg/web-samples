package se.thinkcode.selenium.unit.count;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import se.thinkcode.selenium.ApplicationHelper;
import se.thinkcode.selenium.TestHelper;

public class CountTest {
    private WebDriver browser;

    @Test
    public void testBuyOneDollar ()
    {
        //Go to Link
        browser = new FirefoxDriver();
        browser.get("http://localhost:4040/buyCurrency");
        //Select Buy
        WebElement buyOption = browser.findElement(By.id("buy"));
        buyOption.click();

        //Set Buy USD
        Select selectBuyCurrency = new Select(browser.findElement(By.id("toCurrency")));
        selectBuyCurrency.selectByValue("USD");

        // Type 1 into the input field
        WebElement inputAmount = browser.findElement(By.id("amount"));
        inputAmount.sendKeys("1");


        //Set Pay dropdown to EUR
        Select selectSellCurrency = new Select(browser.findElement(By.id("fromCurrency")));
        selectSellCurrency.selectByValue("EUR");


        //Click Submit Button
        WebElement submitButton = browser.findElement(By.id("submit"));
         submitButton.click();

        //Validate the content



    }
}
