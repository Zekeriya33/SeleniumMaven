package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {

    WebDriver driver ;

    @Before
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1 () {

//1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        /*
        Eger bize verilen task te sayfalar arasi gecis varsa her driver.get() methodundan sonra
        driver in windowhandle degerini string bir degisken e atariz
        Sonrasinda farkli bir sayfaya yada sekmeye gittikten sonra tekrar ilk sayfaya donmemiz istenirse
        String degisken e atadigimiz window handle degerleriyle  sayfalar arasi gecis yapabiliriz

         */
//2- Url'nin amazon içerdiğini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);  // yeni bir pencere acmak icin bu methodu kullaniriz
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();
//4- title'in BestBuy içerdiğini test edelim
        String actualTitle= driver.getTitle();
        String expectedTitle = "Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

//5- İlk sayfaya dönüp sayfada java aratalım
      driver.switchTo().window(amazonWindowHandle); // sayfalar arasi gecis cin bu method kullanilir
        WebElement arama = driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("java", Keys.ENTER);
//6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramasonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime = "java";
        String actualSonuc = aramasonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKelime));

//7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);

//8- Logonun görünürlüğünü test edelim
        WebElement logo = driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
//9- Sayfaları Kapatalım
    }

}
