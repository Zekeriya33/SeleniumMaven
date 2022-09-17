package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ornek {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully - -3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
4. Click on 'Signup / Login' button               -4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
5. Verify 'Login to your account' is visible     -5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
6. Enter correct email address and password      -6  Doğru e-posta adresini ve şifreyi girin
7. Click 'login' button                              7. 'Giriş' düğmesini tıklayın
8. Verify that 'Logged in as username' is visible  8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
9. Click 'Delete Account' button                   9. 'Hesabı Sil' düğmesini tıklayın
10. Verify that 'ACCOUNT DELETED!' is visible    10 - 10. 'HESAP SİLİNDİ!' görünür
     */


 static WebDriver driver;
  @BeforeClass
    public static void setup() {
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.get("http://automationexercise.com");

  }
  @AfterClass
    public static void tearDown() {
      driver.close();
  }
  @Test
    public void method1() {
  // 3. Verify that home page is visible successfully
    WebElement homePage = driver.findElement(By.xpath("//*[text()= ' Home']"));
    Assert.assertTrue(homePage.isDisplayed());
  }
  @Test
  public void method2() {
  // 4. Click on 'Signup / Login' button
  driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

  }
  @Test
  public void method3() {
    // Verify 'Login to your account' is visible
    WebElement loginButton = driver.findElement(By.xpath("//*[text()='Login to your account']"));
    Assert.assertTrue(loginButton.isDisplayed());

  }
  @Test
  public void method4() throws InterruptedException {
    WebElement eMail= driver.findElement(By.xpath("//*[@data-qa='login-email']"));
    WebElement password =driver.findElement(By.xpath("//*[@data-qa='login-password']"));
    eMail.sendKeys("bozkurt.zekeriya@gmail.com");
    Thread.sleep(3000);
    password.sendKeys("Test1234!");
   // 7. Click 'login' button
   driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

  }
  @Test
    public void method5() {
      // 8. Verify that 'Logged in as username' is visible
    WebElement loggedUsername = driver.findElement(By.xpath("//*[text()=' Logged in as '] "));
    Assert.assertTrue(loggedUsername.isDisplayed());
  }

  @Test
    public void Method6() {
      // 9. Click 'Delete Account' button
      WebElement delete = driver.findElement(By.xpath("//*[text()=' Delete Account']"));
      delete.click();

  }
  @Test
    public void method7() {
      // 10. Verify that 'ACCOUNT DELETED!' is visible
    WebElement accountDeleted =  driver.findElement(By.xpath("(//*[@style='color:brown;'])[2]"));
    Assert.assertTrue(accountDeleted.isDisplayed());
  }



}
