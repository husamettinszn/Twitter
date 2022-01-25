import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Shopping {
    //1. “https://www.saucedemo.com” Adresine gidin
    //2. Username kutusuna “standard_user” yazdirin
    //3. Password kutusuna “secret_sauce” yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement userNameTextBox = driver.findElement(By.id("user-name"));

        String user = "standard_user";
        userNameTextBox.sendKeys(user);
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        String password = "secret_sauce";
        passwordTextBox.sendKeys(password);
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ersteProdukt= driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ersteProduktSpeichert= ersteProdukt.getText();
        ersteProdukt.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_container")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement korbProdukt = driver.findElement(By.className("inventory_item_name"));

        System.out.println(ersteProduktSpeichert);
        System.out.println(korbProdukt.getText());

        if (ersteProduktSpeichert.equals(korbProdukt.getText())){
            System.out.println("Das Produkt hat erfolgreich zum Warenkorb hingefügt!");
        }
        else{
            System.out.println("Das hat nicht geklappt!");
        }

        //9. Sayfayi kapatin


        Thread.sleep(1000);
        driver.close();


    }
}
