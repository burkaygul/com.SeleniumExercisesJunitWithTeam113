package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_HandleiFrame extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement aboveTextIsDisplayedElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(aboveTextIsDisplayedElement.isDisplayed());
        System.out.println(aboveTextIsDisplayedElement.getText());
        // - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElement);
        WebElement textBoxElement = driver.findElement(By.xpath("//*[@id='tinymce']"));
        Thread.sleep(2000);
        textBoxElement.clear();
        Thread.sleep(2000);
        textBoxElement.sendKeys("Merhaba Dunya!");
        Thread.sleep(2000);

        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin
        // ve konsolda yazdirin.

        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLink = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumLink.isDisplayed());
        System.out.println(elementalSeleniumLink.getText());
    }
}