package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
/*
●Bir class oluşturun:C3_DropDownAmazon
●https://www.amazon.com/ adresinegidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/

    WebDriver driver;

    @Before
     public void setup() {

       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://www.amazon.com");

    }
    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void Test1() {
   // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu testedin
        List<WebElement> drop =driver.findElements(By.xpath("//option"));
        System.out.println(drop.size());
        for (WebElement w : drop) {
            System.out.println(w.getText());
        }
        int dropList = drop.size();
        int expectedSayi =45;
        Assert.assertNotEquals(dropList,expectedSayi);
   }
   @Test
    public void Test2() {
   //  1.Kategori menusunden Books secenegini secin
       driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).click();
      driver.findElement(By.xpath("//*[text()='Books']")).click();

   //  2.Arama kutusuna Java yazin ve aratin
       driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("java",Keys.ENTER);
   //  3.Bulunan sonuc sayisiniyazdirin
       WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
       System.out.println(sonucYazisi.getText());

   //  4.Sonucun Java kelimesini icerdigini testedin
       String expectedKelime = "Java";
       String actualSonucYazisi = sonucYazisi.getText();
       Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

   }

}
