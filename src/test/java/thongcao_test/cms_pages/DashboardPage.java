package thongcao_test.cms_pages;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import thongcao_main.UI.WebUI;
import thongcao_main.drivers.DriverManager;

public class DashboardPage {
    String productName = "Gio Qua Tet";
    private By menuDashboard = By.xpath("//div[@class='d-flex align-items-start']//span[@class='aiz-side-nav-text'][normalize-space()='Dashboard']");
    private By manageProfile = By.xpath("//div[@class='d-flex align-items-start']//span[@class='aiz-side-nav-text'][normalize-space()='Manage Profile']");
    private By homePage = By.xpath("//a[contains(text(),'Home')]");
    private By logoutButton = By.xpath("//a[contains(@class,'text-reset d-inline-block opacity-60 py-2')][normalize-space()='Logout']");
//    private By cancelButton = By.xpath("//i[@class='la la-close fs-20']");

    private By cancelButton = By.xpath("//button[@data-key='website-popup' and @data-value='removed']");
    private By searchTextBox = By.xpath("//input[@id='search']");
    private By firstNewProduct = By.xpath("//a[contains(text(),'Giỏ quà Tết Giáp Thìn')]");


    public ManageProfilePage clickManageProfile(){
        WebUI.clickElement(manageProfile);
        return new ManageProfilePage();
    }

    public HomePage clickHomePage(){
        WebUI.clickElement(homePage);
        return new HomePage();
    }

    public void clickCancelButton(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(cancelButton);
    }
    public LoginPage logOut(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(logoutButton);
        return new LoginPage();
    }

    public void searchProduct(){
        WebUI.waitForPageLoaded();
        WebUI.setTextAndKey(searchTextBox, productName, Keys.ENTER);
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("Gio+Qua+Tet"),"");

    }












}

