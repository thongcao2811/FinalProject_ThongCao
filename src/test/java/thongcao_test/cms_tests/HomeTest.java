package thongcao_test.cms_tests;

import org.testng.annotations.Test;
import thongcao_main.configs.ConfigData;
import thongcao_test.basetest.BaseTest;
import thongcao_test.cms_pages.DashboardPage;
import thongcao_test.cms_pages.HomePage;
import thongcao_test.cms_pages.LoginPage;

public class HomeTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    HomePage homePage;

    @Test
    public void getProductInfo(){
        dashboardPage = loginPage.loginCMS(ConfigData.EMAILCUSTOMER,ConfigData.PASSWORDCUSTOMER);
        homePage = dashboardPage.clickHomePage();



    }

}
