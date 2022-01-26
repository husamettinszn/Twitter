import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertion {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void positiveTest(){
        String erwartetestitel = "TECHPROED";
        String actuelTitel = driver.getTitle();

        Assert.assertTrue(actuelTitel.contains(erwartetestitel));

    }
    @Test
    public void negativeTest(){
        String gesuchtesWort = "Hüsamettin";
        String actuelTitel = driver.getTitle();

        Assert.assertFalse(actuelTitel.contains(gesuchtesWort));
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
