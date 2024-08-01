package thongcao_test.cms_pages;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import thongcao_main.UI.WebUI;
import thongcao_main.drivers.DriverManager;
import thongcao_main.helpers.ExcelHelper;

public class DashboardPage {
    String newProduct = "Yonex 65Z3";
    private By newAddingProduct = By.xpath("//a[normalize-space()='Yonex 65Z3']");
    private By newAddingProductDetail = By.xpath("//h1[normalize-space()='Yonex 65Z3']");


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

    public void searchExistingProduct(String productName){
        WebUI.waitForPageLoaded();
        WebUI.setTextAndKey(searchTextBox, productName, Keys.ENTER);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(firstNewProduct);
        WebUI.sleep(3);
    }

    public void verifyNewProductInfo(){
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
        Assert.assertEquals(WebUI.getElementText(newAddingProductDetail),"Yonex 65Z3","Product Name is not correct");
        Assert.assertEquals(WebUI.getElementText(soldBy).split(":",2)[1].trim(),"Inhouse product", "Supplier is not correct");
        Assert.assertEquals(WebUI.getElementText(price).replace("$","").replace(",",""), "2600000.00","Unit price is not correct");
        WebUI.sleep(3);
    }
    

    public void setProductInfo(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/ProductInfo.xlsx","Sheet1");
        excelHelper.setCellData(WebUI.getElementText(productName),"Name",1);
        excelHelper.setCellData(WebUI.getElementText(soldBy).split(":",2)[1].trim(),"Soldby",1);
        excelHelper.setCellData(WebUI.getElementText(price),"Price",1);
        excelHelper.setCellData(WebUI.getElementAttribute(quantity,"placeholder"),"Quantity",1);
        excelHelper.setCellData(WebUI.getElementText(totalPrice),"TotalPrice",1);

    }

    public void verifyProductBeforeAdding() {
        try {
            WebUI.waitForPageLoaded();
            WebUI.setTextAndKey(searchTextBox, newProduct, Keys.ENTER);
            Assert.assertFalse(WebUI.checkElementExist(newAddingProduct), "Product is existing:" + newAddingProduct);
        } catch (TimeoutException e) {
            Assert.fail("Timeout waiting for the element Visible. Locator: " + newAddingProduct + ". Exception: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred while verifying the product: " + e.getMessage());
        }
    }

    public void verifyProductAfterAdding() {
        try {
            WebUI.waitForPageLoaded();
            WebUI.setTextAndKey(searchTextBox, newProduct, Keys.ENTER);
            Assert.assertTrue(WebUI.checkElementExist(newAddingProduct), "Product is NOT existing:" + newAddingProduct);
            WebUI.clickElement(newAddingProduct);
            WebUI.sleep(5);
        } catch (TimeoutException e) {
            Assert.fail("Timeout waiting for the element Visible. Locator: " + newAddingProduct + ". Exception: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred while verifying the product: " + e.getMessage());
        }
    }

}

