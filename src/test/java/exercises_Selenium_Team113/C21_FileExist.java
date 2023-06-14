package exercises_Selenium_Team113;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C21_FileExist {

    @Test
    public void test01(){

        String dosyaYolu = System.getProperty("user.home") +"\\Desktop\\Listen_-_Gemischte_Verben.pdf";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
