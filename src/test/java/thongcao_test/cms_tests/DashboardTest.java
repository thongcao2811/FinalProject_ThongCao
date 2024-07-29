package thongcao_test.cms_tests;

import org.testng.annotations.Test;
import thongcao_main.UI.WebUI;
import thongcao_main.configs.ConfigData;
import thongcao_main.helpers.ExcelHelper;
import thongcao_test.basetest.BaseTest;
import thongcao_test.cms_pages.DashboardPage;
import thongcao_test.cms_pages.DashboardPageAdmin;
import thongcao_test.cms_pages.LoginPage;
import thongcao_test.cms_pages.ProductPageAdmin;

import java.io.ObjectInputFilter;

public class DashboardTest extends BaseTest {



    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    DashboardPageAdmin dashboardPageAdmin = new DashboardPageAdmin();
    ProductPageAdmin productPageAdmin = new ProductPageAdmin();



    @Test
    public void setProductInfoToExcelFile(){
        dashboardPage = loginPage.loginCMS(ConfigData.EMAILCUSTOMER, ConfigData.PASSWORDCUSTOMER);
        loginPage.verifyLoginSuccess();
        dashboardPage.clickCancelButton();
        dashboardPage.searchExistingProduct("Gio Qua Tet");
        dashboardPage.setProductInfo();

    }

    @Test
    public void verifyNewAddedProduct(){
        dashboardPage = loginPage.loginCMS(ConfigData.EMAILCUSTOMER,ConfigData.PASSWORDCUSTOMER);
        loginPage.verifyLoginSuccess();
        dashboardPage.clickCancelButton();
        dashboardPage.verifyProductBeforeAdding();
        loginPage = dashboardPage.logOut();
        dashboardPageAdmin = loginPage.loginCMSAdmin(ConfigData.EMAILADMIN, ConfigData.PASSWORDADMIN);
        productPageAdmin = dashboardPageAdmin.clickMenuAddNewProduct();
        productPageAdmin.clickAddNewProduct();
        productPageAdmin.inputProductInformation("Yonex 65Z3","Sport shoes","KG",1,"sportshoes",2600000,0,3);
        loginPage = productPageAdmin.logOut();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAILCUSTOMER, ConfigData.PASSWORDCUSTOMER);
        WebUI.waitForPageLoaded();
        dashboardPage.verifyProductAfterAdding();
        dashboardPage.verifyNewProductInfo();
    }



}
