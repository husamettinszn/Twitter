import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Youtube {

   static WebDriver driver;

   @BeforeClass
    public static void setUp(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://www.youtube.com");
   }

   @Test
   public void titelTest(){
       String titel = "YouTube";
       String actuelTitle = driver.getTitle();

       Assert.assertEquals(titel, actuelTitle);

   }
   @Test
   public void logo(){
       WebElement logo  = driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-logo']"));
       Assert.assertTrue(logo.isDisplayed());
   }
   @Test
   public void suchFeld(){
       WebElement suchFeld = driver.findElement(By.xpath("//ytd-searchbox[@class='style-scope ytd-masthead']"));

       Assert.assertTrue(suchFeld.isEnabled());
   }

   @Test
   public void falschesTitel(){
       String titel = "youtube";
       String actuelTitel = driver.getTitle();

       Assert.assertFalse(actuelTitel.equals(titel));
   }

   @AfterClass
    public static void tesrDown(){
       driver.close();
   }


}
