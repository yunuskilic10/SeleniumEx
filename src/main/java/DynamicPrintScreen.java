import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class DynamicPrintScreen {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url="https://www.facebook.com/";
        driver.get(url);
        takeScreenshot(driver);
    }

    // Dinamik ekran görüntüsü alma metodu
    public static void takeScreenshot(WebDriver driver) {
        // WebDriver'dan ekran görüntüsü alma
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // Ekran görüntüsünü dosya olarak al
        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Tarih ve saat formatı oluştur
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Dosya yolunu tarih ve saate göre dinamik olarak ayarla
        String filePath = "C:\\Users\\Lenovo\\Desktop\\Screen\\screenshot_" + timeStamp + ".png";

        // Dosya oluştur
        File destFile = new File(filePath);

        // Dosya kopyalama işlemi
        try {
            FileUtils.copyFile(scrFile, destFile);
            System.out.println("Screenshot saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ekran görüntüsü kaydedilemedi: " + e.getMessage());
        }
    }
}
