package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertion {
    /*
    -Amazon sayfasina gidelim
    -3 Farkli test methodu olusturalim
       a- url nin amazon icerdigini test edelim
       b- title in facebook icermedigini test edelim
       c- sol ust kosede amazon logosunun gorundugunu test edelim
     */

   static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
// Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor, BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
// BeforeAfter methodunda methodların static yapmaya gerek yok ama BeforeAfterCLass'da static yapmak zorunlu.


        }
    @AfterClass
    public static void tearDown(){
         driver.close();

    }
    @Test
    public void Method1() {
       // a- url nin amazon icerdigini test edelim
     String expectedUrl = "amazon";
     String actualUrl = driver.getCurrentUrl();
     Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
    @Test
    public void Method2() {
   //     b- title in facebook icermedigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void method3() {
     //   c- sol ust kosede amazon logosunun gorundugunu test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    public void test4(){
        //d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
    }


}
