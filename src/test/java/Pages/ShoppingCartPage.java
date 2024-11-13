package Pages;

import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage{

    public By add_quantity = By.xpath("(//input[@name='product_qty[]'])[1]");
    public By update_btn = By.xpath("//button[@id='btn-update']");
    public By remove_book = By.xpath("//i[@class='fa fa-trash-o']");


    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    WriterPage writerPage = new WriterPage();

    public void navigateToShoppingCartPage(){
        writerPage.BookAddToCartPage();
        writerPage.clickOnElement(writerPage.add_to_cart_btn);
        writerPage.HoverElement(writerPage.add_to_cart_hover);
        writerPage.clickOnElement(writerPage.view_cart);
    }
}
