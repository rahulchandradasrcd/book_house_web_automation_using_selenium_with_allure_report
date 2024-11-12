package Pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String url = "https://bookhouse.com.bd/";
    public String title = "Buy Book -Best Online Bookstore in Bangladesh|bookhouse.com.bd";
    public By sign_in_hover = By.xpath("//div[@class='header_configure_area header_configure_four']//a[@id='navbarDropdown']");
    public By login_hover_btn = By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='Login..']");
    public By logout_hover_btn = By.xpath("//div[@class='header_configure_area header_configure_four']//a[@class='dropdown-item'][normalize-space()='Logout']");


    public void loadHomePage(){
        loadWebPage(url);
    }
}