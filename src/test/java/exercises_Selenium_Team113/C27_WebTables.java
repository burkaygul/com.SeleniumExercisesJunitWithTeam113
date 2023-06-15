package exercises_Selenium_Team113;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C27_WebTables extends TestBase {

    @Test
    public void test01(){
        driver.get("https://demoqa.com/webtables");

        List<WebElement> columnHeaders = driver.findElements(By.xpath("//*[@role='columnheader']"));

        for (WebElement eachColumnHeader: columnHeaders
             ) {
            System.out.println(eachColumnHeader.getText());
        }

        System.out.println("3. sutun basligi : " +columnHeaders.get(3).getText());
    }


}
