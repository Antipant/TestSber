import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tester {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

 @Ignore

  @Test
  public void test12() throws Exception {
    driver.get(baseUrl);

    driver.findElement(By.cssSelector("span.region-list__arrow")).click();
    WebElement search = driver.findElement(By.xpath("(//input[@value=''])[3]"));
    Wait<WebDriver> wait = new WebDriverWait(driver, 10, 6000);
    wait.until(ExpectedConditions.visibilityOf(search));
    search.click();
    search.sendKeys("Нижегородская область");


    driver.findElement(By.cssSelector("div.kit-autocomplete-input__option")).click();


    assertTrue(isElementPresent(By.linkText("Нижегородская область")));



    wait.until(ExpectedConditions.visibilityOf(

            driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-container']"))));



    WebElement footer = driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-container']"));

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", footer);



    assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_fb']")));


  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
