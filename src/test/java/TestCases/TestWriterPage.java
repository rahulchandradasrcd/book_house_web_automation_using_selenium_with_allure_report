package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.WriterPage;
import Utility.DataSet;
import Utility.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestWriterPage extends DriverSetup {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    WriterPage writerPage = new WriterPage();
    TestLoginPage testLoginPage = new TestLoginPage();


    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class)
    public void AuthorPage(String phone_number, String pass) throws InterruptedException {
        loginPage.navigateToLoginPage();
        testLoginPage.loginWithValidData(phone_number, pass);
        writerPage.navigateToWriterPage();
        Thread.sleep(8000);
    }

    @Test
    public void searchWriter(){
        writerPage.navigateToWriterPage();
        writerPage.writeOnElement(writerPage.search_bar, "হুমায়ূন আহমেদ");
        writerPage.clickOnElement(writerPage.search_btn);
        writerPage.clickOnElement(writerPage.author_btn);
        writerPage.clickOnElement(writerPage.publisher_btn_1);
        writerPage.clickOnElement(writerPage.publisher_btn_2);
        writerPage.clickOnElement(writerPage.publisher_btn_3);
        writerPage.ScrollElement(writerPage.next_page_btn);
        writerPage.clickOnElement(writerPage.next_page_btn);
        writerPage.ScrollElement(writerPage.book);
        writerPage.clickOnElement(writerPage.book);
    }
}
