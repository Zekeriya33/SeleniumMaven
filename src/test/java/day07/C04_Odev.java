package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_Odev {
    /*
    Bir class oluşturun: DropDown
https://the-internet.herokuapp.com/dropdown adresine gidin.
Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
Tüm dropdown değerleri(value) yazdırın
Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
False yazdırın.
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
    public void tearDown() {
     //   driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
  //   https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
  //   Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        Thread.sleep(1000);
  //   Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        Thread.sleep(1000);
  //   Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
   //   Tüm dropdown değerleri(value) yazdırın
        System.out.println(ddm.getText());
        //   Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
  //   False yazdırın.
        List<WebElement> drop =select.getOptions();
        if (drop.size()==4){
            System.out.println("True");
        } else System.out.println("False");


    }
}
