package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C23_IframeHomework extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/IFrame/index.html");

        WebElement frame = driver.findElement(By.xpath("//*[@id='frame']"));

        driver.switchTo().frame(frame);

        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        Thread.sleep(2000);

        WebElement popupMessage = driver.findElement(By.xpath("//*[@class='modal-body']"));
        System.out.println(popupMessage.getText());


        driver.findElement(By.xpath("//*[text()='Close']")).click();


        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();


        String expectedUrl= "https://www.webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

    }
}
