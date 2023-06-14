package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C25_Cookies extends TestBase {

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");

        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println(allCookies);

        int siraNo = 1;

        for (Cookie eachCookie : allCookies) {
            System.out.println(siraNo + "-----------" + eachCookie);
            siraNo++;
        }


        Assert.assertTrue(allCookies.size() > 5);

        System.out.print("");


        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";

        Cookie eklenecekCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(eklenecekCookie);

        String ensevdigimcookieValue = "";

        siraNo = 1;
        allCookies = driver.manage().getCookies();
        for (Cookie eachCookie : allCookies
        ) {
            System.out.println(siraNo +"---------------"+ eachCookie);
            siraNo++;
            if (eachCookie.getName().equals("en sevdigim cookie")) {
                ensevdigimcookieValue = eachCookie.getValue();
            }
        }

        String expectedValue = "cikolatali";
        String actualValue = ensevdigimcookieValue;

        Assert.assertEquals(expectedValue,actualValue);


     driver.manage().deleteCookieNamed("skin");

    }
}
