package com.cognizant.flipkart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


import java.util.Arrays;

public class DriverSetupMac {
    private static WebDriver driver;

    public static WebDriver setDriver() {
        WebDriverManager.chromedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disbale-popup-blocking"));
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        return driver;
    }

}