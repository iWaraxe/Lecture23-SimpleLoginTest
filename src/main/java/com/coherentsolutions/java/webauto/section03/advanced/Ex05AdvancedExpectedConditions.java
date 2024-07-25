// File: Ex05AdvancedExpectedConditions.java
// Package: com.coherentsolutions.java.webauto.section03.advanced

package com.coherentsolutions.java.webauto.section03.advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class demonstrates advanced usage of different ExpectedConditions in Selenium.
 */
public class Ex05AdvancedExpectedConditions {

    public static void main(String[] args) {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Waiting for title to be specific value
        wait.until(ExpectedConditions.titleIs("Home Page"));

        // Waiting for an element to be visible
        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = wait.until(ExpectedConditions.visibilityOfElementLocated(signInLinkLocator));
        signInLink.click();

        // Waiting for specific text to be present in an element
        By welcomeMessageLocator = By.cssSelector(".page-header .greet.welcome");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(welcomeMessageLocator, "Welcome"));

        // Waiting for element to disappear from the DOM
        WebElement welcomeMessage = driver.findElement(welcomeMessageLocator);
        wait.until(ExpectedConditions.stalenessOf(welcomeMessage));

        // Add more test steps with advanced expected conditions

        driver.quit();
    }
}