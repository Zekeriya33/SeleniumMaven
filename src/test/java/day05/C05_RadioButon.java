package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButon {
/*
    1. Bir class oluşturun : RadioButtonTest

    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
     https://www.facebook.com adresine gidin
               - Cookies’i kabul edin
     “Create an Account” button’una basin
     “radio buttons” elementlerini locate edin
     Secili degilse cinsiyet butonundan size uygun olani secin

 */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

      }
    @After
    public void tearDown() {driver.close();

    }

    @Test
    public void method1() throws InterruptedException {
  //  https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
  //- Cookies’i kabul edin
  // “Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
  // “radio buttons” elementlerini locate edin
        WebElement kadin = driver.findElement(By.xpath("//*[text()='Kadın']"));
        WebElement erkek = driver.  findElement(By.xpath("//*[text()='Erkek']"));
        WebElement ozel = driver.  findElement(By.xpath("//*[text()='Özel']"));

  // Secili degilse cinsiyet butonundan size uygun olani secin
        if (!erkek.isSelected()){
            erkek.click();
        }
        Thread.sleep(3000);
        kadin.click();
        Thread.sleep(3000);
        ozel.click();

    }
}
