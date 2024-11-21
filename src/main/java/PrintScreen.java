import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PrintScreen {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url="https://www.facebook.com/";
        driver.get(url);
        takeScreenshot(driver,"C:\\Users\\Lenovo\\Desktop\\Screen\\facebook.png");
        driver.quit();

       // TakesScreenshot scrShot=((TakesScreenshot)driver );
      // File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
       //File destFile=new File("C:\\Users\\Lenovo\\Desktop\\Screen\\test.png");
        //try {
          //  FileUtils.copyFile(scrFile,destFile);
       // } catch (IOException e) {
            //throw new RuntimeException(e);
       // }

    }
    public static void takeScreenshot(WebDriver driver, String filePath) {
        // WebDriver'dan ekran görüntüsü alma
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // Ekran görüntüsünü dosya olarak al
        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Dosya yolunu belirt
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
