package thongcao_main.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    // Dùng ở BaseTest - > @BeforeMethod. Mục đích là để set 1 driver - tương ứng với 1 browser, và cho vào ThreadLocal
    public static void setDriver(WebDriver driver){
        DriverManager.driver.set(driver);
    }

    //Dùng ở BaseTest -> @AfterMethod. Muc đích là để xóa driver va remove vi trí của driver trong ThreadLocal
    public static void quit(){
        if (DriverManager.driver.get() != null){
            DriverManager.driver.get().quit();
            driver.remove();
        }
    }



}
