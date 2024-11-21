import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseDrag {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url="https://demo.guru99.com/test/simple_context_menu.html";
        driver.get(url);
        Actions actions=new Actions(driver);
        WebElement rightclick=driver.findElement(By.xpath("//*[@id='authentication']/span"));
        actions.contextClick(rightclick).perform();
        WebElement copy= driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        copy.click();
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
