import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class BaseTest {
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();


    protected Wait<WebDriver> wait;

    @BeforeClass

    public static void setUp() throws Exception {
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }
        // System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        // System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
         driver = new FirefoxDriver();
         baseUrl = properties.getProperty("baseUrl");
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        //String verificationErrorString = verificationErrors.toString();
        //if (!"".equals(verificationErrorString)) {
        //  fail(verificationErrorString);
        //}
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    protected void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    protected void checkFillField(String expected, By locator) {
        assertEquals(expected, driver.findElement(locator).getAttribute("value"));
    }


}
