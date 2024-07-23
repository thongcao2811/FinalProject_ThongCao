package thongcao_test.cms_pages;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import thongcao_main.UI.WebUI;
import thongcao_main.drivers.DriverManager;
import thongcao_main.helpers.ExcelHelper;

public class DashboardPage {
    String inputProductName = "Gio Qua Tet";
    private By menuDashboard = By.xpath("//div[@class='d-flex align-items-start']//span[@class='aiz-side-nav-text'][normalize-space()='Dashboard']");
    private By manageProfile = By.xpath("//div[@class='d-flex align-items-start']//span[@class='aiz-side-nav-text'][normalize-space()='Manage Profile']");
    private By homePage = By.xpath("//a[contains(text(),'Home')]");
    private By logoutButton = By.xpath("//a[contains(@class,'text-reset d-inline-block opacity-60 py-2')][normalize-space()='Logout']");
//    private By cancelButton = By.xpath("//i[@class='la la-close fs-20']");

    private By cancelButton = By.xpath("//button[@data-key='website-popup' and @data-value='removed']");
    private By searchTextBox = By.xpath("//input[@id='search']");
    private By firstNewProduct = By.xpath("//a[contains(text(),'Giỏ quà Tết Giáp Thìn')]");
    private By noProductFound = By.xpath("//div[@class='search-nothing p-3 text-center fs-16']");
    private By productName = By.xpath("//h1[contains(text(),'Giỏ quà Tết Giáp Thìn')]");
    private By soldBy = By.xpath("//div[@class='row align-items-center']//div[@class='col-auto']");
    private By price = By.xpath("//strong[@class='h2 fw-600 text-primary']");
    private By quantity = By.xpath("//input[@placeholder='1']");
    private By totalPrice = By.xpath("//strong[@id='chosen_price']");




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
        WebUI.setTextAndKey(searchTextBox, inputProductName, Keys.ENTER);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(firstNewProduct);
        WebUI.sleep(3);
    }

    public void splitString(String text){
        String originalText = "";
        String[] parts = originalText.split(":");
        if (parts.length > 1) {
            String result = parts[1];
//            System.out.println("Extracted text: " + result);
        } else {
            System.out.println("Pattern not found in the original text.");
        }
    }

    

    public void setProductInfo(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/ProductInfo.xlsx","Sheet1");
        excelHelper.setCellData(WebUI.getElementText(productName),"Name",1);
        excelHelper.setCellData(WebUI.getElementText(soldBy).split(":",2)[1].trim(),"Soldby",1);//
        excelHelper.setCellData(WebUI.getElementText(price),"Price",1);
        excelHelper.setCellData(WebUI.getElementAttribute(quantity,"placeholder"),"Quantity",1);
        excelHelper.setCellData(WebUI.getElementText(totalPrice),"TotalPrice",1);

    }














}

