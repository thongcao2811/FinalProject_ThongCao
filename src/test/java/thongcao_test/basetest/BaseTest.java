package thongcao_test.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import thongcao_main.drivers.DriverManager;
import thongcao_main.utils.ConfigReader;
import thongcao_test.listeners.TestListener;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void createBrowser(@Optional("chrome") String browserName) {
        // Nếu không có giá trị, lấy từ config.properties
        if (browserName == null || browserName.isEmpty()) {
            browserName = ConfigReader.getProperty("browser");
        }
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
    }

    public WebDriver setupBrowser(String browserName) {
        String browser = ConfigReader.getProperty("browser");

        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser is not supported: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getIntProperty("timeout")));
        driver.get(ConfigReader.getProperty("URL"));
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Close browser testing");
        DriverManager.quit();

    }

}
