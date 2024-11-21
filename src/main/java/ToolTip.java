import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ToolTip {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url="https://demo.guru99.com/test/delete_customer.php";
        driver.get(url);
        WebElement input=driver.findElement(By.name("cusid"));
        WebElement submit =driver.findElement(By.name("submit"));
        input.sendKeys("8888");
        submit.click();
        Alert alert =driver.switchTo().alert();

        System.out.println(   alert.getText());
        alert.accept();
        Alert alert2 =driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.accept();

    }
}
