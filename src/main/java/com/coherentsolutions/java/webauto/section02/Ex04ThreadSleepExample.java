// File: Ex04ThreadSleepExample.java
// Package: com.coherentsolutions.java.webauto.section02

package com.coherentsolutions.java.webauto.section02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates the use of Thread.sleep in Selenium (not recommended).
 */
public class Ex04ThreadSleepExample {

    public static void main(String[] args) {
        try {
            // Set up the WebDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();

            // Initialize the WebDriver instance
            WebDriver driver = new ChromeDriver();
            driver.get("https://magento.softwaretestingboard.com/");

            // Using Thread.sleep (not recommended)
            Thread.sleep(10000); // Sleep for 1 second

            // Add your test steps here

            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}