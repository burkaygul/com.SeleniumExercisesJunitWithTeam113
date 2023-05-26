package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C19_FileDownload extends TestBase {

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='sample.png']")).click();

        String dosyaYolu = System.clearProperty("user.home")+"/Downloads/sample.png" ;
        System.out.println(dosyaYolu);

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
