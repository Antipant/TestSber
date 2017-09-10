import Pages.BasePage;

import Pages.MainPage;
import Pages.SendAppPage;
import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyRefactoringTest extends BaseTest {

    @Test

    public void testFirst() throws Exception {

        driver.get(baseUrl + "/ru/person");


        MainPage mainPage = new MainPage(driver);

        mainPage.selectRegion("Нижегородская область");

        mainPage.checkRegion("Нижегородская область");

        mainPage.scrollToFooter();


        mainPage.checkSocialNetworkIcon(mainPage.facebook);


    }


    @Test

    public void testSecond() throws Exception {

        driver.get(baseUrl + "/ru/person");


        MainPage mainPage = new MainPage(driver);

        mainPage.selectMenuItem("Застраховать себя");

        mainPage.selectInsuranceItem("Страхование путешественников");
        SendAppPage sendAppPage = new SendAppPage(driver);

      //  sendAppPage.clickIssueBtn1();

     //   assertEquals("«Сбербанк» - Страхование путешественников", sendAppPage.getTitle());
        driver.findElement(By.linkText("Страхование путешественников")).click();

        for (String winHandle : driver.getWindowHandles()) {

            driver.switchTo().window(winHandle);

        }



       // sendAppPage.checkAmountOfCoverage("Минимальная");

      //  sendAppPage.clickIssueBtn();

        driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding")).click();

        driver.findElement(By.cssSelector("span.b-continue-btn")).click();

        sendAppPage.fillField("Surname", "Sdg");

        sendAppPage.fillField("Name", "Afd");

        sendAppPage.fillField("Birth Date", "01.01.2000");

        sendAppPage.fillField("Фамилия", "Фававфы");

        sendAppPage.fillField("Имя", "Ыфа");

        sendAppPage.fillField("Отчество", "Кпуф");

        sendAppPage.fillField("Дата рождения", "02.02.1998");


        sendAppPage.fillField("Серия паспорта", "2434");

        sendAppPage.fillField("Номер паспорта", "346545");

        sendAppPage.fillField("Дата выдачи", "04.04.2014");

        sendAppPage.fillField("Кем выдан", "впявыпавыв");


        sendAppPage.scrollViewAndClick();


        sendAppPage.checkFillField("Sdg", sendAppPage.insuredSurname);

        sendAppPage.checkFillField("Afd", sendAppPage.insuredName);

        sendAppPage.checkFillField("01.01.2000", sendAppPage.insuredBirthDate);

        sendAppPage.checkFillField("Фававфы", sendAppPage.surname);

        sendAppPage.checkFillField("Ыфа", sendAppPage.name);

        sendAppPage.checkFillField("Кпуф", sendAppPage.middlename);

        sendAppPage.checkFillField("02.02.1998", sendAppPage.birthDate);

        sendAppPage.checkFillField("2434", sendAppPage.passportSeries);

        sendAppPage.checkFillField("346545", sendAppPage.passportNumber);

        sendAppPage.checkFillField("04.04.2014", sendAppPage.issueDate);

        sendAppPage.checkFillField("впявыпавыв", sendAppPage.issuePlace);


        sendAppPage.checkFieldErrorMessage("Заполнены не все обязательные поля");

    }

}

