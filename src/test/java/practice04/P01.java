package practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class P01 extends TestBaseBeforeAfter {

   // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
   // ikinci emojiye tıklayın (hayvan emojisini seçin)
   // tüm hayvan emojilerine tıklayın
   // formu doldurun (dilediğinizi yazabilirsiniz)
   // apply butonuna tıklayın


    @Test
    public void test01() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__tab'])[1]")).click();
        // tüm hayvan emojilerine tıklayın
        List<WebElement> tumHayvanEmoji=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));
        for (WebElement w: tumHayvanEmoji) {
            w.click();

        }
        driver.switchTo().defaultContent();
        // formu doldurun (dilediğinizi yazabilirsiniz)
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("zek");
        actions.sendKeys(Keys.TAB).sendKeys("ab").sendKeys(Keys.TAB).sendKeys("ab").sendKeys(Keys.TAB)
          .sendKeys("ab").sendKeys(Keys.TAB).sendKeys("as").sendKeys(Keys.TAB).sendKeys("ze").
           sendKeys(Keys.TAB).sendKeys("ze").sendKeys(Keys.TAB).sendKeys("ze").sendKeys(Keys.TAB).sendKeys("za").
           sendKeys(Keys.TAB).sendKeys("ab").sendKeys(Keys.TAB).sendKeys("ac").sendKeys(Keys.TAB)
          .sendKeys(Keys.ENTER).perform();
        }

    }
