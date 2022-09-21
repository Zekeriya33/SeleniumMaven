package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C04_FileExists  {

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir")); // C:\Users\asus\IdeaProjects\com.Batch81JUnit
        // şuan ki icinde bulundugumuz yolu gosterir
        System.out.println(System.getProperty("user.home")); // C:\Users\asus
        // gecerli kullanicinin ana dizinini verir

        String dosyayolu = "C:\\Users\\asus\\OneDrive\\Masaüstü\\text.txt";
       // System.out.println(Files.exists(Paths.get(dosyayolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
        /*
        Bir web sitesinden indirdigimiz yada windows icinde olusturdugumuz dosyanın indigini yada orda oldugunu
        test edebilmem icin o dosyanın uzerine shift tusuna basili olarak sag klik yapıp dosyanin yolu kopyalayip
        bir string degiskene atariz ve dosyayi dogrulamak icin
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu))); bu methodu kullaniriz

         */
    }
}
