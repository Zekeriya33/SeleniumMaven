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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    WebDriver driver;
    Select select;

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
    public void test1() {
      // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu testedin

       WebElement ddm =driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi = 45;
        int actualDds = ddmList.size();
        Assert.assertNotEquals(actualDds,expectedSayi);

        /*
        Dropdown menuye ulasmak icinn Select clasindan bir obje olustururuz.
        ve locate ettigimiz dropDown webelementini Select class ina tanimlariz
        ve getOptions() methodunu kullanarak dropDown bir list e atarak dropdown menunun
        butun elemanlarini sayisina ulasabiliriz
         */

    }
    @Test
    public void test2() {
  //    1.Kategori menusunden Books secenegini secin
        WebElement ddm =driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select =new Select(ddm);
      //  select.selectByVisibleText("Books"); // Eger dropdown menudeki options a string olarak ulasmak istersek bunu kullaniriz
      //  select.selectByIndex(5); //Eger dropdown menudeki options a index olarak ulasmak istersek bunu kullaniriz
          select.selectByValue("search-alias=stripbooks-intl-ship"); // value olarak almak istersek
  //    2.Arama kutusuna Java yazin vearatin
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
  //    3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());
  //    4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));




    }
}
