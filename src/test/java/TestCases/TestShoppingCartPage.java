package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShoppingCartPage;
import Pages.WriterPage;
import Utility.DriverSetup;
import org.testng.annotations.Test;

public class TestShoppingCartPage extends DriverSetup {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    WriterPage writerPage = new WriterPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    TestLoginPage testLoginPage = new TestLoginPage();
    TestWriterPage testWriterPage = new TestWriterPage();

    @Test
    public void navigateShopping() throws InterruptedException {
        testWriterPage.searchWriter();
        shoppingCartPage.navigateToShoppingCartPage();
        shoppingCartPage.writeOnElement(shoppingCartPage.add_quantity, "3");
        shoppingCartPage.clickOnElement(shoppingCartPage.update_btn);
        shoppingCartPage.writeOnElement(shoppingCartPage.add_quantity, "1");
        shoppingCartPage.clickOnElement(shoppingCartPage.update_btn);
        shoppingCartPage.clickOnElement(shoppingCartPage.remove_book);
        Thread.sleep(5000);
    }
}
