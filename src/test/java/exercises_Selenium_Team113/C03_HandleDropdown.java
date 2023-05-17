package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C03_HandleDropdown extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        Thread.sleep(2000);
        //4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        Thread.sleep(2000);
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currenyElement = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currenyElement);
        select.selectByVisibleText("Eurozone (euro)");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("50");
        Thread.sleep(2000);
        //10. “US Dollars” in secilmedigini test edin
        WebElement usdollarsElement = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usdollarsElement.isSelected());
        Thread.sleep(2000);
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        Thread.sleep(2000);
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("purchase_cash")).click();
        Thread.sleep(2000);
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
        WebElement textElement = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(textElement.isDisplayed());
    }
}
