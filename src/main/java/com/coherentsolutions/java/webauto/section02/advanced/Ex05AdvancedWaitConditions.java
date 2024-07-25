// File: Ex05AdvancedWaitConditions.java
// Package: com.coherentsolutions.java.webauto.section02.advanced

package com.coherentsolutions.java.webauto.section02.advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class demonstrates advanced use of explicit waits with different ExpectedConditions in Selenium.
 */
public class Ex05AdvancedWaitConditions {

    public static void main(String[] args) {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Example of waiting for element to be visible
        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = wait.until(ExpectedConditions.visibilityOfElementLocated(signInLinkLocator));
        signInLink.click();

        // Example of waiting for text to be present in element
        By welcomeMessageLocator = By.cssSelector(".page-header .greet.welcome");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(welcomeMessageLocator, "Welcome"));

        // Example of waiting for title to be specific value
        wait.until(ExpectedConditions.titleIs("Expected Title"));

        // Add more test steps with advanced waits

        driver.quit();
    }
}