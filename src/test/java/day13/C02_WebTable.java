package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTable extends TestBaseBeforeAfter {

    @Test
    public void test01() {
 //     login( ) metodun oluşturun ve oturum açın.
 //     https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        login();

 //     Username : manager
 //     Password : Manager1!


 //    table( ) metodu oluşturun
      table();
 //     Tüm table body’sinin boyutunu(sutun sayisi) bulun.
 //    Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

 //     printRows( ) metodu oluşturun //tr

 //     table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi :" + satirSayisi.size());

 //    Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirSayisi.forEach(t-> System.out.println(t.getText()));
 //     4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }


    private void table() {

        //     Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        /*
        Tabloda <table> tagı altında tablonun baslıgını gosteren <thead> tagı bulunur.
        Eger baslikda satir(row) varsa <thead> tagı altinda <tr> (satır-row) tagı vardır.

        Ve baslıkdaki sutunlara yani hucrelere(cell) de <th> tagı ile ulasilir.
        Baslıgın tablodaki verilere <tbody> tagı ile altındaki satırlara(row) <tr> tagı ile sutunlara yani
        hucrelere <td> tagı ile ulasilir.
         */
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//Thead//tr//th"));
        System.out.println("Sutun Sayisi : "+ sutunSayisi.size());
        //    Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : " + basliklar.getText());

        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Body : "+ body.getText());
    }

   public void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        userName.sendKeys("manager");

        actions.sendKeys(Keys.TAB).sendKeys("manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
}
