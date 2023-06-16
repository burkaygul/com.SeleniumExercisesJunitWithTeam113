package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C26_WebTables extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // 1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        // 2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        // 3.Web table tum body’sini yazdirin
        WebElement allTableBody = driver.findElement(By.tagName("tbody"));
        System.out.println(allTableBody.getText());
        // 4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
         int expectedRowsNumber = 9;
         int actualRowsNumber = allRows.size();

        Assert.assertEquals(expectedRowsNumber,actualRowsNumber);

        // 5.Tum satirlari yazdirin

        int satirSayisi = 1;
        for (WebElement eachRow: allRows
             ) {
            System.out.println(satirSayisi + eachRow.getText());
            System.out.println("==================");
            satirSayisi++;
        }
        // 6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> allColumn = driver.findElements(By.xpath("//tr[1]//td"));

        int expectedColumnsNumber = 13;
        int actualColumnsNumber = allColumn.size();
        Assert.assertEquals(expectedColumnsNumber,actualColumnsNumber);

        // 7. 5.sutunu yazdirin
        List<WebElement> fifthColumn = driver.findElements(By.xpath("//tr//td[5]"));

        for (WebElement eachFifthColumn: fifthColumn
             ) {
            System.out.println(eachFifthColumn.getText());
        }

        // 8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(hucredekiBilgiyiDonduren(3, 1));
    }

    private String hucredekiBilgiyiDonduren(int satirSayisi, int sutunSayisi) {

        //tr[7]//td[3]
        String dinamik = "//tr["+satirSayisi+"]//td["+sutunSayisi+"]";
        WebElement dinamikHucre = driver.findElement(By.xpath(dinamik));
        return dinamikHucre.getText();
    }
}
