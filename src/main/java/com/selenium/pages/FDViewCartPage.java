package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class FDViewCartPage extends CommonActions {
    public HeaderArea headerArea;
    public FooterArea footerArea;

    public FDViewCartPage (WebDriver driver) {
        this.driver = driver;
        initElement();
        headerArea = new HeaderArea(driver);
        footerArea = new FooterArea(driver);
    }

    @FindBy(xpath = "//div[@fd-product]/descendant::div[@class='cartline-quantity cartline-box']/descendant::select")
    public List<WebElement> inp_productQty;

    @FindBy(xpath = "/html/body/main/fd-view-cart/main/div/div/div[1]/div[2]/fd-cartcontent/form/div[4]/button")
    public  WebElement btn_emptyCart;

    @FindBy(xpath = "//*[@id=\"fd-overlay-1702642097\"]/div")
    public WebElement cartEmptyPopup;

    @FindBy (xpath = "//*[@id=\"fd-order-tally\"]")
    public WebElement estimated_total;

    @FindBy(xpath = "//div[@fd-product]/descendant::div[@class='cartline-title cartline-box']/descendant::a")
    public List<WebElement> lnk_products;

    @FindBy(xpath = "//div[@class='cartline-price-delete cartline-box']/descendant::fd-trash-button[@class='cartline-link']")
    public List<WebElement> btn_deleteIcon;

    @FindBy(xpath = "//div[@fd-product]/descendant::div[@class='cartline-price-delete cartline-box']/descendant::p[@class='cartline-price-value']")
    public List<WebElement> lbl_productPriceValue;

    @FindBy(xpath = "//*[@id=\"fd-order-tally__checkout__button\"]")
    public WebElement btn_checkout;

    @FindBy(xpath = "/html/body/main/fd-view-cart/main/div/div/div[1]/div[1]/fd-error/div")
    public WebElement lnk_forMinimum;

    @FindBy(xpath = "//*[@id=\"fd-order-tally\"]/div[2]/dl/div[2]/dd/div/button")
    public WebElement btn_freeLink;

    @FindBy(xpath = "//*[@id=\"fd-free-trial-overlay-content\"]/fd-freetrial-form/form/div/div")
    public WebElement popup_freeDelivery;

    @FindBy(xpath = "//span[@class='cartsection-sectionsubtotal__value']")
    public WebElement btn_subtotal;

    public void changeQuantityValue(int itemIndexNum, int value) {
        selectDropdownOptionByVisibleText(inp_productQty.get(itemIndexNum), String.valueOf(value));
    }

    public int getItemQtyDropdownValue(int index) {
        return Integer.valueOf(getDefaultValueFromADropdown(inp_productQty.get(index)));
    }

    public void verifyQuantityIsIncreased(int increaseBy, int startValue, int endValue) {
        Verify.verify(startValue, endValue - increaseBy);
    }

    public void verifyQuantityIsDecreased(int decreaseBy, int startValue, int endValue) {
        Verify.verify(startValue, endValue + decreaseBy);
    }

    public void clickOncEmptyCartButton(){
        clickOnElement(btn_emptyCart);
    }

    public void verifyCartEmptyConfirmDisplayed() {
        Verify.verifyIfElementIsDisplayed(cartEmptyPopup);
    }

    public void clickOnAnItemLink(int index){
        clickOnElement(lnk_products.get(index));
    }

    public void verifyRedirectToTheProductPdpPage(){
        Verify.verifyCurrentUrlContainsText("https://fdtest.freshdirect.com/pdp.jsp");
    }

    public void clickOnDeleteButton(int index){
        clickOnElement(btn_deleteIcon.get(index));
        waitForElementToBeDisappear(btn_deleteIcon.get(index), 5);
    }

    public double findInitSubtotalForEachProduct(int index){
        String initPrice = lbl_productPriceValue.get(index).getText();
        String temp = initPrice.replace("$","") ;
        double  initialPrice = Double.parseDouble(temp);
        return  initialPrice;
    }

    public double findAllSubtotalProduct(){
        String initPrice = btn_subtotal.getText();
        String temp = initPrice.replace("$","") .replace("*","");
        double  initialPrice = Double.parseDouble(temp);
        return  initialPrice;
    }

    public void verifyPriceChangedWithQuantityIncrease(int index, boolean condition){
        Verify.verify(condition);
    }

    public void verifyPriceChangedWithQuantityDecrease(int index, double expected){
        Verify.verify(expected, findInitSubtotalForEachProduct(index));
    }

    public int getProductCount() {
        return getSizeFromList(lnk_products);
    }

    public void verifyProductIsDeleted(int beforeCount, int afterCount) {
        Verify.verify(beforeCount, afterCount);
    }

    public void clickOnCheckoutButton(){
        clickOnElement(btn_checkout);
    }

    public void verifyClickingOnCheckoutButtonCanOpenCheckoutPage(){
        Verify.verifyCurrentUrlContainsText("https://fdtest.freshdirect.com/expressco/checkout.jsp");
    }

    public void verifyDisplayOrderMinimumWarningMessageForLessThanMinimumCartTotal(){
        Verify.verifyIfElementIsDisplayed(lnk_forMinimum);
    }

    public void clickOnFreeButtonLink(){
        clickOnElement(btn_freeLink);
    }

    public void verifyFreeDeliveryPopupIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popup_freeDelivery);
    }


}


