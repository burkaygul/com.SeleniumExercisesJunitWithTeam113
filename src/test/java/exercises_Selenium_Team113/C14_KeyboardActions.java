package exercises_Selenium_Team113;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.security.Key;
import java.util.List;

public class C14_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//*[@data-testid='cookie-policy-manage-dialog-accept-button'])[2]")).click();
        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement firstNameElement = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);

        actions.click(firstNameElement).keyDown(Keys.SHIFT).sendKeys("b")
                .keyUp(Keys.SHIFT).sendKeys("urkay")
                .sendKeys(Keys.TAB)
                .keyDown(Keys.SHIFT).sendKeys("g")
                .keyUp(Keys.SHIFT).sendKeys("uel")
                .sendKeys(Keys.TAB)
                .sendKeys("burkaygul96@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("burkaygul96@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Burkay1907Fb.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("24")
                .sendKeys(Keys.TAB)
                .sendKeys("Aug")
                .sendKeys(Keys.TAB)
                .sendKeys("1996")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();



//
        // 4- Kaydol tusuna basalim
    }
}

//   WebElement birthdayElement = driver.findElement(By.name("birthday_day"));
//   Select select = new Select(birthdayElement);
//   select.selectByValue("24");

//   WebElement birtdayMonth =driver.findElement(By.name("birthday_month"));
//   actions.click(birtdayMonth)
//           .sendKeys("Aug").perform();