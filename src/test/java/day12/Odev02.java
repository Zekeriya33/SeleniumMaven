package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;
import java.time.Duration;

public class Odev02 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {

    //    “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
//    “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement our=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Our Products']")));
        our.click();
//    Cameras product”i tiklayin
      driver.findElement(By.xpath("(//*[@class='section-title'])[2]")).click();
//    Popup mesajini yazdirin
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//*[@class='modal-content']")).getText());
//    ose” butonuna basin
    actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB,Keys.ENTER);
//    bdriverUniversity.com (IFrame)" linkini tiklayin
//
 //   http://webdriveruniversity.com/index.html" adresine gittigini test edin
}
}
