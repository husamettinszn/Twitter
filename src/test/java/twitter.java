import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class twitter {
// Hallo
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://twitter.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        WebElement signIn = driver.findElement(By.xpath("(//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'])[7]"));

        signIn.click();

        WebElement nameTextBox = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-18u37iz r-16y2uox r-1wbh5a2 r-1wzrnnt r-1udh08x r-xd6kpl r-1pn2ns4 r-ttdzmv'])[1]"));
        WebElement phoneTextBox = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-18u37iz r-16y2uox r-1wbh5a2 r-1wzrnnt r-1udh08x r-xd6kpl r-1pn2ns4 r-ttdzmv'])[2]"));
        WebElement withEail= driver.findElement(By.xpath("//div[@class='css-18t94o4 css-901oao r-k200y r-1cvl2hr r-37j5jr r-a023e6 r-16dba41 r-rjixqe r-1wzrnnt r-bcqeeo r-qvutc0']"));

        nameTextBox.sendKeys("Ahmet");
        withEail.click();

        //driver.close();


    }

}
