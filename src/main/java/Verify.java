import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Verify {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://demo.guru99.com/test/social-icon.html";
        driver.get(url);
        String expectedData = "FaceBook";
        WebElement facebookButton = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[5]"));
        String actualData = facebookButton.getAttribute("title");
        if (expectedData.equals(actualData)) {
            System.out.println("Tooltip is valid");
        } else {
            System.out.println("Tooltip is not valid");
        }
    }
}
