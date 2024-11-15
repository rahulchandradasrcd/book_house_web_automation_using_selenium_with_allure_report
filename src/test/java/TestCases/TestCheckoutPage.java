package TestCases;

import Pages.*;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.annotations.Test;

public class TestCheckoutPage extends DriverSetup {

    CheckOutPage checkOutPage = new CheckOutPage();

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void enterAlternatePhoneNumber(String phone_number, String pass){
        checkOutPage.navigateToCheckoutPage(phone_number, pass);
        checkOutPage.writeOnElement(checkOutPage.alternate_mobile_no, "01854263745");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void selectCity(String phone_number, String pass){
        enterAlternatePhoneNumber(phone_number, pass);
        checkOutPage.HandleDropDown(checkOutPage.drop_down_city);
        checkOutPage.HandleDropDown(checkOutPage.select_city_1);
        checkOutPage.HandleDropDown(checkOutPage.select_city_2);
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void selectArea(String phone_number, String pass){
        enterAlternatePhoneNumber(phone_number, pass);
        checkOutPage.HandleDropDown(checkOutPage.drop_down_area);
        checkOutPage.HandleDropDown(checkOutPage.select_area);
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 3)
    public void writePostOffice(String phone_number, String pass){
        selectArea(phone_number, pass);
        checkOutPage.writeOnElement(checkOutPage.post_office, "Shantinagar TSO");
    }
}
