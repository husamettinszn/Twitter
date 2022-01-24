

public class twitter {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://twitter.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());



        driver.close();
    }

}
