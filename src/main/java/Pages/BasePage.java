package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import static junit.framework.TestCase.assertEquals;

public class BasePage {
    WebDriver driver;
    protected Wait<WebDriver> wait;
    public boolean isElementPresent(By by) {

        try {

            driver.findElement(by);

            return true;

        } catch (NoSuchElementException e) {

            return false;

        }

    }

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    public void checkFillField(String value, WebElement element) {

        assertEquals(value, element.getAttribute("value"));

    }
}
