package exercises_Selenium_Team113;

import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C32_WebTablesTekrar {

    @Test
    public void test01() throws IOException {
        // satir index 13
        // sutun index 2

        // Bayreyn oldugunu test edelim

        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String actualData = workbook
                                        .getSheet("Sayfa1")
                                        .getRow(13)
                                        .getCell(2).toString();

        String expectedData = "Bahreyn";

        Assert.assertEquals(expectedData,actualData);


        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();


        Map<String,String> map = new TreeMap<>();

        Sheet sheet = workbook.getSheet("Sayfa1");

        for (int i = 1; i < sonSatirIndex ; i++) {

            String key = sheet.getRow(i).getCell(0).toString();
            String value =  sheet.getRow(i).getCell(1).toString()+ ", " +
                            sheet.getRow(i).getCell(2).toString()+ ", " +
                            sheet.getRow(i).getCell(3).toString();

            map.put(key,value);
        }

        System.out.println(map);


    }
}
