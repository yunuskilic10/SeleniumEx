import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class BrakLink {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String baseurl="https://www.facebook.com/";
        driver.get(baseurl);
        //atılan urlleri tutmak için kullanılır.
        String url="";
        //bağlanıtı istegi göndermemiz  için gerekli sınıf
        HttpURLConnection huc=null;
        int resCode=200;
      List<WebElement>links= driver.findElements(By.tagName("a"));
      //iterativ değişekenine ihtiyacım var liste halinde fakat next next diyebiliceğim bir sıraya sokmak için kullanacağım.

        Iterator<WebElement> it= links.iterator();
        while(it.hasNext()){
            url=it.next().getAttribute("href");
            if (url==null || url.isEmpty()){
                System.out.println("Bu bağlantı boş geçildi.");
                continue;


            }
            if (!url.startsWith(baseurl)){
                System.out.println("Url bizim sayfamıza ait değil geçildi");
                continue;
            }
            try {
                huc=(HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod("HEAD");

                huc.connect();
                resCode= huc.getResponseCode();
                if (resCode>=400){
                    System.out.println(url+" -kırık link");
                }else {
                    System.out.println(url+" geçerli link");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    driver.quit();


    }
}
