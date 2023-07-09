package com.cognizant.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NavigateToGym {
    public static void main(String[] args) throws Exception {
        WebDriver driver = DriverSetup.getDriver();
        driver.get("https://www.justdial.com/");
//driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        List<WebElement> popup = driver

                .findElements(By.xpath("(//span[@class='jsx-7d4b20bea75b1760 jd_modal_close jdicon'])[1]"));

        if (popup.size() == 1) {

            popup.get(0).click();

        }

// navigate back

//driver.navigate().back();

//Thread.sleep(2000);


// selecting Gym

//JavascriptExecutor js = (JavascriptExecutor) driver;

//js.executeScript("window.scrollBy(0,2 00)");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("(//div[@class='home_hotkeyimg mb-10'])[13]")).click();

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        List<WebElement> popup1 = driver

                .findElements(By.xpath("//div[@class='jsx-cde7523d8f2c91b1 jd_modal_close jdicon']"));

        if (popup.size() == 1) {

            popup.get(0).click();

        }

//clicking on see more option 

        driver.findElement(By.xpath("//*[@id=\"sectwo\"]/div[2]/div/ul/li[28]/div")).click();


//printing the sub menu items

        List<WebElement> popularModels = driver.findElements(By.xpath("//*[@id=\"sectwo\"]/div[2]/div"));

        List<String> popularModelsNames = new ArrayList<String>();

        for (int i = 0; i < popularModels.size(); i++) {

            WebElement popularModel = popularModels.get(i);

            String modelName = popularModel.getText();

            popularModelsNames.add(modelName);

        }


        System.out.println("Results:");

        for (String modelName : popularModelsNames) {

            System.out.println(modelName);


        }

    }

}