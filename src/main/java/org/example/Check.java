package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Check {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String baseURL="https://demo.guru99.com/test/radio.html";
        driver.get(baseURL);
        WebElement checkbox= driver.findElement(By.id("vfb-6-0"));

        if (checkbox.isSelected()){
            System.out.println("checkbox seçili");
        }else{
            checkbox.click();
        }

  driver.quit();



    }





}
