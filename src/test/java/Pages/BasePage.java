package Pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.ByteArrayInputStream;

import static Utility.DriverSetup.getDriver;

public class BasePage {

    public void loadWebPage(String url){
        getDriver().get(url);
    }

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).click();
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public String getPageUrl(){
        return getDriver().getCurrentUrl();
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public Boolean is_element_visible(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void HoverElement(By locator){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getElement(locator)).build().perform();
        actions.click(getElement(locator)).build().perform();
    }

    public void ScrollElement(By locator){
        JavascriptExecutor scroll = (JavascriptExecutor) getDriver();
        WebElement next_page = getElement(locator);
        scroll.executeScript("arguments[0].scrollIntoView()", next_page);
    }
    public void addScreenshot() {
        Allure.addAttachment("After Test", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
