package exercises_Selenium_Team113;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C24_WindowHandleHomework extends TestBase {

    @Test
    public void test01(){

        driver.get("http://www.webdriveruniversity.com/");

        WebElement loginPortal = driver.findElement(By.xpath("(//div[@class='caption'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginPortal);

        String ilkWHD = driver.getWindowHandle();

        loginPortal.click();

        String ikinciWHD ="";

        Set<String> allWHD = driver.getWindowHandles();

        for (String eachString: allWHD
             ) {
            if (!eachString.equals(ilkWHD)){
                ikinciWHD = eachString;
            }
        }


        driver.switchTo().window(ikinciWHD);

        System.out.println(driver.getTitle());

        Faker faker = new Faker();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(faker.name().username());

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(faker.internet().password());

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.switchTo().alert().accept();

        driver.switchTo().window(ilkWHD);

        System.out.println(driver.getTitle());


    }
}
