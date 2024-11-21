import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseTab {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String baseURL="https://www.amazon.com.tr";
        driver.get(baseURL);
        WebElement tabBarAccount =driver.findElement(By.id("nav-link-accountList"));
        Actions actions= new Actions(driver);
        actions.moveToElement(tabBarAccount).perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement login= driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span"));
        login.click();
        try {
            Thread.sleep(4000
            );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
