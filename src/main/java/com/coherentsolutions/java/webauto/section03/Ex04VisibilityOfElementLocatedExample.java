// File: Ex04VisibilityOfElementLocatedExample.java
// Package: com.coherentsolutions.java.webauto.section03

package com.coherentsolutions.java.webauto.section03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class demonstrates the use of visibilityOfElementLocated condition in Selenium.
 */
public class Ex04VisibilityOfElementLocatedExample {

    public static void main(String[] args) {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = wait.until(ExpectedConditions.visibilityOfElementLocated(signInLinkLocator));
        signInLink.click();

        // Add your test steps here

        driver.quit();
    }
}