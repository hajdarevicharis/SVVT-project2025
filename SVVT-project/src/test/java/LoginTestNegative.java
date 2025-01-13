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

public class LoginTestNegative {
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
    void testLogin() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement loginButton = driver.findElement(By.xpath("//nav/ul/li[1]/a/span"));
        loginButton.click();

        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/input"));
        emailField.sendKeys("rijad123@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/input"));
        passwordField.sendKeys("rijad123");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[5]/input"));
        submitButton.click();

        WebElement text = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[6]/div"));
        String finalText = text.getText();

        if (finalText.equals("Pogrešno ime ili lozinka")) {
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
