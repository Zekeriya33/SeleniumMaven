package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_deleteExcel {

    //-Dosya yolunu bir String degiskene atayalim
    //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //-WorkbookFactory.create(fileInputStream)
    //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
    //-Row objesi olusturun sheet.getRow(3)
    //-Cell objesi olusturun row.getCell(3)
    //-3. Satır 3. Cell'deki veriyi silelim
    //-Silindiğini test edin

    @Test
    public void test01() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // Olusturmus oldugumuz dosyayı sistemde isleme alir

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); // Workbook objesiyle fis  objesi ile akisa aldıgımız dosyamizla bir exceel dosyası create ettik

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); // Excel dosyamiza calismak istedigimiz sayfayi bu sekilde seceriz

        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); // Sayfa 1 deki 3. satirı bu sekilde seceriz

        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3); // satir sacimi yapildiktan sonra hucre secimi bu sekilde yapilir
       // -3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);
        /*
        Bir cell deki veriyi silmek icin row objesine ihtiyac vardir.
        row objesi ile removeCell(9 methodu kullanarak cell objesi ile belirttigimiz cell degerini silebiliriz
         */
       FileOutputStream fos = new FileOutputStream(dosyaYolu);
       workbook.write(fos);

        //-Silindiğini test edin

      //  String expectedData= "Cezayir";
      //  String actualData = null;

   //   String actualData = workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
   //     Assert.assertTrue(actualData.isEmpty());

    }
}
