package thongcao_test.cms_tests;

import org.testng.annotations.Test;
import thongcao_main.UI.WebUI;
import thongcao_main.configs.ConfigData;
import thongcao_main.dataprovider.DataProviderFactory;
import thongcao_main.helpers.PropertiesHelper;
import thongcao_main.reports.ExtentTestManager;
import thongcao_test.basetest.BaseTest;
import thongcao_test.cms_pages.DashboardPage;
import thongcao_test.cms_pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage;


//    (dataProvider = "DataLoginSuccessCustomer",dataProviderClass = DataProviderFactory.class)
    @Test (dataProvider = "DataLoginSuccessCustomer",dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccessCustomer(String email, String password){
        dashboardPage = loginPage.loginCMS(ConfigData.EMAILCUSTOMER, ConfigData.PASSWORDCUSTOMER);
        loginPage.verifyLoginSuccess();
        dashboardPage.clickCancelButton();
        dashboardPage.logOut();
        WebUI.sleep(3);
    }
    @Test (dataProvider = "DataLoginSuccessAdmin",dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccessAdmin(String email, String password){
        dashboardPage = loginPage.loginCMS(ConfigData.EMAILADMIN, ConfigData.PASSWORDADMIN);
        loginPage.verifyLoginSuccess();
//        dashboardPage.logOut();
        WebUI.sleep(3);

    }

    @Test (dataProvider = "DataLoginFail",dataProviderClass = DataProviderFactory.class)
    public void testLoginFail(String email, String password){
        dashboardPage = loginPage.loginCMS(email,password);
        loginPage.verifyLoginFail();
        WebUI.sleep(3);
    }

}



