package Practise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_LoginTest extends TestBaseBeforeAfter {


    @Test
    public void test1() {


    // 1) https://www.koalaresorthotels.com/ sayfasina gidiniz.
        driver.get("https://www.koalaresorthotels.com/");

    // 2) login butonuna tikla
        driver.findElement(By.xpath("//*[text()='Log in']")).click();

    // 3) Login ekranina girdiginizi 4 farkli web elementi kullanarak dogrulayiniz
       // a)
        Assert.assertTrue( driver.findElement(By.xpath("(//*[text()='Log in']) [3]")).isDisplayed());
      // b)
        Assert.assertTrue("Login Ekranina Giris Yapilmadi",driver.getTitle().contains("Log in"));
      // c)

        String expectedUrl = "https://www.koalaresorthotels.com/Account/Logon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Login Ekranina Giris Yapilmadi", expectedUrl, actualUrl);
      // d)
        Assert.assertTrue("URL yanlis", driver.getCurrentUrl().contains("Logon"));

    }
}
