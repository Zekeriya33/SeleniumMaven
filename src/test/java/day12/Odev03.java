package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev03 extends TestBaseBeforeAfter {

    /*
    1."http://webdriveruniversity.com/" adresine gidin
 2."Login Portal" a  kadar asagi inin
 3."Login Portal" a tiklayin
  4.Diger window'a gecin
 5."username" ve  "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin  8.Ok diyerek Popup'i kapatin
Ilk sayfaya geri donun
Ilk sayfaya donuldugunu test edin
     */

    @Test
    public void test01() throws InterruptedException {
 //     1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
 //     2."Login Portal" a  kadar asagi inin
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
 //     3."Login Portal" a tiklayin
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//h4)[2]")).click();
 //     4.Diger window'a gecin
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
    //     5."username" ve  "password" kutularina deger yazdirin 6."login" butonuna basin
        WebElement username = driver.findElement(By.xpath("//*[@id='text']"));
        Thread.sleep(3000);
        username.sendKeys("Zekeriya");
        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).sendKeys("12345").sendKeys(Keys.TAB,Keys.ENTER).perform();
 //
 //     7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualPopUp = driver.switchTo().alert().getText();
        Thread.sleep(3000);
        String expectedPopUp = "validation failed";
        Assert.assertEquals(expectedPopUp,actualPopUp);
  //   8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
 //     Ilk sayfaya geri donun
        driver.switchTo().window(windowList.get(0));
 //     Ilk sayfaya donuldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "WebDriverUniversity.com";
        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
