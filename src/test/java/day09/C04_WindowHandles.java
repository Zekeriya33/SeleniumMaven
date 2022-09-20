package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandles {


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
        driver.quit();
    }

    @Test
    public void test1 () throws InterruptedException {
  //   https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
  //   Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());
  //   Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
  //   Click Here butonuna basın.
        /*
        Bir web sitesine gittiginizde bir web elementi tıkladiginizda yeni bir sekme yada pencee acilirsa
        bu yeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() methodunu bir
        Arraylist e atip butun sayfalarin listesine ulasabilirim. ilk actıgım pencerenin index i 0(sıfır)dir
        ikinci acilan pencerenin index i 1(bir) dir ve ikinci acilan penceede yaa sekmede islem yapabilmek icin
         driver.switchTo().window(listAdi.get(1)) methodu kullanilir

         */
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Thread.sleep(2000);
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

  //   Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window",driver.getTitle());
  //   Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
  //   Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());

    }
}
