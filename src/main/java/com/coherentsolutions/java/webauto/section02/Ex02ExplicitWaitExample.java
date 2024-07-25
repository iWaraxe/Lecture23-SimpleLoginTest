// File: Ex02ExplicitWaitExample.java
// Package: com.coherentsolutions.java.webauto.section02

package com.coherentsolutions.java.webauto.section02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class demonstrates the use of explicit wait in Selenium.
 */
public class Ex02ExplicitWaitExample {

    public static void main(String[] args) {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        // Setting explicit wait for 5 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = wait.until(ExpectedConditions.visibilityOfElementLocated(signInLinkLocator));
        signInLink.click();

        // Add your test steps here

        driver.quit();
    }
}