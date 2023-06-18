package exercises_Selenium_Team113;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C34_getScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {

      // Yeni bir class olusturun : amazonNutellaSearch

      // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

      // 2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin

        ReusableMethods.tumSayfaFotografCek(driver);

        //       TakesScreenshot tss = (TakesScreenshot) driver;
        //    File tumsayfaShot1 = new File("target/Screenshot/anasayfa.jpeg");
        //    File geciciResim1 = tss.getScreenshotAs(OutputType.FILE);
        //    FileUtils.copyFile(geciciResim1,tumsayfaShot1);



      // 3- Nutella icin arama yapin

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
         searchBox.sendKeys("Nutella" + Keys.ENTER);


        // 4- sonucun Nutella icerdigini test edin  ve ilk urunun goruntusunu alin

         WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
         String actualYazi = sonucYazisi.getText();
         String expectedIcerik = "Nutella";

        Assert.assertTrue(actualYazi.contains(expectedIcerik));


        WebElement ilkUrunElement = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[4]"));
         File ilkurun = new File("target/Screenshot/ilkuurun.jpeg");
         File geciciResim = ilkUrunElement.getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(geciciResim,ilkurun);

         ReusableMethods.webelementFotografCek(driver,ilkUrunElement);


    }
}
