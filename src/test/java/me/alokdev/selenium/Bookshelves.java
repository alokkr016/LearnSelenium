package com.cognizant;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Bookshelves {

	public String baseUrl = "https://www.urbanladder.com/";
	public WebDriver driver;
	public JavascriptExecutor js;

	@BeforeTest
	public void launchWebsite() throws InterruptedException {
		driver = DriverSetup.getDriver("Chrome");
		// Launch and maximize
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(priority = 0)
	public void scrollAndClick() throws InterruptedException {
		// Scroll down
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// click on bookshelves
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[3]/a[5]")).click();
		Thread.sleep(5000);

		// To close the pop up
		driver.findElement(By.xpath("//*[@id=\"authentication_popup\"]/div[1]/div/div[2]/a[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void setThePriceFilter() throws InterruptedException {
		// Clicking on price caret
		driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]/div")).click();
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']"));
		Actions action = new Actions(driver);
		// set on price range
		action.dragAndDropBy(frame, -244, 0).perform();

		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void selectTheStorageType() throws InterruptedException {
		// select storage type
		// Click on storage caret
		driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[1]/div")).click();
		Thread.sleep(3000);

		// select open
		driver.findElement(By.xpath("//input[@id='filters_storage_type_Open']")).click();
		Thread.sleep(3000);
		// list of bookshelves
		List<WebElement> bookshelves = driver
				.findElements(By.xpath("//*[@class='product-title product-title-sofa-mattresses']/span"));

		// list of price
		List<WebElement> prices = driver.findElements(By.xpath("//*[@class='price-number']/span"));

		// printing 3 bookshelves details
		for (int i = 0; i < 3; i++) {

			String bookshelf = bookshelves.get(i).getText();
			String price = prices.get(i).getText().substring(1);

			System.out.println(bookshelf);
			System.out.println(price);

		}

		// navbar
		WebElement navbar = driver.findElement(By.id("topnav_wrapper"));
		js.executeScript("arguments[0].scrollIntoView();", navbar);
		Thread.sleep(3000);

		// click on Gift card
		driver.findElement(By.xpath("//*[@id=\"header\"]/section/div/ul[2]/li[3]/a")).click();

	}

	@Test(priority = 3)
	public void chooseBirthdayCard() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

		// Click on B'day card
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]")).click();
		Thread.sleep(3000);

		// Entering amount
		driver.findElement(By.xpath("//input[@id='ip_2251506436']")).sendKeys("1000");
		Thread.sleep(2000);

		// Select month
		Select month = new Select(driver.findElement(
				By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[4]/select[1]")));
		month.selectByValue("7/2023");

		//select date
		Select date = new Select(driver.findElement(
				By.xpath("//*[@id=\'app-container\']/div/main/section/section[2]/div/section[2]/div[4]/select[2]")));
		date.selectByVisibleText("18");

		//Click on next button
		driver.findElement(By.xpath("//button[@class='_1IFIb _1fVSi action-button _1gIUf _1XfDi']")).click();

	}
//
//	@Test(priority = 4)
//	public void fillDetails() throws InterruptedException, IOException {
//		String path = "src/main/java/com/cognizant/Book.xlsx";
//		// Recipient
//		String[] recipientDetails = ReadExcel.getData(path, 0).split(" ");
//
//		driver.findElement(By.id("ip_4036288348")).sendKeys(recipientDetails[0]);
//		driver.findElement(By.id("ip_137656023")).sendKeys(recipientDetails[1]);
//		driver.findElement(By.id("ip_3177473671")).sendKeys(recipientDetails[2]);
//
//		// Sender
//		String[] senderDetails = ReadExcel.getData(path, 1).split(" ");
//		driver.findElement(By.id("ip_1082986083")).sendKeys(senderDetails[0]);
//		driver.findElement(By.id("ip_4081352456")).sendKeys(senderDetails[1]);
//		driver.findElement(By.id("ip_2121573464")).sendKeys(senderDetails[2]);
//		driver.findElement(By.id("ip_2194351474")).sendKeys(senderDetails[3]);
//		driver.findElement(By.id("ip_567727260")).sendKeys(senderDetails[4]);
//
//		Thread.sleep(3000);
//
//		String error = driver.findElement(By.xpath("//div[@class='_1HVuH']")).getText();
//
//		System.out.println(error);
//
//		driver.findElement(By.id("ip_567727260")).clear();
//		Thread.sleep(3000);
//		driver.findElement(By.id("ip_567727260")).sendKeys("560005");
//
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//button[@class='_3Hxyv _1fVSi action-button _1gIUf _1XfDi']")).click();
//
//		String error2 = driver.findElement(By.xpath("//input[@name='recipient_mobile_number']")).getAttribute("title");
//		System.out.println(error2);
//
//		driver.findElement(By.id("ip_3177473671")).clear();
//		driver.findElement(By.id("ip_3177473671")).sendKeys("8985425562");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@class='_3Hxyv _1fVSi action-button _1gIUf _1XfDi']")).click();
//
//		Thread.sleep(3000);
//
//		driver.navigate().back();
//
//		Thread.sleep(3000);
//
//	}
//
//	@Test(priority = 5)
//	public void retrieveAllSubmenuItemsAtHome() throws InterruptedException {
//
//		driver.findElement(By.xpath("//li[@data-group='brand']")).click();
//
//		driver.findElement(By.xpath("//input[@id='filters_brand_name_By_home']")).click();
//
//		Thread.sleep(3000);
//
//		WebElement home = driver
//				.findElement(By.xpath("//ul[@class='productlist withdivider clearfix bookshelves productgrid']"));
//
//		List<WebElement> beingHomeProduct = home
//				.findElements(By.xpath("//div[@class='product-title product-title-sofa-mattresses']/span"));
//
//		List<WebElement> beingHomePrice = home.findElements(By.xpath("//div[@class='price-number']/span"));
//
//		System.out.println("Total number of products" + beingHomeProduct.size());
//
//		for (int i = 0; i < beingHomeProduct.size(); i++) {
//
//			String productName = beingHomeProduct.get(i).getText();
//
//			String productPrice = beingHomePrice.get(i).getText().substring(1);
//
//			System.out.println(productName);
//
//			System.out.println(productPrice);
//
//		}
//	}
//
//	@AfterTest
//	public void terminateBrowser() {
//		driver.close();
//	}

}
