package exercises_Selenium_Team113;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C33_WriteExcel {

    @Test
    public void test01() throws IOException {

        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000 ");
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");


        FileOutputStream fos = new FileOutputStream(dosyaYolu);

        workbook.write(fos);

        fis.close();
        fos.close();
        workbook.close();
    }
}
