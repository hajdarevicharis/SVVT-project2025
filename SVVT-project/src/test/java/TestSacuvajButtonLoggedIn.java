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


public class TestSacuvajButtonLoggedIn {
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

        WebElement loginButton = driver.findElement(By.xpath("//nav/ul/li[1]/a/span"));
        loginButton.click();

        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/input"));
        emailField.sendKeys("haajdarevic@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/input"));
        passwordField.sendKeys("Haki2003!");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[2]/div[1]/div[5]/input"));
        submitButton.click();

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
            System.out.println("test 1 failed");
        }

        WebElement nikePatike = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div[3]/div[2]/div[2]/div/div[4]/div/div/div[1]/a"));
        nikePatike.click();

        String currentUrl2 = driver.getCurrentUrl();
        if (currentUrl2.equals("https://www.buzzsneakers.ba/patike/342546-nike-patike-jordan-fltclb-91-bg")) {
            System.out.println("test 2 passed");
        } else {
            System.out.println("test 2 failed");
        }

        Thread.sleep(2000);

        WebElement sacuvajButton = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/div[1]/div/div/div[2]/div[7]/div[5]"));
        sacuvajButton.click();
        Thread.sleep(2000);


/// /////////////////////////////
        WebElement text = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/div[1]/div/div/div[2]/div[7]/div[5]"));
        text.getText();

        if(text.equals("Uklonite iz liste želja")) {
            System.out.println("Test 3 passed");
        } else {
            System.out.println("Test 3 failed");
        }
    }

    // Navigate to Buzz Sneakers website
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
