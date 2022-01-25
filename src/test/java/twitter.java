import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class twitter {
// Hallo
    //gleichfalls
    // danke
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://twitter.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        WebElement signIn = driver.findElement(By.xpath("(//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'])[7]"));

        signIn.click();

        Thread.sleep(1000);

        WebElement name = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
        name.sendKeys("Ahmet");

        //WebElement email = driver.findElement(By.xpath("//div[@class='css-18t94o4 css-901oao r-k200y r-1cvl2hr r-37j5jr r-a023e6 r-16dba41 r-rjixqe r-1wzrnnt r-bcqeeo r-qvutc0']"));
        WebElement month = driver.findElement(By.id("SELECTOR_1"));
        List <WebElement> dropDown = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-1ets6dv r-z2wwpe r-rs99b7 r-16xksha r-1b7u577']"));
        //email.click();
        WebElement day = driver.findElement(By.id("SELECTOR_2"));

        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("25");

        for (WebElement w:dropDown
             ) {
            System.out.printf(w.getText());
        }
        Thread.sleep(1000);
        Select select = new Select(month);
        Thread.sleep(1000);
        select.selectByVisibleText("May");

        System.out.println();
        WebElement year = driver.findElement(By.id("SELECTOR_3"));
        List <WebElement> years = driver.findElements(By.id("SELECTOR_3"));


        for (WebElement w:years
             ) {
            System.out.println(w.getText());
        }

        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("2000");


        Thread.sleep(1000);
        driver.close();


    }

}
