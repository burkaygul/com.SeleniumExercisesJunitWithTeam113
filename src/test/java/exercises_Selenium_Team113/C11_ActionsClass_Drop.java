package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C11_ActionsClass_Drop extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragMeElement = driver.findElement(By.id("draggable"));
        WebElement dropHereElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Thread.sleep(2000);
        actions.dragAndDrop(dragMeElement,dropHereElement).perform();
        
        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement dropHereTextElement = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualInhalt = dropHereTextElement.getText();
        String expectedInhalt = "Dropped!";

        Assert.assertEquals(expectedInhalt,actualInhalt);
    }
}
