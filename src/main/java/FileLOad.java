import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileLOad {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url="https://demo.guru99.com/test/upload/";
        driver.get(url);
        WebElement uploadFile= driver.findElement(By.id("uploadfile_0"));
        uploadFile.sendKeys("C:\\Users\\Lenovo\\Desktop\\Maven\\SeleniumIntroduction\\src\\images\\fb.jpg");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submitbutton")).click();


    }
}
