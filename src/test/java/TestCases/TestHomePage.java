package TestCases;

import Pages.HomePage;
import Utility.DriverSetup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePage extends DriverSetup {

    HomePage homePage = new HomePage();

    @BeforeMethod
    public void GetHomepage(){
        getDriver().get(homePage.url);
    }

    @Test
    public void TestPageUrl(){
        Assert.assertEquals(homePage.getPageUrl(), homePage.url);
    }

    @Test
    public void TestPageTitle(){
        Assert.assertEquals(homePage.getPageTitle(), homePage.title);
    }
}
