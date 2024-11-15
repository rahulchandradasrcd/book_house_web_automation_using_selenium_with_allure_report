package Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public String enter_user_auth_url = "https://bookhouse.com.bd/login?redirect=%2F";

    public By email_input_box = By.xpath("//input[@id='email']");
    public By pass_input_box = By.xpath("//input[@id='c-password']");
    public By login_btn = By.xpath("//button[normalize-space()='login']");

    HomePage homePage = new HomePage();

    public void loadLoginPageToEnterUser(){
        loadWebPage(enter_user_auth_url);
    }

    public void navigateToLoginPage(){
        homePage.loadHomePage();
        homePage.HoverElement(homePage.sign_in_hover);
        homePage.HoverElement(homePage.login_hover_btn);
    }
    public void doLogin(String phone_number, String pass){
        loadLoginPageToEnterUser();
        writeOnElement(email_input_box, phone_number);
        writeOnElement(pass_input_box, pass);
        clickOnElement(login_btn);
    }
}
