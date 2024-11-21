import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseDrop {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String baseURL ="http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-1.html";

        driver.get(baseURL);
        WebElement student1 = driver.findElement(By.id("box1"));

        WebElement teamA = driver.findElement(By.id("dropBox"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(student1,teamA).build().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
