package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C12_ActionsClass_MouseAction extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement accountAndListElement = driver.findElement(By.xpath("//*[text()='Konto und Listen']"));
        // WebElement accountAndListElement = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountAndListElement).perform();
        Thread.sleep(2000);
        // 3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//*[text()='Neue Liste anlegen ']")).click();
        // 4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListsElement = driver.findElement(By.xpath("//div[@role='heading']"));
        String actualText = yourListsElement.getText();
        String expectedText = "Meine Listen";

        Assert.assertEquals(expectedText,actualText);
    }
}
