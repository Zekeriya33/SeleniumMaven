package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C03_WebTables extends C02_WebTable {
    
    // bir onceki class daki adrese gidelim
    //login() methodunu kullanarak sayfaya giris yapalim
    // input olarak verilen satir sayisi ve sutun sayisina sahip cell deki text i yazdiralim

    



    @Test
    public void test01() {
        int satir =3;
        int sutun =4;
//login() methodunu kullanarak sayfaya giris yapalim
        login();
        // input olarak verilen satir sayisi ve sutun sayisina sahip cell deki text i yazdiralim
        WebElement istenen =driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(istenen.getText());

        // price basligindaki tum numaralari yazdirin
        List<WebElement> priceBasligi = driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement w: priceBasligi
             ) {
            System.out.println(w.getText());

        }

    }
}
