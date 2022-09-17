package day07;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;

import java.time.Duration;

public class C01_Assertions {
    /*
    Bir Class olusturalim YanlisEmailTesti
http://automationpractice.com/index.php sayfasina gidelim
Sign in butonuna basalim
Email kutusuna @isareti olmayan bir mail yazip enter’a
bastigimizda “Invalid email address” uyarisi ciktigini test edelim
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
       // driver.close();
    }
    @Test
    public void Test1() {

       // http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/");
        // Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();

      //  Email kutusuna @isareti olmayan bir mail yazip enter’a

        WebElement email = driver.findElement(By.xpath("//*[@id='email_create']"));
        email.sendKeys("zekeriya.bozkurt.gmail.com", Keys.ENTER);
        //  bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());



    }
}