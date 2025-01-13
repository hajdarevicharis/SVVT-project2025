import org.junit.Assert;
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

//

public class TestFilters {
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
    public void testNavigationLinks() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba/dukserica/za-muskarce/za-odrasle/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement bojaButton = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div[3]/div[1]/div/form/div/div[4]"));
        bojaButton.click();

        WebElement crnaBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div[3]/div[1]/div/form/div/div[4]/ul/li[1]/label")));
        crnaBtn.click();

        String url = driver.getCurrentUrl();

        if (url.equals("https://www.buzzsneakers.ba/dukserica/za-muskarce/za-odrasle/")) {
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
