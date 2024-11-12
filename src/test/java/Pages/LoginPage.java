package Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public By email_input_box = By.xpath("//input[@id='email']");
    public By pass_input_box = By.xpath("//input[@id='c-password']");
    public By login_btn = By.xpath("//button[normalize-space()='login']");

    HomePage homePage = new HomePage();

    public void navigateToLoginPage(){
        homePage.loadHomePage();
        homePage.HoverElement(homePage.sign_in_hover);
        homePage.HoverElement(homePage.login_hover_btn);
    }
}