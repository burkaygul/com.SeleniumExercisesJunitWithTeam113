package exercises_Selenium_Team113;

import com.github.javafaker.File;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C29_ExcelRead  {
    @Test
    public void test01() throws IOException {

        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(20);
        Cell cell = row.getCell(2);

        System.out.println(cell.toString());

        String actualCellString = cell.toString();
        String expectedCellString = "Butan";


        Assert.assertEquals(expectedCellString,actualCellString);


    }
}
