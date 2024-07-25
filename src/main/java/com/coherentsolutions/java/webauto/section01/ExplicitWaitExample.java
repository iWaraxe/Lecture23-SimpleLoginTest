// File: ExplicitWaitExample.java
// Package: com.coherentsolutions.java.webauto.section01

package com.coherentsolutions.java.webauto.section01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

/**
 * This class demonstrates the use of explicit wait in Selenium.
 */
public class ExplicitWaitExample {
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";
    private static final String EMAIL = "selenium.tester@gmail.com";
    private static final String PASSWORD = "qyq*nbp.zcw2apq4ZQW";

    public static void main(String[] args) {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = wait.until(ExpectedConditions.visibilityOfElementLocated(signInLinkLocator));
        signInLink.click();


        // Locate the email field and enter the email
        By emailFieldLocator = By.cssSelector(".login-container input[type='email']");
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.sendKeys(EMAIL);

        // Locate the password field and enter the password
        By passwordFieldLocator = By.cssSelector(".login-container input[type='password']");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.sendKeys(PASSWORD);

        // Locate and click the sign-in button
        By signInButtonLocator = By.cssSelector(".login-container [type='submit']");
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator));
        signInButton.click();

        // Locate the welcome message and assert its visibility
        By welcomeMessageLocator = By.cssSelector(".page-header .greet.welcome");
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageLocator));

        Assert.assertTrue(welcomeMessage.isDisplayed());

        driver.quit();
    }
}