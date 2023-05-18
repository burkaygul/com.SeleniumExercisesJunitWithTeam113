package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C17_KeyboardActionsHomework extends TestBase {

    @Test
    public void test01(){

        // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // 4- videoyu izlemek icin Play tusuna basin
        WebElement youTubeframe = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youTubeframe);
        WebElement playButton = driver.findElement(By.xpath("//*[@aria-label='Wiedergabe']"));
        actions.click(playButton).perform();


        // 5- videoyu calistirdiginizi test edin

        Assert.assertFalse(playButton.isDisplayed());
    }
}
