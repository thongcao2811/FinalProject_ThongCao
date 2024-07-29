package thongcao_test.cms_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import thongcao_main.UI.WebUI;

public class ProductPageAdmin {
    private By menuDashboardPageAdmin = By.xpath("//span[normalize-space()='Dashboard']");
    private By addNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By inputProductName = By.xpath("//input[@placeholder='Product Name']");
    private By dropdownCategory = By.xpath("//button[@title='Sport shoes']");
    private By inputCategorySearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By inputUnit = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    private By inputMinimumPurchaseQty = By.xpath("//input[@name='min_qty']");
    private By inputTags = By.xpath("//span[@role='textbox']");
    private By inputUnitPrice = By.xpath("//input[@placeholder='Unit price']");
    private By inputDiscount = By.xpath("//input[@placeholder='Discount']");
    private By inputQuantity = By.xpath("//input[@placeholder='Quantity']");
    private By buttonSaveandPublish = By.xpath("//button[normalize-space()='Save & Publish']");
    private By adminExample = By.xpath("//span[@class='d-block fw-500']");
    private By buttonLogout = By.xpath("//a[@href='https://cms.anhtester.com/logout']");

    public void clickAddNewProduct(){
        WebUI.clickElement(addNewProduct);
    }

//    public void inputProductInformation(){
//        WebUI.setText(inputProductName,"Yonex 65Z3");
//        WebUI.clickElement(dropdownCategory);
//        WebUI.setText(inputCategorySearch,"Sport shoes");
//        WebUI.setKey(inputCategorySearch, Keys.ENTER);
//        WebUI.setText(inputUnit, "KG");
//        WebUI.setText(inputMinimumPurchaseQty,"1");
//        WebUI.setText(inputTags,"sportshoes");
//        WebUI.setKey(inputTags, Keys.ENTER);
//        WebUI.setText(inputUnitPrice, "2600000");
//        WebUI.setText(inputDiscount,"0");
//        WebUI.setText(inputQuantity,"3");
//        WebUI.sleep(3);
//        WebUI.clickElement(buttonSaveandPublish);
//    }

    public void inputProductInformation(String productName, String category, String unit, int minimumPurchaseQty, String tags, int unitPrice, int discount, int quantity){
        WebUI.setText(inputProductName, productName);
        WebUI.clickElement(dropdownCategory);
        WebUI.setText(inputCategorySearch, category);
        WebUI.setKey(inputCategorySearch, Keys.ENTER);
        WebUI.setText(inputUnit, unit);
        WebUI.setText(inputMinimumPurchaseQty, String.valueOf(minimumPurchaseQty));
        WebUI.setText(inputTags,tags);
        WebUI.setKey(inputTags, Keys.ENTER);
        WebUI.setText(inputUnitPrice, String.valueOf(unitPrice));
        WebUI.setText(inputDiscount, String.valueOf(discount));
        WebUI.setText(inputQuantity, String.valueOf(quantity));
        WebUI.sleep(3);
        WebUI.clickElement(buttonSaveandPublish);
    }

    public LoginPage logOut(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(adminExample);
        WebUI.clickElement(buttonLogout);
        return new LoginPage();
    }






}
