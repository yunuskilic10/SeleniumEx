package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        String baseURL="https://www.hepsiburada.com";
        driver.get(baseURL);
        String expectedData="Türkiye'nin En Çok Tavsiye Edilen E-ticaret Markası Hepsiburada";

        String actualData= driver.getTitle();
        if (expectedData.equals(actualData)){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }

        driver.quit();

    }
}