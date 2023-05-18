package exercises_Selenium_Team113;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C16_ActionsClassHomeWork1 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement overMeFirst = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(overMeFirst).perform();
        Thread.sleep(2000);
        // 3- Link 1" e tiklayin
        WebElement overMeFirstLink = driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        actions.click(overMeFirstLink).perform();
        // overMeFirstLink.click(); -- BU SEKILDE DE OLUYOR
        Thread.sleep(2000);
        // 4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        // 6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        Thread.sleep(2000);
        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());
        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();

        // objeyi drop here uzerine birakiniz
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(draggable,droppable).perform();


    }
}
