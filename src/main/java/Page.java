import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Page {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url="https://www.guru99.com/";
        driver.get(url);
       // JavascriptExecutor js=(JavascriptExecutor)driver;
       // js.executeScript("window.scrollBy(0,550)");
       // WebElement python= driver.findElement(By.linkText("Privacy Policy"));
       //js.executeScript("arguments[0].scrollIntoView();", python);
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");



 // WebElement html= driver.findElement(By.tagName("html"));
 // html.sendKeys(Keys.SPACE);

      // Actions actions = new Actions(driver);
      // actions.sendKeys(Keys.SPACE).perform();

    }
}
