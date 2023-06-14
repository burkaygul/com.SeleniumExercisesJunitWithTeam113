package exercises_Selenium_Team113;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C22_ActionsClassHomework  extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions");

        Actions actions = new Actions(driver);

        WebElement firstHover = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.clickAndHold(firstHover).perform();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@class='list-alert']")).click();

        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        WebElement clickandHold = driver.findElement(By.xpath("//*[@id='click-box']"));

        actions.clickAndHold(clickandHold).perform();

        System.out.println(clickandHold.getText());

        WebElement doubleClick = driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doubleClick).perform();

    }
}
