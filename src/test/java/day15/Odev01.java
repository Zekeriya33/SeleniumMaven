package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class Odev01 extends TestBaseBeforeAfter {

    @Test
    public void test01() throws IOException {

        // 1- amazon anasayfaya gidin
        driver.get("https://amazon.com");
        // 2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        TakesScreenshot ts = (TakesScreenshot) driver;
        File TumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(TumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));
        // 3- Nutella icin arama yapin
        //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
    }
}
