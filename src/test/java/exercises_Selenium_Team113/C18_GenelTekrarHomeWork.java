package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClass;

import java.util.List;

public class C18_GenelTekrarHomeWork extends TestBaseBeforeClass {

    @Test
    public void test01() {
        // 1- amazon gidin
        driver.get("https://www.amazon.com");
        // 2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownMenu);
        List<WebElement> allOptions = select.getOptions();

        for (WebElement eachOption : allOptions
        ) {
            System.out.println(eachOption.getText());
        }

        // 3- dropdown menude 40 eleman olduğunu doğrulayın

        int actualSize = allOptions.size();
        int expectedSize = 28;

        Assert.assertEquals(expectedSize, actualSize);

    }

    @Test
    public void test02() throws InterruptedException {

        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownMenu);
        //1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Elektronik");
        // 2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        searchBox.submit();
        // 3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        String actualText = resultText.getText();
        String expectedText = "iphone";
        Assert.assertTrue(actualText.contains(expectedText));

        // 4- ikinci ürüne relative locater kullanarak tıklayin

        WebElement firstProduct = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        WebElement secondProduct = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(firstProduct));

        secondProduct.click();

        // 5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

        WebElement productTitleElement = driver.findElement(By.xpath("//span[@id='productTitle']"));
        WebElement productPriceElement = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[4]"));

        String productTitle = productTitleElement.getText();
        String productPrice = productPriceElement.getText();

        System.out.println(productTitle + " : " + productPrice);


        WebElement productBag = driver.findElement(By.id("add-to-cart-button"));
        productBag.click();

        Thread.sleep(4000);
    }

    @Test
    public void test03() throws InterruptedException {


        String ilkWindowHandle = driver.getWindowHandle();

        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.get("https://www.amazon.com");
        String ikinciWindowHandle = driver.getWindowHandle();

        // 2-dropdown’dan bebek bölümüne secin
        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Baby");
        // 3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("bebek puset" + Keys.ENTER);
        // 4-sonuç yazsının puset içerdiğini test edin
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualText = resultText.getText();
        String expectedText = "bebek puset";
        Assert.assertTrue(actualText.contains(expectedText));

        // 5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement secondProduct = driver.findElement(By.xpath("(//*[@class='s-image'])[2]"));
        WebElement thirdProduct = driver.findElement(RelativeLocator.with(By.tagName("img")).below(secondProduct));

        thirdProduct.click();
        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

        WebElement productTitleElement = driver.findElement(By.xpath("//span[@id='productTitle']"));
        WebElement productPriceElement = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[4]"));

        String productTitle = productTitleElement.getText();
        String productPrice = productPriceElement.getText();

        System.out.println(productTitle + " : " + productPrice);


        WebElement productBag = driver.findElement(By.id("add-to-cart-button"));
        productBag.click();





    }

    @Test
    public void test04(){
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}

