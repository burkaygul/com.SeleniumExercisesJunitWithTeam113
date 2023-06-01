package Proje;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TripAndWayNewsletter {

    protected WebDriver driver;
    WebElement emailBoxElement;
    WebElement submitElement;

    @Before
    public void setup() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- Go to 'https://qa.tripandway.com'
        driver.get("https://qa.tripandway.com/");
        // 3- Cookies kabul edilir
        driver.findElement(By.xpath("//*[@type='button']")).click();

        // 4- Page Down yapilarak sayfanin Newsletter kismina ulasilir
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);

    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void test01(){

        WebElement newsletterElement = driver.findElement(By.xpath("//div[@class='newsletter-bg']"));
        Assert.assertTrue(newsletterElement.isDisplayed());

        emailBoxElement = driver.findElement(By.xpath("//input[@name='subs_email']"));
        Assert.assertTrue(emailBoxElement.isEnabled());

       submitElement = driver.findElement(By.xpath("//input[@type='submit']"));
       Assert.assertTrue(submitElement.isEnabled());
    }

    @Test
    public void test02(){

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        //1- Email kutusunun icine gecerli bir email adresi yazilir
        emailBoxElement = driver.findElement(By.xpath("//input[@name='subs_email']"));
        emailBoxElement.sendKeys(faker.internet().emailAddress());

        // 2-'SUBMIT' butonuna tiklanir
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // 3- 'To activate your subscription please check your email and follow instruction there.' yazisinin gorunur olmasi dogrunlanir
        WebElement basariliKayit = driver.findElement(By.xpath("//div[@id='toast-container']"));

        String actualBasariliKayitIcerik = basariliKayit.getText();
        String expectedKayitIcerik = "To activate your subscription please check your email and follow instruction there.";

        Assert.assertEquals(expectedKayitIcerik,actualBasariliKayitIcerik);
    }

}
