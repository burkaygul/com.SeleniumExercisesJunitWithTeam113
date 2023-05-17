package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C08_HandleWindows extends TestBase {

    @Test
    public void test01(){

        // ● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        // ● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();
        // ● Sayfa title’nin “Amazon” icerdigini test edin
        String actualAmazonTitle = driver.getTitle();
        String expectedAmazonTitle = "Amazon";
        Assert.assertTrue(actualAmazonTitle.contains(expectedAmazonTitle));
        // ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com/");
        // ● Sayfa title’nin “wisequarter” icerdigini test edin
        String actualWiseQuarterTitle = driver.getTitle();
        String expectedWiseQuarterTitle = "Bootcamp";
        Assert.assertTrue(actualWiseQuarterTitle.contains(expectedWiseQuarterTitle));
        // ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        // ● Sayfa title’nin “Walmart” icerdigini test edin
        String actualWalmartTitle = driver.getTitle();
        String expectedWalmartTitle = "Walmart";
        Assert.assertTrue(actualWalmartTitle.contains(expectedWalmartTitle));
        // ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        String actualAmazonTitle1 = driver.getTitle();
        String expectedAmazonTitle1 = "Amazon";
        Assert.assertTrue(actualAmazonTitle1.contains(expectedAmazonTitle1));

    }
}
