package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WriterPage extends BasePage{

    public By author_name = By.xpath("//h2[contains(text(),'হুমায়ূন আহমেদ')]");
    public String author_book_page_title = "হুমায়ূন আহমেদ's book are available in bookhouse.com.bd";

    public By search_bar = By.xpath("//input[@placeholder='Author Name...']");
    public By search_btn = By.xpath("//button[normalize-space()='Search']");
    public By author_btn = By.xpath("//img[@alt='হুমায়ূন আহমেদ']");
    public By publisher_btn_1 = By.xpath("//input[@id='publisher_1']");
    public By publisher_btn_2 = By.xpath("//input[@id='publisher_480']");
    public By publisher_btn_3 = By.xpath("//input[@id='publisher_550']");
    public By next_page_btn = By.xpath("//a[normalize-space()='2']");
    public By book = By.cssSelector("img[alt='দ্বৈরথ']");

    public By add_to_cart_btn = By.xpath("//button[@id='btn-add-to-cart']");
    public By add_to_cart_hover = By.xpath("//div[@class='header_configure_area header_configure_four']//i[@class='fa fa-shopping-bag']");
    public By view_cart = By.xpath("//div[@class='header_configure_area header_configure_four']//a[normalize-space()='View cart']");

    //public By

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    public void navigateToWriterPage(String phone_number, String pass){
        loginPage.doLogin(phone_number, pass);
        homePage.HoverElement(homePage.writer_hover_btn);
        homePage.webDriverWait(homePage.see_more);
        homePage.HoverElement(homePage.see_more);
    }
}
