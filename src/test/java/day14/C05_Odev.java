package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
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

        int satirSayisi = workbook.getSheet("Sayfa2").getLastRowNum()+1;
        int sutunSayisi = workbook.getSheet("Sayfa2").getRow(0).getLastCellNum();

        System.out.println("satir sayisi " + satirSayisi );
        System.out.println("sutun Sayisi " + sutunSayisi);
        Assert.assertEquals(satirSayisi,6);
        Assert.assertEquals(sutunSayisi,3);

        int kullanilanSatir = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        // Excel tablosunda kullanılan satır sayısını bu method ile alırız
        System.out.println(kullanilanSatir);
        int expectedKullanSatir = 4;
        Assert.assertEquals(expectedKullanSatir,kullanilanSatir);
}
}