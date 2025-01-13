import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSearchButtonInput {
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
    void test() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().refresh();

        Thread.sleep(5000);

        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[3]/nav/div[3]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            Thread.sleep(1000);
            button.click();

            WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div/div/div/input"));
            input.sendKeys("nike" + Keys.ENTER);

            String url = driver.getCurrentUrl();
            if (url.equals("https://www.buzzsneakers.ba/proizvodi?search=nike")) {
                System.out.println("You searched nike, test passed!");
            } else {
                System.out.println("Test failed.");
            }


        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}