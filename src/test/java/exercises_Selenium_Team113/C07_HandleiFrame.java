package exercises_Selenium_Team113;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C07_HandleiFrame extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        Thread.sleep(3000);
        WebElement iFrameCookie = driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(iFrameCookie);
        WebElement alleAkzeptierenCookieElement = driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[4]"));
        System.out.println(alleAkzeptierenCookieElement.getText());
        alleAkzeptierenCookieElement.click();
        // 2) sayfadaki iframe sayısını bulunuz.
        driver.switchTo().defaultContent();
        List<WebElement> iFrameNumberFindElement = driver.findElements(By.tagName("iframe"));
        System.out.println(iFrameNumberFindElement.size());
        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youTubeiFrame = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youTubeiFrame);
        WebElement buttonWebElement = driver.findElement(By.xpath("//div/button[@aria-label='Wiedergabe']"));
        buttonWebElement.click();
        Thread.sleep(2000);
        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        // 5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement jMeteriFrameElement = driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(jMeteriFrameElement);
        WebElement jMeterLinkElement = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
        jMeterLinkElement.click();

    }
}