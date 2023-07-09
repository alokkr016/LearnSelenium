package me.alokdev.selenium;

import com.cognizant.flipkart.DriverSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Navigation {
    static WebDriver driver = DriverSetup.getDriver();

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;


    }
}
