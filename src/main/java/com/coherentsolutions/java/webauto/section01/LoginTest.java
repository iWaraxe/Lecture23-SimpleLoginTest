package com.coherentsolutions.java.webauto.section01;

// File: LoginTest.java
// Package: com.coherentsolutions.java.webauto.section01

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * This class contains a simple login test for the Magento site.
 */
public class LoginTest {

    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";
    private static final String EMAIL = "selenium.tester@gmail.com";
    private static final String PASSWORD = "qyq*nbp.zcw2apq4ZQW";
    private WebDriver driver;

    /**
     * Sets up the WebDriver before each test method.
     */
    @BeforeMethod
    public void openBrowser() {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
    }

    /**
     * Closes the WebDriver after each test method.
     */
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    /**
     * This test performs a login action on the Magento site.
     */
    @Test
    public void loginTest() {
        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = driver.findElement(signInLinkLocator);
        signInLink.click();

        By emailFieldLocator = By.cssSelector(".login-container input[type='email']");
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys(EMAIL);

        By passwordFieldLocator = By.cssSelector(".login-container input[type='password']");
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(PASSWORD);

        By signInButtonLocator = By.cssSelector(".login-container [type='submit']");
        WebElement signInButton = driver.findElement(signInButtonLocator);
        signInButton.click();

        By welcomeMessageLocator = By.cssSelector(".page-header .greet.welcome");
        WebElement welcomeMessage = driver.findElement(welcomeMessageLocator);

        Assert.assertTrue(welcomeMessage.isDisplayed());
    }

    public static void main(String[] args) {
        // You can run the test directly from the main method if needed
        LoginTest test = new LoginTest();
        test.openBrowser();
        test.loginTest();
        test.closeBrowser();
    }
}
