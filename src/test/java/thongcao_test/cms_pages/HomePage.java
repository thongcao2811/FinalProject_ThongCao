package thongcao_test.cms_pages;

import freemarker.cache.WebappTemplateLoader;
import org.openqa.selenium.By;
import org.testng.Assert;
import thongcao_main.UI.WebUI;
import thongcao_main.drivers.DriverManager;

public class HomePage {
    private By homePage = By.xpath("//a[contains(text(),'Home')]");
    private By firstProduct = By.xpath("//a[normalize-space()='Cosy Hai Yen LICKTARS']");
    private By secondProduct = By.xpath("//div[@class='slick-slide slick-active']//div//a[@class='d-block text-reset'][contains(text(),'Apple iPhone 14 Pro , 128GB, 512GB, Deep Purple- U')]");
    private By buttonAddToCart = By.xpath("//button[@class='btn btn-soft-primary mr-2 add-to-cart fw-600']");
    private By buttonBackToShopping = By.xpath("//button[normalize-space()='Back to shopping']");
    private By numberofProducts = By.xpath("//span[@class='badge badge-primary badge-inline badge-pill cart-count']");
    private By addressInforadio = By.xpath("//body/div[@class='aiz-main-wrapper d-flex flex-column']/section[@class='mb-4 gry-bg']/div[@class='container']/div[@class='row cols-xs-space cols-sm-space cols-md-space']/div[@class='col-xxl-8 col-xl-10 mx-auto']/form[@role='form']/div[@class='shadow-sm bg-white p-4 rounded mb-4']/div[@class='row gutters-5']/div[133]/label[1]/span[1]/span[1]");
    private By buttonContinueToDelivery = By.xpath("//button[normalize-space()='Continue to Delivery Info']");
    private By buttonContinueToPayment = By.xpath("//button[normalize-space()='Continue to Payment']");
    private By additionalInfo = By.xpath("//textarea[@placeholder='Type your text']");
    private By checkboxAgreeConditions = By.xpath("//span[@class='aiz-square-check']");
    private By buttonCompleteOrder = By.xpath("//button[normalize-space()='Complete Order']");
    private By displayCart = By.xpath("//i[@class='la la-shopping-cart la-2x opacity-80']");
    private By checkOut = By.xpath("//a[normalize-space()='Checkout']");
    private By messageOrderComplete = By.xpath("//h1[normalize-space()='Thank You for Your Order!']");


    public void addProductToCart() {
        WebUI.waitForPageLoaded();
//        WebUI.sleep(5);
        WebUI.clickElement(buttonAddToCart);
        WebUI.sleep(5);
        WebUI.clickElement(buttonBackToShopping);
        WebUI.clickElement(homePage);
    }

    public void verifyAdd2ProductsToCart(){//
        WebUI.sleep(5);
        WebUI.clickElement(firstProduct);
        addProductToCart();
        WebUI.sleep(5);
        WebUI.clickElement(secondProduct);
        addProductToCart();
        WebUI.sleep(5);
        Assert.assertEquals(Integer.parseInt(WebUI.getElementText(numberofProducts)),2,"Number of products are not 2");

    }

    public void checkoutProduct(){
//        verifyAdd2ProductsToCart();
        WebUI.clickElement(displayCart);
        WebUI.clickElement(checkOut);
        WebUI.clickElement(addressInforadio);
        WebUI.clickElement(buttonContinueToDelivery);
        WebUI.clickElement(buttonContinueToPayment);
        WebUI.setText(additionalInfo,"Giao trong gio hanh chinh");
        WebUI.clickElement(checkboxAgreeConditions);
        WebUI.clickElement(buttonCompleteOrder);
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("order-confirmed"),"Order is not successfully");
        Assert.assertEquals(WebUI.getElementText(messageOrderComplete),"Thank You for Your Order!","Order is not successfully");
    }
}







