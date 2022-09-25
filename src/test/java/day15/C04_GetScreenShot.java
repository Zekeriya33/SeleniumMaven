package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeAfter {

    @Test
    public void test01() throws IOException {

        // Amazon sayfasina gidelim tum sayfanin resmini alalim

        driver.get("https://www.techproeducation.com");

        /*
        Bir web sayfasinin resmini alabilmek icin TakesScreenshot class in obje olusturup
        gecici bir file class ından degiskene TakesScreenshot dan olusturdugum objeden getScreenShotAs methodunu
        kullanarak gecici bir file olustururuz
         */
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));

    }
}
