package thongcao_test.cms_pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import thongcao_main.UI.WebUI;
import thongcao_main.configs.ConfigData;
import thongcao_main.drivers.DriverManager;

public class LoginPage {
    private By headerPage = By.xpath("//h1[normalize-space()='Login to your account.']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");



    private void setInputEmail(String email){
        WebUI.setText(inputEmail, email);
    }

    private void setInputPassword(String password){
        WebUI.setText(inputPassword, password);
    }

    private void clickLoginButton(){
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains("login"),"Still being in Login Page");

    }

    public void verifyLoginFail(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("login"),"Navigated to Dashboard Page");

    }

    public DashboardPage loginCMS(String email, String password){
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        setInputEmail(email);
        setInputPassword(password);
        clickLoginButton();
        return new DashboardPage();
    }

    public DashboardPageAdmin loginCMSAdmin(String email, String password){
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        setInputEmail(email);
        setInputPassword(password);
        clickLoginButton();
        return new DashboardPageAdmin();
    }


}
