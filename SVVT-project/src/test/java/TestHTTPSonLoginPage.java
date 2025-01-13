import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//

public class TestHTTPSonLoginPage {
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
    public void testHTTPs() {
            driver.get("https://www.buzzsneakers.ba/login");
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login page is not loaded over HTTPS.", currentUrl.startsWith("https://"));
            System.out.println("Test passed!");
    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
