package com.cognizant.flipkart;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetUp {
	private static WebDriver driver;
	
	public static WebDriver setDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alokr\\Documents\\ChromeDriver\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disbale-popup-blocking"));
		driver = new ChromeDriver(opt);
		return driver;
	}

}