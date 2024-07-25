package thongcao_test.cms_pages;

import org.openqa.selenium.By;
import thongcao_main.UI.WebUI;

public class DashboardPageAdmin {

    private By menuProductAdmin = By.xpath("//span[normalize-space()='Products']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");


    public ProductPageAdmin clickMenuAddNewProduct(){
        WebUI.clickElement(menuProductAdmin);
        WebUI.clickElement(menuAddNewProduct);
        return new ProductPageAdmin();
    }



}
