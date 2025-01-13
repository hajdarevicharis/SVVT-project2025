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
import java.util.Set;


public class RegisterTestFacebookButton {
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


        WebElement registerButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div[3]/div/span/nav/ul/li[2]/a"));
        registerButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div[2]")));

        Thread.sleep(4000);

        String mainWindowHandle = driver.getWindowHandle();

        WebElement facebookButton = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div/form/div[3]/div[6]/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/span[2]/button"));
        facebookButton.click();


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.numberOfWindowsToBe(2));


        Set<String> allWindowHandles = driver.getWindowHandles();
        Assert.assertTrue("New window did not open", allWindowHandles.size() > 1);


        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        if (allWindowHandles.size() > 1) {
            System.out.println("New window has opened!");

            for (String windowHandle : allWindowHandles) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

        } else {
            System.out.println("No new window opened.");
            Assert.fail("No new window opened.");
        }

        driver.switchTo().window(mainWindowHandle);

    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
