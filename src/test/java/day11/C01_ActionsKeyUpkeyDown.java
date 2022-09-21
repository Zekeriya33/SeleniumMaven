package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_ActionsKeyUpkeyDown extends TestBaseBeforeAfter {

    @Test
    public void test01() {

 //    https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
 //    Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        actions = new Actions(driver);
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").keyDown(Keys.SHIFT). // shift tusuna otomasyon ile bu sekilde kullanilir.Shift tusuna basmak icin
                                                   // KeyDown Shitf ten cikmak icin KeyUp kullanilir
                sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).perform();
             //    aramanin gerceklestigini test edin

        WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());
    }

}
