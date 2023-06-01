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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class TripAndWayAdress {

    protected WebDriver driver;
    Set<String> allWHDs;
    String tripandwayWHD = "";
    String facebookWHD = "";
    String twitterWHD = "";
    String linkedinWHD = "";
    String pinterestWHD = "";
    String instagramWHD = "";

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

        // 4- Sayfa Page Down yapilarak 'Terms and Conditions' yazisinin gorunur oldugu test edilir
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
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
        driver.quit();
    }

    @Test
    public void test01() {
        WebElement adressElement = driver.findElement(By.xpath("(//div[@class='footer-item mt_30'])[4]"));
        Assert.assertTrue(adressElement.isDisplayed());
    }

    @Test
    public void test02() throws InterruptedException {

        WebElement facebookButtonElement = driver.findElement(By.xpath("(//a[@target='_blank'])[38]"));
        facebookButtonElement.click();

        Thread.sleep(2000);

        tripandwayWHD = driver.getWindowHandle();

        allWHDs = driver.getWindowHandles();

        for (String eachWHD : allWHDs
        ) {
            if (!allWHDs.equals(tripandwayWHD)) {
                facebookWHD = eachWHD;
            }
        }

        driver.switchTo().window(facebookWHD);
        Thread.sleep(2000);

        String facebookExpectedIcerik = "Facebook";
        String facebookActualIcerik = driver.getTitle();

        Assert.assertTrue(facebookActualIcerik.contains(facebookExpectedIcerik));
        Thread.sleep(2000);

        driver.close();
    }

    @Test
    public void test03() throws InterruptedException {


        WebElement twitterButtonElement = driver.findElement(By.xpath("(//a[@target='_blank'])[39]"));
        twitterButtonElement.click();
        Thread.sleep(2000);

        allWHDs = driver.getWindowHandles();

        for (String eachWHD : allWHDs
        ) {
            if (!allWHDs.equals(tripandwayWHD) && !allWHDs.equals(facebookWHD)) {
                twitterWHD = eachWHD;
            }
        }

        driver.switchTo().window(twitterWHD);

        String twitterExpectedIcerik = "Twitter";
        String twitterActualIcerik = driver.getTitle();

        Assert.assertTrue(twitterActualIcerik.contains(twitterExpectedIcerik));

        driver.switchTo().window(tripandwayWHD);

    }

    @Test
    public void test04() throws InterruptedException {

        WebElement linkedinButtonElement = driver.findElement(By.xpath("(//a[@target='_blank'])[40]"));
        linkedinButtonElement.click();
        Thread.sleep(2000);

        allWHDs = driver.getWindowHandles();

        for (String eachWHD : allWHDs) {
            if (!allWHDs.equals(tripandwayWHD) && !allWHDs.equals(facebookWHD) && !allWHDs.equals(twitterWHD)) {
                linkedinWHD = eachWHD;
            }
        }

        driver.switchTo().window(linkedinWHD);

        Thread.sleep(2000);

        String linkedinExpectedIcerik = "LinkedIn";
        String linkedinActualIcerik = driver.getTitle();

        Assert.assertTrue(linkedinActualIcerik.contains(linkedinExpectedIcerik));
    }

    @Test
    public void test05() throws InterruptedException {

        WebElement pinterestButtonElement = driver.findElement(By.xpath("(//a[@target='_blank'])[41]"));
        pinterestButtonElement.click();
        Thread.sleep(2000);

        allWHDs = driver.getWindowHandles();

        for (String eachWHD : allWHDs) {
            if (!allWHDs.equals(tripandwayWHD) && !allWHDs.equals(facebookWHD) && !allWHDs.equals(twitterWHD) && !allWHDs.equals(linkedinWHD)) {
                pinterestWHD = eachWHD;
            }
        }

        driver.switchTo().window(pinterestWHD);

        Thread.sleep(2000);

        String pinterestExpectedIcerik = "Pinterest";
        String pinterestActualIcerik = driver.getTitle();

        Assert.assertTrue(pinterestActualIcerik.contains(pinterestExpectedIcerik));
    }

    @Test
    public void test06() throws InterruptedException {

        WebElement instagramButtonElement = driver.findElement(By.xpath("(//a[@target='_blank'])[42]"));
        instagramButtonElement.click();
        Thread.sleep(2000);

        allWHDs = driver.getWindowHandles();

        for (String eachWHD : allWHDs) {
            if (!allWHDs.equals(tripandwayWHD) && !allWHDs.equals(facebookWHD) && !allWHDs.equals(twitterWHD) && !allWHDs.equals(linkedinWHD) && !allWHDs.equals(pinterestWHD)) {
                instagramWHD = eachWHD;
            }
        }

        driver.switchTo().window(instagramWHD);

        Thread.sleep(2000);

        String instagramExpectedIcerik = "Instagram";
        String instagramActualIcerik = driver.getTitle();

        Assert.assertTrue(instagramActualIcerik.contains(instagramExpectedIcerik));

    }
}
