package exercises_Selenium_Team113;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C28_ExcelRead {

    @Test
    public void test01() throws IOException {

        // "C:\Users\burka\IdeaProjects\com.SeleniumExercisesJUnitWithTeam113"

        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(2); // index from 0
        Cell cell = row.getCell(2); // index from 0

        System.out.println(cell);

        // 2.satir 4.cell’in kabil oldugunu test edin test edelim

        String actualData = sheet.getRow(1).getCell(3).toString();
        String expectedData = "Kabil";

        Assert.assertEquals(expectedData,actualData);
    }
}
