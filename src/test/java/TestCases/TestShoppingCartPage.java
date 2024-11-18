package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShoppingCartPage;
import Pages.WriterPage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestShoppingCartPage extends DriverSetup {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void checkShoppingCartPageWithAddMoreQuantityBooks(String phone_number, String pass){
        shoppingCartPage.navigateToShoppingCartPage(phone_number, pass);
        shoppingCartPage.writeOnElement(shoppingCartPage.add_quantity, "3");
        shoppingCartPage.clickOnElement(shoppingCartPage.update_btn);
        shoppingCartPage.webDriverWait(shoppingCartPage.update_btn);
        Assert.assertEquals(shoppingCartPage.getElement(shoppingCartPage.product_total1).getText(), "৳324");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void removeExtraBooks(String phone_number, String pass){
        checkShoppingCartPageWithAddMoreQuantityBooks(phone_number, pass);
        shoppingCartPage.writeOnElement(shoppingCartPage.add_quantity, "1");
        shoppingCartPage.clickOnElement(shoppingCartPage.update_btn);
        Assert.assertEquals(shoppingCartPage.getElement(shoppingCartPage.product_total2).getText(), "৳108");
    }
}
