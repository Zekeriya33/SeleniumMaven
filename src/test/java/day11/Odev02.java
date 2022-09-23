package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev02 extends TestBaseBeforeAfter {
    @Test
    public void test01() {


      //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video'yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

    //videoyu izlemek icin Play tusuna basin
        List<WebElement> iframelist = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframelist.get(0));
      driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
   driver.switchTo().defaultContent();
        //videoyu calistirdiginizi test edin

        WebElement youtubeLink =driver.findElement(By.xpath("//*[@aria-label='youtube.com sitesinde izle']"));
        Assert.assertTrue(youtubeLink.isDisplayed());
}
}
