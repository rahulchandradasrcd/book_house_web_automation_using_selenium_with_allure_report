package TestCases;

import Pages.*;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogOutPage extends DriverSetup{

    LogoutPage logoutPage = new LogoutPage();
    HomePage homePage = new HomePage();

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void goToHomePageForLogout(String phone_number, String pass){
        logoutPage.navigateBackPage(phone_number, pass);
        logoutPage.clickOnElement(logoutPage.go_to_home_page);
        Assert.assertEquals(logoutPage.getPageUrl(), homePage.url);
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void logoutFromThisSite(String phone_number, String pass){
        goToHomePageForLogout(phone_number, pass);
        logoutPage.HoverElement(logoutPage.rahul_hover);
        logoutPage.clickOnElement(logoutPage.logout_hover_btn);
        logoutPage.HoverElement(logoutPage.rahul_hover);
        Assert.assertTrue(logoutPage.is_element_visible(logoutPage.login_hover_btn));
    }
}
