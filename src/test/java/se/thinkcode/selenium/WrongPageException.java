package se.thinkcode.selenium;

public class WrongPageException extends RuntimeException {
    public WrongPageException(String actualTitle, String expectedTitle) {
        super("\n" + "Expected: is  " + expectedTitle + "\n" +
                     "     but: was " + actualTitle);
    }
}
