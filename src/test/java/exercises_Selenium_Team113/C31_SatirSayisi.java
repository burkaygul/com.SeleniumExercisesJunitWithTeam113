package exercises_Selenium_Team113;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C31_SatirSayisi {


    @Test
    public void test01() throws IOException {

        // Sayfa2'de kullanilan satir sayisinin 6 oldugunu test edin
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        int actualRowsNm = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedRows = 6;

        Assert.assertEquals(expectedRows,actualRowsNm);
    }

}
