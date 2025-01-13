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

public class TestFooterAboutUs {
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
    void test04() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cookie = driver.findElement(By.xpath("/html/body/div[14]/div/div/div[1]/div[2]/div[3]/button[1]"));
        cookie.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/footer/div/div/div[1]/nav/nav/div[4]/ul/li[4]/a"))); // Update XPath to match the button

        Thread.sleep(5000);
        button.click();


        String url = driver.getCurrentUrl();
        if (url.equals("https://www.buzzsneakers.ba/radnje")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}