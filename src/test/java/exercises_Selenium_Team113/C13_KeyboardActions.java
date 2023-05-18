package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C13_KeyboardActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        // 3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);



        actions.click(searchBox).keyDown(Keys.SHIFT).sendKeys("s")
                .keyUp(Keys.SHIFT).sendKeys("amsung").perform();
        Thread.sleep(2000);
        actions.click(searchBox).keyDown(Keys.SPACE)
                .keyUp(Keys.SPACE)
                .keyDown(Keys.SHIFT).sendKeys("a")
                .keyUp(Keys.SHIFT).sendKeys("71")
                .keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();



        // 4- aramanin gerceklestigini test edin

        WebElement resultElement = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String actualResultText = resultElement.getText();
        String expectedText = "Samsung A71";

        Assert.assertTrue(actualResultText.contains(expectedText));

    }

}
