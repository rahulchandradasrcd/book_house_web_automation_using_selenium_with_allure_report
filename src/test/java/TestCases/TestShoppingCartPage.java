package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShoppingCartPage;
import Pages.WriterPage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.annotations.Test;

public class TestShoppingCartPage extends DriverSetup {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void checkShoppingCartPageWithAddMoreQuantityBooks(String phone_number, String pass){
        shoppingCartPage.navigateToShoppingCartPage(phone_number, pass);
        shoppingCartPage.writeOnElement(shoppingCartPage.add_quantity, "3");
        shoppingCartPage.clickOnElement(shoppingCartPage.update_btn);
        //shoppingCartPage.clickOnElement(shoppingCartPage.remove_book);
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void removeExtraBooks(String phone_number, String pass){
        checkShoppingCartPageWithAddMoreQuantityBooks(phone_number, pass);
        shoppingCartPage.writeOnElement(shoppingCartPage.add_quantity, "1");
        shoppingCartPage.clickOnElement(shoppingCartPage.update_btn);
    }
}
