package thongcao_test.cms_tests;

import org.testng.annotations.Test;
import thongcao_main.UI.WebUI;
import thongcao_main.configs.ConfigData;
import thongcao_main.helpers.ExcelHelper;
import thongcao_test.basetest.BaseTest;
import thongcao_test.cms_pages.DashboardPage;
import thongcao_test.cms_pages.DashboardPageAdmin;
import thongcao_test.cms_pages.LoginPage;

import java.io.ObjectInputFilter;

public class DashboardTest extends BaseTest {



    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    DashboardPageAdmin dashboardPageAdmin;






    @Test
    public void setProductInfoToExcelFile(){
        dashboardPage = loginPage.loginCMS(ConfigData.EMAILCUSTOMER, ConfigData.PASSWORDCUSTOMER);
        loginPage.verifyLoginSuccess();
        dashboardPage.clickCancelButton();
        dashboardPage.searchProduct();
        dashboardPage.setProductInfo();

    }

    @Test
    public void verifyNewAddedProduct(){
        dashboardPage = loginPage.loginCMS(ConfigData.EMAILCUSTOMER,ConfigData.PASSWORDCUSTOMER);
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyProductBeforeAdding();



    }



}
