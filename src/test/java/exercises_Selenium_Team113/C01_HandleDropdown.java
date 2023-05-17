package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01_HandleDropdown extends TestBase {

    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDownList = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDownList);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption: allOptions
             ) {
            System.out.println(eachOption.getText());
        }
        //5. Dropdown’un boyutunun 4 olduğunu test edin
        int actualSize = select.getOptions().size();
        int expectedSize = 4;

        Assert.assertEquals(expectedSize,actualSize);
    }
}
