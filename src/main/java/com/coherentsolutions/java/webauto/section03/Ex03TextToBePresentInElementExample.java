// File: Ex03TextToBePresentInElementExample.java
// Package: com.coherentsolutions.java.webauto.section03

package com.coherentsolutions.java.webauto.section03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class demonstrates the use of textToBePresentInElement condition in Selenium.
 */
public class Ex03TextToBePresentInElementExample {

    public static void main(String[] args) {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By welcomeMessageLocator = By.cssSelector(".page-header .greet.welcome");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(welcomeMessageLocator, "Welcome"));

        // Add your test steps here

        driver.quit();
    }
}