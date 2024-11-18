package Pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

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

    public Boolean is_selected(By locator){
        try {
            return getElement(locator).isSelected();
        }catch (Exception e){
            return false;
        }
    }

    public Boolean is_enabled(By locator){
        try {
            return getElement(locator).isEnabled();
        }catch (Exception e){
            return false;
        }
    }

    public void GetText(By locator){
        getElement(locator).getText();
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

    public void HandleDropdown(By locator, String text) {
        WebElement dropdown = getElement(locator);
        dropdown.click();
        for (WebElement option : dropdown.findElements(By.xpath("//li"))) {
            if (option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }

    public void webDriverWait(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getAttributeName(By locator){
        return getElement(locator).getAttribute("Message");
    }

    public void BrowserNavigate(){
        getDriver().navigate().back();
    }

    public void addScreenshot() {
        Allure.addAttachment("After Test", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
