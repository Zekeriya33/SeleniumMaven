package Practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_GMIBankLogin {

    public static void main(String[] args) throws InterruptedException {

        // 1) https://www.gmibank.com/ adresine gidin

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.gmibank.com/ ");



        // 2) Sign butonuna basiniz

        driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-user fa-w-14 ']")).click();
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();

        // 3)

        WebElement username = driver.findElement(By.xpath("//*[@name='username']"));
        username.sendKeys("Batch81");

        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("Batch81+");

        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        Thread.sleep(3000);

        driver.close();

    }


}
