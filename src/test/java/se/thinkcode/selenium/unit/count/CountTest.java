package se.thinkcode.selenium.unit.count;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CountTest {
    private WebDriver browser;

    public static class BuyCurrency {
        @FindBy(how = How.ID, using = "toCurrency")
        private WebElement buyOption;
        private WebDriver browser;

        public BuyCurrency(WebDriver browser) {
            this.browser = browser;
            PageFactory.initElements(this.browser,this);
        }

        public void setBuyOption(String value) {
        Select selectBuyCurrency = new Select(buyOption);
        selectBuyCurrency.selectByValue(value);

    }

    }


    @Test
    public void testBuyOneDollar() {
        //Go to Link
        browser = new FirefoxDriver();
        browser.get("http://localhost:4040/buyCurrency");

        BuyCurrency buyCurrency = new BuyCurrency(browser);
        //Select Buy
        WebElement buyOption = browser.findElement(By.id("buy"));
        buyOption.click();

        //Set Buy USD
      buyCurrency.setBuyOption("USD");

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
