package com.cognizant.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Arrays;

public class DriverSetUpWin {
	private static WebDriver driver;
	
	public static WebDriver setDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alokr\\Documents\\ChromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		return driver;
	}

}