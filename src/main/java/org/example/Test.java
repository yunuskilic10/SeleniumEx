package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.time.Duration;

public class Test {
    public static void main(String[] args) {



        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.hepsiburada.com");
        driver.navigate().to("https://www.google.com.tr/?hl=tr");
        driver.manage().window().setPosition(new Point(10,0));
        driver.manage().window().setSize(new Dimension(200,100));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();



    }
}
