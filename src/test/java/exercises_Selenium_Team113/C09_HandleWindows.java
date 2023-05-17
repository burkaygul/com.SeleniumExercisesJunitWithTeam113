package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class C09_HandleWindows extends TestBase {

    @Test
    public void test01(){

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkWindowHandle = driver.getWindowHandle();
        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement headerTextElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(headerTextElement.isDisplayed());
        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitleText = driver.getTitle();
        String expectedTitleText = "The Internet";
        Assert.assertEquals(expectedTitleText,actualTitleText);
        // ● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.


        String ikinciHandleDegeri = "";
        Set<String> allHandle = driver.getWindowHandles();
        for (String eachwhDegerleri: allHandle
             ) {
            if (!allHandle.equals(ilkWindowHandle)){
                ikinciHandleDegeri = eachwhDegerleri;
        }
        }

        driver.switchTo().window(ikinciHandleDegeri);

        String actualNewWindowTitle = driver.getTitle();
        String expectedNewWindowTitle = "New Window";

        Assert.assertEquals(expectedNewWindowTitle,actualNewWindowTitle);

        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowTextElement = driver.findElement(By.tagName("h3"));
        String actualText = newWindowTextElement.getText();
        String expectedText = "New Window";
        Assert.assertEquals(expectedText,actualText);
        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkWindowHandle);
        String actualTitleText1 = driver.getTitle();
        String expectedTitleText1 = "The Internet";
        Assert.assertEquals(expectedTitleText1,actualTitleText1);
    }
}
