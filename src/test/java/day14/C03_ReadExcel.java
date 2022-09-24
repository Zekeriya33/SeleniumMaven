package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExcelTest01() throws IOException {

     //   Belirtilen satir ve sutun no degerlerini parametre olarak alip o cell deki datayi konsola yazdiralim

     // Sonucun konsolda yazan ile ayni oldugunu dogrulayalim

     int satirNo = 12;
     int sutunNo = 2;

     String dosyaYolu= "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String actualData = workbook.getSheet("Sayfa1").getRow(satirNo-1).getCell(sutunNo-1).toString();
        System.out.println(actualData);
        String expectedData = "Baku";
     // Index 0 dan basladigi icin bizden istenen satira ulasabilmek icin bir eksigini aliriz

        Assert.assertEquals(expectedData,actualData);

    }
}
