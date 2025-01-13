import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

//

public class TestArrowButton {
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
    // testing that text when opening empty cart is correct
    @Test
    void test05() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");
        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[6]/div[1]/div[2]/div/div/div[5]/div[1]/a")));

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath("/html/body/div[4]/div[6]/div[1]/div[2]/div/div/div[5]/div[1]/a"));
        element.click();

        String url = driver.getCurrentUrl();
        if(url.equals("https://www.buzzsneakers.ba/magazin/buzz-crew/9413-cortez-old-but-new")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
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
