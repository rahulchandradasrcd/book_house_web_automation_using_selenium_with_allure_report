# book_house_web_automation_using_selenium_with_allure_report
## Overview
This project automates the functionality of the BookHouse.com website using Java, Selenium WebDriver, and TestNG for test execution. The automation suite includes key operations such as login, searching for books, adding items to the cart, and completing checkout. All test results are reported using Allure, generating detailed and interactive reports for test analysis also created the report on surefire-report.

The goal of this project is to ensure the smooth functionality of the website by automating critical flows and validating the website’s behavior under various scenarios based on only happy paths.

## Features
* **Automated Login** <br>
* **Search Functionalities** : Automated searching books based on writer, title, genre, publishers etc. <br>
* **Shopping page Automated** : Simulates adding/removing books from the cart. <br>
* **Checkout Operation** : Automates the entire checkout process with followed all steps like enter number address delivery area delivery method etc. <br>
* **Automated Logout** <br>
* **Report Generate with Allure and Surefire** : Generates rich, visually appealing HTML reports of the test executions.

## Website
[BookHouse.com Automation Executed By Rahul](https://bookhouse.com.bd/).

## Manual TestCase
[BookHouse TestCase Developed By Rahul](https://docs.google.com/spreadsheets/d/1vM1LA42Dp4TdE4QJ2OAlaXTM05BiNbhr/edit?usp=sharing&ouid=101597896743962697858&rtpof=true&sd=true)  

## Pre-requisites
* Java (it's better to use the leteast version)
* maven
* Testng
* Webdriver
* Allure command Line
* Surefire command line for run in terminal
* IDE like IntelliJ IDEA, Eclipse, or Visual Studio Code

## Project Structure
````

**bookhouse-automation-pom/**  
|──**src/**  
│   ├── **main/**  
│   │   └── **java/**  
│   │       └── **com/**  
│   │           └── **bookhouse/**  
│   │             
│   └── **test/**  
│   |   └── **java/**  
│   |        └── **com/**  
│   |            └── **bookhouse/**  
│   │               ├── **pages/**                 **# Page Object Models (POM)**
|   |                    ├── **BasePage.java**     **# Base class with common setup** 
│   |                    ├── **HomePage.java**
|   |                    ├── **LoginPage.java**
|   |                    ├── **WriterPage.java**
|   |                    ├── **ShoppingCartPage.java**
|   |                    ├── **CheckOutPage.java**
│   |                    └── **LogoutPage.java**   
│   │               ├── **utils/**                 **# Helper/Utility classes**
|   |                    ├── **DataSet.java**
│   |                    └── **DriverSetup.java**  
|   |               └── **tests/**                 **# TestNG test cases**  
│                        ├── **TestHomePage.java**
|                        ├── **TestLoginPage.java**
|                        ├── **TestWriterPage.java**
|                        ├── **TestShoppingCartPage.java**
|                        ├── **TestCheckoutPage.java**
│                        └── **TestLogOutPage.java**   
├── **pom.xml**                                    **# Maven dependencies and build configuration**  
├── **allure-results/**                            **# Allure test execution results**
├── **Testng.xml/**                                **# Project Html Documentation to run all test**
└── **README.md**                                  **# Project documentation**  
````
## Installation
**1. Clone the Repository**
First, clone this repository to your local machine:
````

https://github.com/rahulchandradasrcd/book_house_web_automation_using_selenium_with_allure_report.git
````
**2. Set Up Java and Maven**
Ensure Java 8 or higher and Maven 3.x are installed on your machine.

Check your Java and Maven versions:
````

java -version
mvn -version
````
**3. WebDriver Setup**
Setup your webdriver properly.

**4. Add Dependecies in (pom.xml)**
- **selenium dependencies**
````

<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.25.0</version>
</dependency>
````
- **Testng dependencies**
````

<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>7.10.2</version>
      <scope>test</scope>
</dependency>
````
- **Allure dependencies**
````

<!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-testng -->
<dependency>
      <groupId>io.qameta.allure</groupId>
      <artifactId>allure-testng</artifactId>
      <version>2.29.0</version>
</dependency>
````
**5. Maven Plugin**
````

<plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.5.2</version>
        <configuration>
          <suiteXmlFiles>
            <suiteXmlFile>testng.xml</suiteXmlFile>
          </suiteXmlFiles>
        </configuration>
      </plugin>
</plugins>
````
## Example Test Code
### Driver Setup
````

package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverSetup {

    public static void setDriver(WebDriver driver) {
        DriverSetup.LOCAL_DRIVER.set(driver);
    }

    @BeforeMethod
    public void OpenABrowser(){
        WebDriver driver = getBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        setDriver(driver);
    }

    @AfterMethod
    public void CloseBrowser(){
        getDriver().quit();
    }
}
````
### BasePage Setup
````

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
````
### LoginTest 
````

package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.DataSet;
import Utility.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends DriverSetup {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void TestLoginBtn(){
        loginPage.navigateToLoginPage();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithValidData(String phone_number, String pass){
        loginPage.doLogin(phone_number, pass);
        homePage.HoverElement(homePage.sign_in_hover);
        Assert.assertTrue(homePage.is_element_visible(homePage.logout_hover_btn));
    }
}
````
## Reporting
### Allure Reporting
Make Sure allure dependencies add on POM.xml file. Then Create TestNG.xml File and setup run method with Thread count. Run The Test.
After Complete run test go to terminal and execute this code:- 
````

allure generate ./allure-results/ --clean

allure open ./allure-report
````
### Surefire Reporting
Go through the terminal or cmd and run this given code based on your requirements: 
````

mvn test
mvn test -Dbrowser=Chrome
mvn test -Dbrowser=Chrome -DsuitFileName="testng.xml"
````
## Report Screenshots
![1](https://github.com/user-attachments/assets/a3ab8f96-22fb-4c28-82c9-641284d20a1d)
![2](https://github.com/user-attachments/assets/693d9398-73e1-4968-ac14-3731e3bd8770)
![3](https://github.com/user-attachments/assets/53cd2ff2-67a5-4f42-ab00-005b89729fe9)
![4](https://github.com/user-attachments/assets/d93f4114-329c-4f2c-b821-a6ede72eb0e8)
![5](https://github.com/user-attachments/assets/68b32674-1e0a-44f0-86a1-0be7aad3be90)
![6](https://github.com/user-attachments/assets/16357bb3-1be4-493c-ac74-0e8c95481c1b)
![7](https://github.com/user-attachments/assets/31661040-514c-4a66-83a1-a7d0ffc50b04)
