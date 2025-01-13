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


public class TestItemPriceInCart {
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
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[3]/nav/ul/li[5]/a")));

        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div/div/div[2]/div/div[1]/div/a")));

        WebElement popupTitle = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div[2]/div/div[1]/div/a"));
        popupTitle.click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.buzzsneakers.ba/proizvodi/nike")) {
            System.out.println("test 1 passed");
        } else {
            System.out.println("test failed");
        }

        WebElement nikePatike = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div[3]/div[2]/div[2]/div/div[4]/div/div/div[1]/a"));
        nikePatike.click();

        String currentUrl2 = driver.getCurrentUrl();
        if (currentUrl2.equals("https://www.buzzsneakers.ba/patike/342546-nike-patike-jordan-fltclb-91-bg")) {
            System.out.println("test 2 passed");
        } else {
            System.out.println("test failed");
        }

        // broj patika
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/div[1]/div/div/div[2]/div[4]/ul/li[6]")).click();
        //dodaj u korpu
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/div[1]/div/div/div[2]/div[7]/div[4]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div[1]/a/div[1]/i")).click();
        Thread.sleep(2000);

        WebElement cartText = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[3]/form/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[10]/div/span"));
        String text = cartText.getText();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        if(text.equals("239,00 BAM")) {
            System.out.println("All test passed!");
        } else {
            System.out.println("test failed");
        }

    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
