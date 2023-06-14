package exercises_Selenium_Team113;

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
    public void test01(){
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.END).perform();

        WebElement allBodyElement = driver.findElement(By.tagName("tbody"));
        System.out.println(allBodyElement.getText());
    }
}
