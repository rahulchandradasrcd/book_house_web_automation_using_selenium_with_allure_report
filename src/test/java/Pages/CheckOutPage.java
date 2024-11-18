package Pages;

import TestCases.TestShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends BasePage{

    public By alternate_mobile_no = By.xpath("//input[@placeholder='Alternative Mobile']");
    public By drop_down_city = By.xpath("//div[@class='checkout_page_bg common-page-padding']//div[4]//div[1]");
    public By drop_down_area = By.xpath("//span[normalize-space()='--- Select Area ---']");
    public By post_office = By.xpath("//input[@placeholder='POST OFFICE']");
    public By address = By.xpath("//textarea[@placeholder='Address']");
    public By order_note = By.xpath("//textarea[@id='order_note']");
    public By gift_wrap = By.xpath("//input[@id='gift_wrap']");
    public By terms_condition = By.xpath("//input[@id='payment_condition']");
    public By delivery_method = By.xpath("//div[@class='checkout_form_right']//div[3]//input[1]");

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    TestShoppingCartPage testShoppingCartPage = new TestShoppingCartPage();

    public void navigateToCheckoutPage(String phone_number, String pass){
        testShoppingCartPage.removeExtraBooks(phone_number, pass);
        shoppingCartPage.clickOnElement(shoppingCartPage.proceed_checkout);
    }
}
