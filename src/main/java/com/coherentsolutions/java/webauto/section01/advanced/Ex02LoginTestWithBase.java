// File: Ex02LoginTestWithBase.java
// Package: com.coherentsolutions.java.webauto.section01.advanced

package com.coherentsolutions.java.webauto.section01.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class demonstrates a login test by extending the BaseTest class.
 */
public class Ex02LoginTestWithBase extends Ex01BaseTest {

    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";
    private static final String EMAIL = "selenium.tester@gmail.com";
    private static final String PASSWORD = "qyq*nbp.zcw2apq4ZQW";

    @Test
    public void loginTest() {
        driver.get(BASE_URL);

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
}