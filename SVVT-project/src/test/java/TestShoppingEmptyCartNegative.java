import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

//

public class TestShoppingEmptyCartNegative {
    private static WebDriver driver;
    private static JavascriptExecutor js;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Haki\\Desktop\\svvt\\chromedriver-win64\\chromedriver.exe"); // specify the path to chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
    }

    @Test
    void test05() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement shoppingCart = driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div/a"));
        shoppingCart.click();

        WebElement cartText = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/form/div[2]/div[1]/div[2]/div"));
        String text = cartText.getText();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        if(text.equals("Vaša korpa je prazna!")) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
    }

    // Navigate to Buzz Sneakers website
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
