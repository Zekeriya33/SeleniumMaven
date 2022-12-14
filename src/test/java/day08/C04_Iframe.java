package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Iframe {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {


        //   driver.close();
    }

    @Test
    public void test1() {
        //https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        /*
        bir web sitesinde bir video ()youtube vb ) varsa <iframe> tagi icerisindeyse bu video yu
        direk locate edip calistirmak dinamik olmaz . cunku link degisebilir ve locate imiz calismaz
        Bunun icin butun frame leri bir Arraylist e atip inex ile frame i secip sonrasinda
        play tusunu locate edip calistirabiliriz
         */
     //Youtube videosunu çalıştırınız
        List<WebElement>iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
      driver.switchTo().frame(iframeList.get(0));
     driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
    }
}