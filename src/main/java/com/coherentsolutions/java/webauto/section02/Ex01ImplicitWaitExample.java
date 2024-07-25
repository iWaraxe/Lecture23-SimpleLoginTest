// File: Ex01ImplicitWaitExample.java
// Package: com.coherentsolutions.java.webauto.section02

package com.coherentsolutions.java.webauto.section02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * This class demonstrates the use of implicit wait in Selenium.
 */
public class Ex01ImplicitWaitExample {

    public static void main(String[] args) {
        // Set up the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Setting implicit wait for 5 seconds
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");

        // Add your test steps here

        driver.quit();
    }
}