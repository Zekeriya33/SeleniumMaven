package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        // - Amazon Sayfasina gidelim
        driver.get("https://amazon.com");
        // - Account menusunden create a list linkine tiklayalim
       WebElement accountList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
       Actions actions = new Actions(driver);
       actions.moveToElement(accountList).perform();
       /*
       Bir web sitesinde bir mause ile acilan bir web elementştine ulasmak istersek
       actions.moveToElement() methodunu kullanmamiz gerekir. Aksi takdirde html kodlari arasinda
       web elementi bulur ama ulasamadigi icin exception firlatir
        */
       driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }
}
