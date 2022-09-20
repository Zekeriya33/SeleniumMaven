package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_odev01 {

    WebDriver driver ;

    @Before
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void test1 (){


//  http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    driver.get("http://demo.guru99.com/test/guru99home/");
//  sayfadaki iframe sayısını bulunuz.
//  ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement link = driver.findElement(By.xpath("//*[@height='315']"));
        driver.switchTo().frame(link);
       driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
//  ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
//  ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
//  tıklayınız

}
}
