package exercises_Selenium_Team113;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C30_ExcelOtomasyon {

    @Test
    public void test01() throws IOException {

        // Excel'de ingilizce ismi Benin olan bir ulke
        // olup olmadigini test edin

        String dosyaYolu = System.getProperty("user.dir") +"/src/test/java/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        // System.out.println(Files.exists(Paths.get(dosyaYolu)));

        Workbook workbook = WorkbookFactory.create(fis);


        int sonSatirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();

        boolean beninVarMi=false;

        for (int i = 1; i <= sonSatirSayisi ; i++) {

            String actualIsim = workbook
                    .getSheet("Sayfa1")
                    .getRow(i)
                    .getCell(0)
                    .toString();

            if (actualIsim.equalsIgnoreCase("Benin")){
                beninVarMi=true;
                break;
            }
        }

        Assert.assertTrue(beninVarMi);

    }

    }

