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

//

public class TestEmailSocialPositive {
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
    void test() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement emailInput = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/input[1]"));
        emailInput.sendKeys("haajdarevic@gmail.com");

        WebElement checkBox = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/form/div[1]/div[4]/div/input"));
        checkBox.click();

        WebElement prijavaButton = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/form/div[1]/div[3]/div[2]/div/input"));
        prijavaButton.click();

        WebElement text = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div[1]/div/p"));
        String newText = text.getText();

        if (newText.equals("Još jedan korak je potreban, a to je da potvrdiš prijavu klikom na link u emailu koji smo ti upravo poslali.")) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
