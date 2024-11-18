package Pages;

import TestCases.TestCheckoutPage;
import org.openqa.selenium.By;

public class LogoutPage extends BasePage{

    public By go_to_home_page = By.xpath("//a[normalize-space()='home']");

    public By rahul_hover = By.xpath("//div[@class='header_configure_area header_configure_four']//a[@id='navbarDropdown']");
    public By login_hover_btn = By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='Login..']");
    public By logout_hover_btn = By.xpath("//div[@class='header_configure_area header_configure_four']//a[@class='dropdown-item'][normalize-space()='Logout']");

    TestCheckoutPage testCheckoutPage = new TestCheckoutPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public void navigateBackPage(String phone_number, String pass){
        testCheckoutPage.cashOnDelivery(phone_number, pass);
        BrowserNavigate();
        shoppingCartPage.clickOnElement(shoppingCartPage.remove_book);
    }
}
