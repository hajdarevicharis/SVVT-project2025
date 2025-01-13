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

public class TestSessionHandling {
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
    public void testSessionPersistence() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/span/nav/ul/li[1]/a"));
        loginButton.click();

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

        driver.navigate().refresh();
        Assert.assertTrue("Session not persisted after refresh", url.equals("https://www.buzzsneakers.ba/#"));

        WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/span/nav/ul/li[2]/a"));
        logoutButton.click();

        Assert.assertTrue("Session not terminated after logout", driver.getCurrentUrl().contains("/#"));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
