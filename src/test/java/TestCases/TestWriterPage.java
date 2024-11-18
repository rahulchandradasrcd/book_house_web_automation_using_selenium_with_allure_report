package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.WriterPage;
import Utility.DataSet;
import Utility.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestWriterPage extends DriverSetup {

    WriterPage writerPage = new WriterPage();

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void searchWriter(String phone_number, String pass){
        writerPage.navigateToWriterPage(phone_number, pass);
        writerPage.writeOnElement(writerPage.search_bar, "হুমায়ূন আহমেদ");
        writerPage.clickOnElement(writerPage.search_btn);
        Assert.assertEquals(writerPage.getElement(writerPage.author_name).getText(),"হুমায়ূন আহমেদ");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void goToAuthorBooksPage(String phone_number, String pass){
        searchWriter(phone_number, pass);
        writerPage.clickOnElement(writerPage.author_btn);
        Assert.assertEquals(writerPage.getPageTitle(), writerPage.author_book_page_title);
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 2)
    public void filterBookPublishers(String phone_number, String pass){
        goToAuthorBooksPage(phone_number, pass);
        writerPage.clickOnElement(writerPage.publisher_btn_1);
        writerPage.clickOnElement(writerPage.publisher_btn_2);
        writerPage.clickOnElement(writerPage.publisher_btn_3);
        Assert.assertTrue(writerPage.is_selected(writerPage.publisher_btn_1));
        Assert.assertTrue(writerPage.is_selected(writerPage.publisher_btn_2));
        Assert.assertTrue(writerPage.is_selected(writerPage.publisher_btn_3));
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 3)
    public void goToNextPage(String phone_number, String pass){
        filterBookPublishers(phone_number, pass);
        writerPage.ScrollElement(writerPage.next_page_btn);
        writerPage.clickOnElement(writerPage.next_page_btn);
        Assert.assertTrue(writerPage.is_element_visible(writerPage.book));
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 4)
    public void selectBook(String phone_number, String pass){
        goToNextPage(phone_number, pass);
        writerPage.ScrollElement(writerPage.book);
        writerPage.webDriverWait(writerPage.book);
        writerPage.clickOnElement(writerPage.book);
        Assert.assertTrue(writerPage.is_enabled(writerPage.add_to_cart_btn));
    }
}
