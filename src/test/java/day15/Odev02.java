package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Odev02 {

    @Test
    public void test01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalimString
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
   //  1.satirdaki 2.hucreye gidelim ve yazdiralim
        String birinciSatirIkinciHucre= workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(birinciSatirIkinciHucre);

   //  2.satir 4.cell'in afganistan'in baskenti oldugunu test edelim
        String actualAfganBaskent = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedAfganBaskent = "Kabil";
        Assert.assertEquals(expectedAfganBaskent,actualAfganBaskent);

   //  Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum()+1;
        System.out.println(satirSayisi);
   //  Fiziki olarak kullanilan satir sayisini bulun
        int fizikiSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("fizikiSatirSayisi = " + fizikiSatirSayisi);
   //  Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String ,String> ulkelerMap = new HashMap<>();

        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <=sonSatir ; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            ulkelerMap.put(key,value);

        }
        System.out.println("ulkelerMap = " + ulkelerMap);
    }
}
