// File: Ex06FluentWaitExample.java
// Package: com.coherentsolutions.java.webauto.section02.advanced

package com.coherentsolutions.java.webauto.section02.advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * This class demonstrates the use of FluentWait in Selenium.
 */
public class Ex06FluentWaitExample {

    public static void main(String[] args) {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        // Setting up FluentWait with a timeout of 10 seconds and polling interval of 1 second
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = wait.until(driver1 -> driver1.findElement(signInLinkLocator));
        signInLink.click();

        // Add more test steps with fluent waits

        driver.quit();
    }
}