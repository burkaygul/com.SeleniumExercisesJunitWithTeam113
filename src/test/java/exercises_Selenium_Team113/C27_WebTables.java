package exercises_Selenium_Team113;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C27_WebTables extends TestBase {

    @Test
    public void test01(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> tumBasliklar = driver.findElements(By.xpath("//*[@role='columnheader']"));

        for (WebElement eachBaslik: tumBasliklar
             ) {
            System.out.println(eachBaslik.getText());
        }

        //  3. 3.sutunun basligini yazdirin
        System.out.println(tumBasliklar.get(3).getText()); // indexden dolayi email aldi

        //  4. Tablodaki tum datalari yazdirin


        List<WebElement> allData = driver.findElements(By.xpath("//*[@role='gridcell']"));

        int bosOlmayanCell=0;

        for (WebElement eachData: allData
             ) {
            if (!eachData.getText().isBlank())
            {
                System.out.println(eachData.getText());
                bosOlmayanCell++;
            }
        }

        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Tabloda bos olmayan hucre sayisi : " + bosOlmayanCell);



        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//*[@role='row']"));
        System.out.println("satir sayisi : " + satirSayisi.size());

        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Sutun sayisi : " + tumBasliklar.size());

        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> thirdColumn = driver.findElements(By.xpath("(//div[@role='row'])/div[3]"));
        for (WebElement eachThirdColumn: thirdColumn
             ) {
            if (!eachThirdColumn.getText().isBlank()){
                System.out.println(eachThirdColumn.getText());
            }
        }
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        for (int i = 1; i < satirSayisi.size()-1; i++) {
            WebElement kierra = driver.findElement(By.xpath(dinamikXpath(i,1)));
            if (kierra.getText().equalsIgnoreCase("Kierra")){
                WebElement salary = driver.findElement(By.xpath(dinamikXpath(i,5)));
                System.out.println(salary.getText());
            }
        }

        //  10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println(data(2, 1));
    }

    private String data(int satirSayisi, int sutunSayisi) {
        // (//div[@role='row'])[2]/div[5]
        String dinamikXpath = "(//div[@role='row'])["+satirSayisi+"]/div["+sutunSayisi+"]";
        WebElement dinamikElement = driver.findElement(By.xpath(dinamikXpath));
        return dinamikElement.getText();
    }

    public String dinamikXpath(int satirSayisi, int sutunSayisi){

        // (//div[@role='row'])[1]/div[2]
        String dinamikXpath = "(//div[@role='row'])["+satirSayisi+"]/div["+sutunSayisi+"]";
        return dinamikXpath;
    }
}


