import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestSessionTimeout {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Haki\\Desktop\\svvt\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testSessionTimeout() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");

        WebElement loginButton = driver.findElement(By.xpath("//nav/ul/li[1]/a/span"));
        loginButton.click();

        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/input"));
        emailField.sendKeys("haajdarevic@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/input"));
        passwordField.sendKeys("Haki2003!");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[5]/input"));
        submitButton.click();



        String url = driver.getCurrentUrl();

        Thread.sleep(7000);
        if (url.equals("https://www.buzzsneakers.ba/#")) {
            System.out.println("Test Passed: Login successful");
        } else {
            System.out.println("Test Failed: Login not successful");
        }

        int sessionTimeoutInSeconds = 300;
        System.out.println("Waiting for session timeout...");
        Thread.sleep(sessionTimeoutInSeconds * 1000);

        driver.navigate().refresh();

        if (url.equals("https://www.buzzsneakers.ba/#")) {
            System.out.println("Session timeout");
        } else {
            System.out.println("Session did not timeout as excpeted");
        }

        System.out.println("Session timeout test passed.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
