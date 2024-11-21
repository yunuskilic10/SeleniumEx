import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class FileDownload {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://demoqa.com/upload-download";
        driver.get(url);
        //WebElement downloadButton = driver.findElement(By.id("downloadButton"));
       // downloadButton.click();
        String downloadPath = "C:/Users/Lenovo/Downloads";
        String fileName = "sampleFile.jpeg";
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(isFileDownloaded(downloadPath, fileName));
         driver.quit();

    }

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File file = new File(downloadPath);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(fileName)) {
                return true;
            }

        }
        return  false;
    }

}






