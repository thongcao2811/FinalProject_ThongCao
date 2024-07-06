package thongcao_test.cms_tests;

import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;
import thongcao_main.UI.WebUI;
import thongcao_main.configs.ConfigData;
import thongcao_test.basetest.BaseTest;
import thongcao_test.cms_pages.DashboardPage;
import thongcao_test.cms_pages.LoginPage;
import thongcao_test.cms_pages.ManageProfilePage;

public class ManageProfileTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ManageProfilePage manageProfilePage = new ManageProfilePage();
    String name = "SeleniumCourse";
    String phone = "12345";

    @Test
    public void verifyUpdateManageProfile(){
        dashboardPage = loginPage.loginCMS(ConfigData.EMAILCUSTOMER,ConfigData.PASSWORDCUSTOMER);
        loginPage.verifyLoginSuccess();
        dashboardPage.clickCancelButton();
        manageProfilePage = dashboardPage.clickManageProfile();
        WebUI.waitForPageLoaded();
        manageProfilePage.verifyHeaderManageProfilePage();
        manageProfilePage.updateManageProfile("SeleniumCourse", "12345");
        manageProfilePage.verifyUpdateProfile(name, phone);

    }
}
