package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.DataSet;
import Utility.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends DriverSetup {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void TestLoginBtn(){
        loginPage.navigateToLoginPage();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class)
    @Description("User Login With ValidCredentials")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithValidData(String phone_number, String pass){
        loginPage.writeOnElement(loginPage.email_input_box, phone_number);
        loginPage.writeOnElement(loginPage.pass_input_box, pass);
        loginPage.clickOnElement(loginPage.login_btn);
        homePage.HoverElement(homePage.sign_in_hover);
        Assert.assertTrue(homePage.is_element_visible(homePage.logout_hover_btn));
    }
}
