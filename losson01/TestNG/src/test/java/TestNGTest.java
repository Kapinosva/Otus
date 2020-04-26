import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(TestNGTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        if (cfg.browser().equals("FF")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        logger.info("Драйвер поднят");
    }

    @Test
    public void openPage() {
        driver.get("https://otus.ru/");
        logger.info("Открыта страница отус");
    }

    @AfterMethod
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
