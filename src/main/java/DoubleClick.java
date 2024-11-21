import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClick {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url="https://demo.guru99.com/test/simple_context_menu.html";
        driver.get(url);
        Actions actions=new Actions(driver);
        WebElement rightclick=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        actions.doubleClick(rightclick).perform();;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
