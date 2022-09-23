package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev01 extends TestBaseBeforeAfter {

    @Test
    public void name() throws InterruptedException {
//   1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
//   2- Hover over Me First" kutusunun ustune gelin Link 1" e tiklayin
        WebElement hoverover = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverover).perform();
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();

        //    Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //    Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //   “Click and hold" kutusuna basili tutun
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        WebElement clickAnd= driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAnd).perform();

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id='click-box']")).getText());

        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClik = driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleClik).perform();

    }
}
