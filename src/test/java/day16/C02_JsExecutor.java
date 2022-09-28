package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JsExecutor extends TestBaseBeforeAfter {

    @Test
    public void test01() {

        // Amazon sayfasına  Gidelim
        driver.get("https://amazon.com");
        // Asagidaki carrers butonunu gorunceye kadar js ile scroll yapalim
        WebElement carrers = driver.findElement(By.xpath("//a[text()='Careers']"));
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);
        // Carrers butonuna Js ile clik yapalim
        jse.executeScript("arguments[0].click();",carrers);
    }
}
