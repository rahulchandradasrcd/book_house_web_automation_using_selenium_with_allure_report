package TestCases;

import Pages.*;
import Utility.DataSet;
import Utility.DriverSetup;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCheckoutPage extends DriverSetup {

    CheckOutPage checkOutPage = new CheckOutPage();

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void enterAlternatePhoneNumber(String phone_number, String pass){
        checkOutPage.navigateToCheckoutPage(phone_number, pass);
        checkOutPage.writeOnElement(checkOutPage.alternate_mobile_no, "01854263745");
        Assert.assertFalse(Boolean.parseBoolean(checkOutPage.getAttributeName(checkOutPage.alternate_mobile_no)), "already sendKeys to number");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void selectCity(String phone_number, String pass){
        enterAlternatePhoneNumber(phone_number, pass);
        checkOutPage.HandleDropdown(checkOutPage.drop_down_city, "খুলনা");
        Assert.assertEquals(checkOutPage.getElement(checkOutPage.drop_down_city).getText(),"খুলনা");
        checkOutPage.HandleDropdown(checkOutPage.drop_down_city, "ঢাকা");
        Assert.assertEquals(checkOutPage.getElement(checkOutPage.drop_down_city).getText(),"ঢাকা");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void selectArea(String phone_number, String pass){
        selectCity(phone_number, pass);
        checkOutPage.HandleDropdown(checkOutPage.drop_down_area, "সিদ্ধেশ্বরী");
        Assert.assertFalse(checkOutPage.is_element_visible(checkOutPage.drop_down_area), "already selected");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 3)
    public void writePostOffice(String phone_number, String pass){
        selectArea(phone_number, pass);
        checkOutPage.writeOnElement(checkOutPage.post_office, "Shantinagar TSO");
        Assert.assertFalse(Boolean.parseBoolean(checkOutPage.getAttributeName(checkOutPage.post_office)), "already sendKeys PostOfficeName");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 4)
    public void writeAddress(String phone_number, String pass){
        writePostOffice(phone_number, pass);
        checkOutPage.writeOnElement(checkOutPage.address, "411/B, Gulbagh Power House, Malibagh, Dhaka-1213");
        Assert.assertFalse(Boolean.parseBoolean(checkOutPage.getAttributeName(checkOutPage.address)), "already sendKeys address");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 5)
    public void writeOrderNote(String phone_number, String pass){
        writeAddress(phone_number, pass);
        checkOutPage.writeOnElement(checkOutPage.order_note, "if possible delivered fast on my address");
        Assert.assertFalse(Boolean.parseBoolean(checkOutPage.getAttributeName(checkOutPage.order_note)), "already sendKeys to order_note");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 6)
    public void orderGiftWrap(String phone_number, String pass){
        writeOrderNote(phone_number, pass);
        checkOutPage.clickOnElement(checkOutPage.gift_wrap);
        Assert.assertTrue(checkOutPage.is_selected(checkOutPage.gift_wrap));
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 7)
    public void termsAndCondition(String phone_number, String pass){
        orderGiftWrap(phone_number, pass);
        checkOutPage.clickOnElement(checkOutPage.terms_condition);
        Assert.assertTrue(checkOutPage.is_selected(checkOutPage.terms_condition));
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 8)
    public void cashOnDelivery(String phone_number, String pass){
        termsAndCondition(phone_number, pass);
        checkOutPage.clickOnElement(checkOutPage.delivery_method);
        Assert.assertTrue(checkOutPage.is_selected(checkOutPage.delivery_method));
    }
}
