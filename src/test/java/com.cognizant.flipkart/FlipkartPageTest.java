package com.cognizant.flipkart;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class FlipkartPageTest {
	String baseUrl = "https://www.flipkart.com/";
	static WebDriver driver;


	@SuppressWarnings("deprecation")
	public WebDriver getDriver() {

		driver = DriverSetUpWin.setDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void delay() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	@Test
	public void testPage() {
		FlipkartPageTest page = new FlipkartPageTest();
		//call the chrome driver
		page.getDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("return document.readyState").toString().equals("complete");
		driver.findElement(By.className("_2doB4z")).click();
		String currentUrl = driver.getCurrentUrl();

		if(currentUrl.equals(baseUrl)) {
			System.out.println("Page is loaded");
			System.out.println("Current URL is " + currentUrl);
		}else {
			System.out.println("Page is not loaded");
		}

		//
		driver.findElement(By.name("q")).sendKeys("Home appliances");
		driver.findElement(By.className("L0Z3Pu")).click();


		//
		driver.findElement(By.partialLinkText("SAMSUNG 7 kg Diamond Drum feature Fully Automatic Top L...")).click();
		page.delay();



		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		page.delay();
		driver.findElement(By.id("pincodeInputId")).sendKeys("560045");
		page.delay();
		driver.findElement(By.xpath("//span[text()='Check']")).click();
		page.delay();
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		page.delay();
		String price = driver.findElement(By.xpath("//div[div[text()='Total Amount']]/following-sibling::div/span//span")).getText();
		System.out.println(price);
		page.delay();

		Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(1));
        driver.close();
        driver.switchTo().window(handlesList.get(0));
        page.delay();
        driver.findElement(By.partialLinkText("Aqua Fresh EPICAQUA+RO+UV+UF+TDSADJUSTER 15 L RO + UV +...")).click();
        page.delay();
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		page.delay();
		driver.findElement(By.id("pincodeInputId")).sendKeys("560045");
		page.delay();
		driver.findElement(By.xpath("//span[text()='Check']")).click();
		page.delay();
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		page.delay();
		String price2 = driver.findElement(By.xpath("//div[div[text()='Total Amount']]/following-sibling::div/span//span")).getText();
		System.out.println(price2);
		Assert.assertEquals(price2, "₹20,089");
		driver.quit();

	}



}