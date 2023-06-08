package Proje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class asfasf {

    protected WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://qa.tripandway.com");
        Thread.sleep(2000);

    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("(//*[@id='menu']//li)[4]")).click();

        WebElement istanbul = driver.findElement(By.xpath("//div[@class='photo-title'])[3]"));

        String actualIcerik = istanbul.getText();
        istanbul.click();

        System.out.println(actualIcerik);
    }
}
