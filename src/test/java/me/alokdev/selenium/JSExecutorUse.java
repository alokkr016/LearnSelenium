package me.alokdev.selenium;

import com.cognizant.flipkart.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class JSExecutorUse {
    static WebDriver driver = DriverSetup.getDriver();

    public static void main(String[] args) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('APjFqb').value = 'India'");
        WebElement searchBtn = driver.findElement(By.xpath("//input[@class='gNO89b']"));
        js.executeScript("arguments[0].click()",searchBtn);
        js.executeScript("window.scroll(0,document.body.scrollHeight)");
    }
}
