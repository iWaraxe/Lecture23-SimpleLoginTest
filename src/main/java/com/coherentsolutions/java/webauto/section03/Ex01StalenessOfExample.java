// File: Ex01StalenessOfExample.java
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
 * This class demonstrates the use of stalenessOf condition in Selenium.
 */
public class Ex01StalenessOfExample {

    public static void main(String[] args) {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = driver.findElement(signInLinkLocator);
        signInLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(signInLink));

        // Add your test steps here

        driver.quit();
    }
}