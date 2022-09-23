package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExistsDownLoad extends TestBaseBeforeAfter {
    @Test
    public void test01() {

        //   https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
//   test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
//   dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu = "C:\\Users\\asus\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // indirildigini konsolda gosterin

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
    }

}
