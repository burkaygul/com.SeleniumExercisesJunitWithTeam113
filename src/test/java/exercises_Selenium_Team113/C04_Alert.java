package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClass;

public class C04_Alert extends TestBaseBeforeClass {

    @Test
    public void test01() throws InterruptedException {
        //1. Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 1.alert'e tiklayin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);

        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
               String actualText =  driver.switchTo().alert().getText();
               String expectedText = "I am a JS Alert";
        Assert.assertEquals(expectedText,actualText);
        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();


    }
    @Test
    public void test02() throws InterruptedException {
        //2.Test
        //- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        WebElement resultElement = driver.findElement(By.id("result"));

        String actualResult = resultElement.getText();
        String expectedResult = "You clicked: Cancel";

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void test03() throws InterruptedException {
        //3.Test

        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement resultTextElement = driver.findElement(By.id("result"));
        String actualText = resultTextElement.getText();
        String expectedText = "Abdullah";

        Assert.assertTrue(actualText.contains(expectedText));
    }
}
