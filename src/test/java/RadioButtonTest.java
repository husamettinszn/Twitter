import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RadioButtonTest {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void radioTest() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        Thread.sleep(1000);
        WebElement maleRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));

        if (!maleRadioButton.isSelected()){
            maleRadioButton.click();
        }
        WebElement monthDropdown = driver.findElement(By.id("month"));

        Select month = new Select(monthDropdown);
        month.selectByIndex(1);

        Thread.sleep(1000);


    }
    @After
    public void tearDown(){
        driver.close();
    }
}
