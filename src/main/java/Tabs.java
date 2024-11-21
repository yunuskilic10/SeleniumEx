import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Tabs {
    public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url="https://demo.guru99.com/popup.php";
            driver.get(url);
        WebElement href= driver.findElement(By.linkText("Click Here"));
        href.click();
            List<String> tabs=new java.util.ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.findElement(By.name("emailid")).sendKeys("aleper@gmail.com");
            driver.findElement(By.name("btnLogin")).click();
        WebElement href2= driver.findElement(By.linkText("Click Here"));
        href2.click();
        driver.switchTo().window(tabs.get(0));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();




    }
}
