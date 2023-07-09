package com.cognizant.flipkart;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Slider {
    public static void main(String[] args) {
        WebDriver driver = DriverSetup.getDriver();
        driver.get("https://webapps.tekstac.com/OnlineShopping/fashion.html");

        //First Way
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('myRange').setAttribute('value',5)");

        //Second Way
        WebElement slider = driver.findElement(By.id("myRange"));
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);

    }
}
