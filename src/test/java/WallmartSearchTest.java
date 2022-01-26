import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WallmartSearchTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.walmart.com/");

        if (!driver.getCurrentUrl().equals("https://www.walmart.com/")) {
            WebElement robotText = driver.findElement(By.xpath("//h1[@class='heading heading-d sign-in-widget']"));
            if (robotText.isDisplayed()) {
                WebElement robot = driver.findElement(By.xpath("//span[@class='u-sentenceCase u-sentenceCase--no-transform']"));
                robot.click();
            }
        }
    }
    @Test
    public void titleSavearama(){
       String gesuchtesWort = "Saven";
       String titel = driver.getTitle();
        System.out.println(titel);

        if (titel.equals(gesuchtesWort)){
            System.out.println("Das Titel inhalt das gesuchte Wort " + gesuchtesWort + ".");
        }else{
            System.out.println("Das Titel inhalt kein gesuchtes Wort " + gesuchtesWort + ".");
        }

    }
    @Test
    public void titleGleich(){
        String title = "Walmart.com | Save Money. Live Better";

        if (driver.getTitle().equals(title)){
            System.out.println("Das Titeltest hat bestanden");
        }else{
            System.out.println("Das Titeltest hat fehlgeschlagen.");
        }
    }
    @Test
    public void urlTest() {
        String gängigesUrl = "walmart.com";

        if (driver.getCurrentUrl().equals(gängigesUrl)) {
            System.out.println("Urltest hat bestanden");
        }else{
            System.out.println("Urltest hat fehlgeschlagen");
        }
    }
    @Test
    public void nutellaTest(){
        WebElement suchFeld = driver.findElement(By.xpath("//input[@type='search']"));
        String gesuchtesWort = "Nutella";
        suchFeld.sendKeys(gesuchtesWort);
        suchFeld.submit();

        WebElement anzahl = driver.findElement(By.xpath("//span[@class='f6 f5-m fw3 ml1 gray normal self-center']"));
        System.out.println(anzahl.getText());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
