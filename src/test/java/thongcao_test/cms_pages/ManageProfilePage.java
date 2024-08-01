package thongcao_test.cms_pages;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import thongcao_main.UI.WebUI;

public class ManageProfilePage {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    private By headerManageProfilePage = By.xpath("//h1[normalize-space()='Manage Profile']");
    private By yourName = By.xpath("//input[@placeholder='Your name']");
    private By yourPhone = By.xpath("//input[@placeholder='Your Phone']");
    private By updateProfileButton = By.xpath("//button[normalize-space()='Update Profile']");

    public void updateManageProfile(String name,String phone){
        WebUI.waitForPageLoaded();
        WebUI.setText(yourName, name);
        WebUI.setText(yourPhone, phone);
        WebUI.clickElement(updateProfileButton);
        WebUI.sleep(3);
    }

    public void verifyUpdateProfile(String name, String phone){
        SoftAssert softAssert = new SoftAssert();
        WebUI.waitForPageLoaded();
        softAssert.assertEquals(WebUI.getElementAttribute(yourName,"value"), name,"Name field is not corrected");
        softAssert.assertEquals(WebUI.getElementAttribute(yourPhone, "value"),phone,"Phone field is not corrected");
        softAssert.assertAll();

    }

    public void verifyHeaderManageProfilePage(){
        WebUI.waitForElementVisible(headerManageProfilePage);
        Assert.assertTrue(WebUI.checkElementDisplayed(headerManageProfilePage),"Header Manage Profile Page does not display");
        Assert.assertEquals(WebUI.getElementText(headerManageProfilePage), "Manage Profile", "Header is not correct");

    }

}
