package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C10_ActionsClass_Context_Click extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlanElement = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlanElement).perform();
        Thread.sleep(2000);
        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";
        Assert.assertEquals(expectedAlertText,actualAlertText);
        // 5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        // 6- Elemental Selenium linkine tiklayalim
        WebElement elementalSeleniumElement = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        String ilkWindowHandle = driver.getWindowHandle();
        elementalSeleniumElement.click();
        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String ikinciWindowHandle = "";
        Set<String> allWHD= driver.getWindowHandles();
        for (String eachWHD: allWHD
             ) {
            if (!allWHD.equals(ilkWindowHandle)){
                ikinciWindowHandle=eachWHD;
            }
        }
        driver.switchTo().window(ikinciWindowHandle);

        WebElement elementalSeleniumTitleElement = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(elementalSeleniumTitleElement.isDisplayed());
    }
}
