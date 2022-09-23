package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() {

        //Automationexercise.com adresine gidelim
        driver.get("https://www.Automationexercise.com");
        //product bölümüne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        //ilk ürünü tıklayalım

        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
    }
}
