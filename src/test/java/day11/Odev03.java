package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Odev03 extends TestBaseBeforeAfter {
    @Test
    public void test01() {


        //Ödev 3
//-  amazon gidin
        driver.get("https://amazon.com");

//Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddm.getText());
//dropdown menude 40 eleman olduğunu doğrulayın
     int actualdrop = ddmList.size();
     int expecteddrop = 40 ;
        Assert.assertNotEquals(expecteddrop,actualdrop);

   //Test02
   //dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");
   //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
   //sonuc sayisi bildiren yazinin iphone icerdigini tesst edin
        WebElement sonucyazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
     String expectedAranan = "iphone";
     Assert.assertTrue(sonucyazisi.getText().contains(expectedAranan));
   //ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).click();

   //ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
        String ikinciUrunTitle = driver.getTitle();
        WebElement ikinciUrunFiyati= driver.findElement(By.xpath("//*[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        System.out.println(ikinciUrunFiyati.getText());
   //Test03
   //yeni bir sekme açarak amazon anasayfaya gidin
   //dropdown'dan bebek bölümüne secin
   //bebek puset aratıp bulundan sonuç sayısını yazdırın
   //sonuç yazsının puset içerdiğini test edin
   //5-üçüncü ürüne relative locater kullanarak tıklayin
   //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
   // Test 4
   //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }
}
