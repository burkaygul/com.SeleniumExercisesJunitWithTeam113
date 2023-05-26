package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C20_FileUpload  extends TestBase {

   @Test
    public void test01() throws InterruptedException {
       driver.get("https://the-internet.herokuapp.com/upload");
       WebElement uploadButton = driver.findElement(By.id("file-upload"));

       String herkesinPcFarkliKisim = System.getProperty("user.home");
       System.out.println(herkesinPcFarkliKisim);
       String masaustuDosya = "/Desktop/KURALLAR.docx";

       String dateiPfad = herkesinPcFarkliKisim+masaustuDosya;

       uploadButton.sendKeys(dateiPfad);

       Thread.sleep(2000);

       driver.findElement(By.id("file-submit")).click();

       WebElement fileUploadedElement = driver.findElement(By.tagName("h3"));

       Assert.assertTrue(fileUploadedElement.isDisplayed());
   }
}
