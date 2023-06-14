package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C26_WebTables extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.END).perform();
        Thread.sleep(3000);

        WebElement allBodyElement = driver.findElement(By.tagName("tbody"));
        System.out.println(allBodyElement.getText());

        List<WebElement> satirSayisi = driver.findElements(By.tagName("tr"));
        int expectedRowsNr = 9;
        int actualRowsNr = satirSayisi.size();

        Assert.assertEquals(expectedRowsNr,actualRowsNr);

        System.out.println("==========================");

        for (WebElement eachRow: satirSayisi
             ) {
            System.out.println(eachRow.getText());
            System.out.println("==========================");
        }

        List<WebElement> firstColumnData = driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedColumnNumber = 13;
        int actualColumnNumber = firstColumnData.size();

        Assert.assertEquals(expectedColumnNumber,actualColumnNumber);
    }
}
