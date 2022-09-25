package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Odev01 extends C02_WebTable {

    @Test
    public void test01() {

   //   https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin

   //   Username : manager  ○ Password : Manager1!
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        userName.sendKeys("manager");

        actions.sendKeys(Keys.TAB).sendKeys("manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

   //   table( ) metodu oluşturun
   //   Tüm table body'sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunSayisiList = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        int sutunSayisi = sutunSayisiList.size();
        System.out.println("Sutun Sayisi : "+ sutunSayisi);
   //   Table'daki tum body'i ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBasliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println(tumBasliklar.getText());

        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

   //   printRows( ) metodu oluşturun //tr
   //   table body'sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        int satirSayisi = satirList.size();
        System.out.println("satirSayisi = " + satirSayisi);



   //   Table body'sinde bulunan satirlari(rows) konsolda yazdırın.
   //   4.satirdaki(row) elementleri konsolda yazdırın.
   //   printCells( ) metodu oluşturun //td
   //   table body'sinde bulunan toplam hücre(cell) sayısını bulun.
   //   Table body'sinde bulunan hücreleri(cells) konsolda yazdırın.
   //   printColumns( ) metodu oluşturun
   //   table body'sinde bulunan toplam sutun(column) sayısını bulun.
   //   Table body'sinde bulunan sutunlari(column) konsolda yazdırın.
   //   5.column daki elementleri konsolda yazdırın.
    }
}
