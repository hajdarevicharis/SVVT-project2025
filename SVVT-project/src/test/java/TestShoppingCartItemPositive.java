import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestShoppingCartItemPositive {
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
            driver.get("https://www.buzzsneakers.ba/patike/337598-nike-patike-nike-dunk-low-retro-ss");

            Thread.sleep(5000);

            WebElement sizeOption = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/div[1]/div/div/div[2]/div[5]/ul/li[1]"));
            sizeOption.click();

            Thread.sleep(2000);

            WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[1]/div[1]/div/div/div[2]/div[8]/div[4]/button"));
            addToCartButton.click();

            Thread.sleep(2000);

            WebElement cartButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div[1]/a"));
            cartButton.click();

            Thread.sleep(5000);

            WebElement cartItem = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[3]/form/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div[2]/a"));
            if (cartItem != null && cartItem.isDisplayed()) {
                System.out.println("Test Successful: Item successfully added to the cart.");
            } else {
                System.out.println("Test Failed: Item not found in the cart.");
            }


            Thread.sleep(5000);
        }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
