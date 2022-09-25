package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_Odev {
    @Test
    public void readExcelTest01() throws IOException {


    //-Dosya yolunu bir String degiskene atayalimString
        String dosyaYolu = "src/resources/ulkeler.xlsx";
    //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
    //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
     //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
     //  //-sayfa 2'ye gidip satir sayisinin 6, kullanilan stun sayisinin ise 3 oldugunu test edin
        String istenen = workbook.getSheet("Sayfa2").getRow(6).getCell(3).toString();
        System.out.println(istenen);

}
}