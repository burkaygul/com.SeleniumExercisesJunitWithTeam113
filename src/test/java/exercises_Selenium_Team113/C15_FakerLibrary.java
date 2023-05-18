package exercises_Selenium_Team113;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.crypto.KeyAgreementSpi;

public class C15_FakerLibrary extends TestBase {

    @Test
    public void test01(){
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//*[@data-testid='cookie-policy-manage-dialog-accept-button'])[2]")).click();
        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        WebElement firstNameElement = driver.findElement(By.name("firstname"));

        String email = faker.internet().emailAddress();

        actions.click(firstNameElement)
                // 3. “firstName” giris kutusuna bir isim yazin
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                // 4. “surname” giris kutusuna bir soyisim yazin
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                // 5. “email” giris kutusuna bir email yazin
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                // 6. “email” onay kutusuna emaili tekrar yazin
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                // 7. Bir sifre girin
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                // 8. Tarih icin gun secin
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                // 9. Tarih icin ay secin
                .sendKeys("Aug")
                .sendKeys(Keys.TAB)
                // 10. Tarih icin yil secin
                .sendKeys("1996")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                // 11. Cinsiyeti secin
                // 12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();









    }
}
