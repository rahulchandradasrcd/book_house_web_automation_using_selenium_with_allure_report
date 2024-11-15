package Pages;

import TestCases.TestWriterPage;
import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage{

    public String check_out_url = "https://bookhouse.com.bd/cart";

    public By add_quantity = By.xpath("(//input[@name='product_qty[]'])[1]");
    public By update_btn = By.xpath("//button[@id='btn-update']");
    public By remove_book = By.xpath("//i[@class='fa fa-trash-o']");

    public By proceed_checkout = By.xpath("//a[normalize-space()='Proceed to Checkout']");

    WriterPage writerPage = new WriterPage();
    TestWriterPage testWriterPage = new TestWriterPage();

    public void navigateToShoppingCartPage(String phone_number, String pass){
        testWriterPage.selectBook(phone_number, pass);
        writerPage.clickOnElement(writerPage.add_to_cart_btn);
        writerPage.HoverElement(writerPage.add_to_cart_hover);
        writerPage.clickOnElement(writerPage.view_cart);
    }
}
