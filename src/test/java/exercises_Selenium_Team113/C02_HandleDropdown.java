package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClass;

public class C02_HandleDropdown  extends TestBaseBeforeClass {

    @Test
    public void test01() {
        // https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement searchDropdownBox = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(searchDropdownBox);

        int expectedSize = 45;
        int actualSize = select.getOptions().size();

        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void test02(){
        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        WebElement searchDropdownBox = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(searchDropdownBox);
        select.selectByVisibleText("Bücher");
        //2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(resultText.getText());
        //4. Sonucun Java kelimesini icerdigini test edin

        String expectedWord = "Java";
        String actualText = resultText.getText();

        Assert.assertTrue(actualText.contains(expectedWord));
    }
    }

