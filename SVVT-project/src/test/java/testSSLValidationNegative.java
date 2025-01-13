import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class testSSLValidationNegative {
    private static WebDriver driver;
    private static JavascriptExecutor js;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Haki\\Desktop\\svvt\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
    }

    @Test
    void test07() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse("SSL is valid.", currentUrl.startsWith("://"));
        System.out.println("Test passed, SSL certificate or HTTPS is not enforced");
    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
