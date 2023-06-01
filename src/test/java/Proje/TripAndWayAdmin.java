package Proje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.time.Duration;

public class TripAndWayAdmin {
    protected WebDriver driver;
    WebElement emailadressBox;
    WebElement passwordBox;
    WebElement loginButton;

    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://qa.tripandway.com/admin/login");
        Thread.sleep(2000);

    }

    @After
    public void teardown(){
        // driver.quit();
    }

    @Test
    public void test01(){

        emailadressBox = driver.findElement(By.xpath("//input[@id='email']"));
        passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        Assert.assertTrue(emailadressBox.isEnabled());
        Assert.assertTrue(passwordBox.isEnabled());
    }

    @Test
    public void test02(){

        emailadressBox = driver.findElement(By.xpath("//input[@id='email']"));
        Actions actions = new Actions(driver);
        actions.click(emailadressBox)
                .sendKeys("admin01@tripandway.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123123123")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Admin Panel";

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void test03(){

        emailadressBox = driver.findElement(By.xpath("//input[@id='email']"));
        Actions actions = new Actions(driver);
        actions.click(emailadressBox)
                .sendKeys("admin01@tripandway.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123123123")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
        WebElement destinationsTextElement = driver.findElement(By.xpath("(//*[text()='Destinations'])[2]"));

        Assert.assertTrue(destinationsTextElement.isDisplayed());
    }
}
