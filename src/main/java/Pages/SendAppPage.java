package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

public class SendAppPage extends BasePage {


    @FindBy(xpath = "//div[contains(@ng-show,'tryNext && myForm.$invalid')]")

    public WebElement errorMessage;


    @FindBy(name = "insured0_surname")

    public WebElement insuredSurname;


    @FindBy(name = "insured0_name")

    public WebElement insuredName;


    @FindBy(name = "insured0_birthDate")

    public WebElement insuredBirthDate;


    @FindBy(name = "surname")

    public WebElement surname;


    @FindBy(name = "name")

    public WebElement name;


    @FindBy(name = "middlename")

    public WebElement middlename;


    @FindBy(name = "birthDate")

    public WebElement birthDate;


    @FindBy(name = "passport_series")

    public WebElement passportSeries;


    @FindBy(name = "passport_number")

    public WebElement passportNumber;


    @FindBy(name = "issueDate")

    public WebElement issueDate;


    @FindBy(name = "issuePlace")

    public WebElement issuePlace;


    public SendAppPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

        this.driver = driver;

    }


    public void fillField(String fieldName, String value) {

        switch (fieldName) {

            case "Surname":

                fillField(insuredSurname, value);

                break;

            case "Name":

                fillField(insuredName, value);

                break;

            case "Birth Date":

                fillField(insuredBirthDate, value);

                break;

            case "Фамилия":

                fillField(surname, value);

                break;

            case "Имя":

                fillField(name, value);

                break;

            case "Отчество":

                fillField(middlename, value);

                break;

            case "Дата рождения":

                fillField(birthDate, value);

                break;

            case "Серия паспорта":

                fillField(passportSeries, value);

                break;

            case "Номер паспорта":

                fillField(passportNumber, value);

                break;

            case "Дата выдачи":

                fillField(issueDate, value);

                break;

            case "Кем выдан":

                fillField(issuePlace, value);

                break;

            default:

                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");

        }

    }


    public void scrollViewAndClick() {

        WebElement webElem = driver.findElement(By.xpath("//*[@class='contactsContainer']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElem);

        driver.findElement(By.xpath("//*[text()='Продолжить']")).click();

    }

    public void checkFieldErrorMessage(String value){

        assertEquals(value, errorMessage.getText());

    }
   // @FindBy(xpath = "//div[@class='b-form-box-block']")

  //  private WebElement amountOfInsuranceCoverage;



   // @FindBy(xpath = "//span[@ng-click='save()']")

   // private WebElement issueBtn;





   // public void checkAmountOfCoverage(String itemName) {

    //    amountOfInsuranceCoverage.findElement(By.xpath("//div[contains(text(),'" + itemName + "')]")).click();

   // }



  //  public void clickIssueBtn() {

  //      issueBtn.click();

   // }

   // @FindBy(xpath = "//div[@class='sbrf-rich-wrapper']//img[contains(@src,'travel')]")

   // public WebElement issueBtn1;
  //  public void clickIssueBtn1() {

   //     issueBtn1.click();

  //  }



   // public String getTitle() {

   //     return driver.getTitle();

   // }

}
