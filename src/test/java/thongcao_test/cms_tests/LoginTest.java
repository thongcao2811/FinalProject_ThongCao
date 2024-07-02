package thongcao_test.cms_tests;

import org.testng.annotations.Test;
import thongcao_main.configs.ConfigData;
import thongcao_main.dataprovider.DataProviderFactory;
import thongcao_test.basetest.BaseTest;
import thongcao_test.cms_pages.DashboardPage;
import thongcao_test.cms_pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage;

    @Test(dataProvider = "DataLoginSuccess",dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccessCustomer(String email, String password){
        dashboardPage = loginPage.loginCMS(email,password);
        loginPage.verifyLoginSuccess();
        dashboardPage.logOut();

    }

}
