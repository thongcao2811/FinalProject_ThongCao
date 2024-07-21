package thongcao_test.cms_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import thongcao_main.UI.WebUI;

public class ProductPageAdmin {
    private By addNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By inputProductName = By.xpath("//input[@placeholder='Product Name']");
    private By dropdownCategory = By.xpath("//button[@title='Sport shoes']");
    private By inputCategorySearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By inputMinimumPurchaseQty = By.xpath("//input[@name='min_qty']");
    private By inputTags = By.xpath("//tags[@role='tagslist']");
    private By inputUnitPrice = By.xpath("//input[@placeholder='Unit price']");
    private By inputDiscount = By.xpath("//input[@placeholder='Discount']");
    private By inputQuantity = By.xpath("//input[@placeholder='Quantity']");

    public void clickAddNewProduct(){
        WebUI.clickElement(addNewProduct);
    }

    public void inputProductInformation(){
        WebUI.setText(inputProductName,"Yonex 65Z3");
        WebUI.clickElement(dropdownCategory);
        WebUI.setText(inputCategorySearch,"Sport shoes");
        WebUI.setKey(inputCategorySearch, Keys.ENTER);


    }



}
