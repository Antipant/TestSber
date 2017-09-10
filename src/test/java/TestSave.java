import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class TestSave extends BaseTest {


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"PETROV", "PETR", "01.01.2001", "Иванов", "Иван", "Иванович",

                        "02.02.1999", "1111", "222222", "05.05.2015", "опаопаопа"},

                {"Sdg", "Afd", "01.01.2000", "Фававфы", "Ыфа", "Кпуф",

                        "02.02.1998", "2434", "346545", "04.04.2014", "впявыпавыв"}
        });
    }

    @Parameterized.Parameter

    public String insuredSurname;


    @Parameterized.Parameter(1)

    public String insuredName;


    @Parameterized.Parameter(2)

    public String insuredBirthDate;


    @Parameterized.Parameter(3)

    public String surname;


    @Parameterized.Parameter(4)

    public String name;


    @Parameterized.Parameter(5)

    public String middlename;


    @Parameterized.Parameter(6)

    public String birthDate;


    @Parameterized.Parameter(7)

    public String passportSeries;


    @Parameterized.Parameter(8)

    public String passportNumber;


    @Parameterized.Parameter(9)

    public String issueDate;


    @Parameterized.Parameter(10)

    public String issuePlace;

    @Ignore
    @Test
    public void testSave() throws Exception {
        driver.get(baseUrl + "/ru/person");
        driver.findElement(By.xpath("//div[@id='main']/div/div/div/div/div/div/div/div/div[4]/div/div[3]/div/div/ul/li[5]/a/span/span")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Страхование путешественников"))));
        driver.findElement(By.linkText("Страхование путешественников")).click();
        driver.findElement(By.cssSelector("li.active > a > span")).click();
        //assertEquals("«Сбербанк» - Страхование путешественников", driver.getTitle());
        // driver.findElement(By.cssSelector("li.active > a > span")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p > a > img"))));
        driver.findElement(By.cssSelector("p > a > img")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
        for (String winHandle : driver.getWindowHandles()) {

            driver.switchTo().window(winHandle);

        }


        //  wait.until(ExpectedConditions.visibilityOf(

        //  driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding"))));

        driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding")).click();

        driver.findElement(By.cssSelector("span.b-continue-btn")).click();


        fillField(By.name("insured0_surname"), insuredSurname);

        fillField(By.name("insured0_name"), insuredName);

        fillField(By.name("insured0_birthDate"), insuredBirthDate);

        fillField(By.name("surname"), surname);

        fillField(By.name("name"), name);

        fillField(By.name("middlename"), middlename);

        fillField(By.name("birthDate"), birthDate);


        driver.findElement(By.name("male")).click();


        fillField(By.name("passport_series"), passportSeries);

        fillField(By.name("passport_number"), passportNumber);

        fillField(By.name("issueDate"), issueDate);

        fillField(By.name("issuePlace"), issuePlace);


        checkFillField(insuredSurname, By.name("insured0_surname"));

        checkFillField(insuredName, By.name("insured0_name"));

        checkFillField(insuredBirthDate, By.name("insured0_birthDate"));

        checkFillField(surname, By.name("surname"));

        checkFillField(name, By.name("name"));

        checkFillField(middlename, By.name("middlename"));

        checkFillField(birthDate, By.name("birthDate"));

        checkFillField(passportSeries, By.name("passport_series"));

        checkFillField(passportNumber, By.name("passport_number"));

        checkFillField(issueDate, By.name("issueDate"));

        checkFillField(issuePlace, By.name("issuePlace"));
        driver.findElement(By.cssSelector("span.b-continue-btn")).click();
        assertEquals(

                "Заполнены не все обязательные поля",

                driver.findElement(By.xpath("//div[contains(@ng-show,'tryNext && myForm.$invalid')]")).getText()

        );

    }


}
