package com.coherentsolutions.java.webauto.section01;

// File: UniversalLoginTest.java
// Package: com.coherentsolutions.java.webauto.section01

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Universal login test that works with both Chrome and Safari browsers.
 * Browser is specified via TestNG parameter or system property.
 */
public class UniversalLoginTest {

    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";
    private static final String EMAIL = "selenium.tester@gmail.com";
    private static final String PASSWORD = "qyq*nbp.zcw2apq4ZQW";
    
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Sets up the browser before each test.
     * Browser is determined via TestNG parameter or system property "browser".
     * Chrome is used by default.
     */
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(String browser) {
        // If parameter is not passed, try to get from system properties
        if (browser == null || browser.isEmpty()) {
            browser = System.getProperty("browser", "chrome");
        }
        
        setupDriver(browser.toLowerCase());
        
        // Configure common browser settings
        driver.manage().window().maximize();
        
        // Use longer wait time for Safari
        Duration implicitWait = browser.equalsIgnoreCase("safari") ? 
            Duration.ofSeconds(10) : Duration.ofSeconds(5);
        driver.manage().timeouts().implicitlyWait(implicitWait);
        
        // Create WebDriverWait for explicit waits
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        driver.get(BASE_URL);
    }

    /**
     * Overloaded method for cases when browser parameter is not passed
     */
    @BeforeMethod
    public void openBrowser() {
        openBrowser("chrome");
    }

    /**
     * Sets up the driver based on the selected browser
     */
    private void setupDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "safari":
                // Safari doesn't require WebDriverManager, but automation must be enabled in settings
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName + 
                    ". Supported browsers: chrome, safari");
        }
        
        System.out.println("Started browser: " + browserName);
    }

    /**
     * Closes the browser after each test
     */
    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Universal login test using explicit waits for better compatibility
     */
    @Test
    public void loginTest() {
        // Wait for and click the "Sign In" link
        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator));
        signInLink.click();

        // Wait for email field to appear and enter email
        By emailFieldLocator = By.cssSelector(".login-container input[type='email']");
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.clear(); // Clear field in case of auto-fill
        emailField.sendKeys(EMAIL);

        // Wait for password field to appear and enter password
        By passwordFieldLocator = By.cssSelector(".login-container input[type='password']");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.clear();
        passwordField.sendKeys(PASSWORD);

        // Wait for "Sign In" button to be clickable and click it
        By signInButtonLocator = By.cssSelector(".login-container [type='submit']");
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator));
        signInButton.click();

        // Wait for welcome message to appear
        By welcomeMessageLocator = By.cssSelector(".page-header .greet.welcome");
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageLocator));

        Assert.assertTrue(welcomeMessage.isDisplayed(), "Welcome message is not displayed");
        System.out.println("Test completed successfully! User is logged in.");
    }

    /**
     * Method to run the test directly from main with browser selection
     */
    public static void main(String[] args) {
        String browser = args.length > 0 ? args[0] : "chrome";
        
        UniversalLoginTest test = new UniversalLoginTest();
        try {
            test.openBrowser(browser);
            test.loginTest();
            System.out.println("Test passed successfully in browser: " + browser);
        } catch (Exception e) {
            System.err.println("Error during test execution: " + e.getMessage());
            e.printStackTrace();
        } finally {
            test.closeBrowser();
        }
    }
}