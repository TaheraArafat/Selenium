package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import com.selenium.configuration.PropertyLoader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends CommonActions {
    public CheckoutPage(WebDriver driver){
        this.driver= driver;
        initElement();
    }
    @FindBy(xpath = " //button[text()='Add Payment Method']")
    public WebElement btn_addPaymentMethod;

    @FindBy(xpath = "//div[@class='external-payments']//fd-icon[@icon='paypal']//*[local-name()='svg']")
    public WebElement btn_payPal;

    @FindBy(xpath = "//div[@class='button-section']//button[@class='paypal-button']/fd-icon")
    public WebElement btn_addPayPal;


    @FindBy(xpath = "//*[@id=\"addpaymentmethod_masterpass\"]")
    public WebElement btn_masterPass;

    @FindBy(xpath = " //body//div//fd-view-cart")
    public WebElement popUp_CheckOutPaymentMethod;

    @FindBy(xpath = "//div[@class='wrapper root-container']")
    public WebElement popUp_payWithMasterPass;

    @FindBy(xpath = "/html/body/div[2]/fd-checkout/div/div[2]/div/fd-address-drawer/div/div/div[2]/div/button")
    public WebElement btn_EditButton;

    @FindBy(xpath = "//div[@class='addresses delivery-addresses']//descendant::div[@class='address-line']")
    public List<WebElement> btn_AddressLine;

    @FindBy(xpath = "/html/body/div[2]/fd-checkout/div/div[2]/div/fd-address-drawer/div/div/div[2]/button[1]")
    public WebElement btn_addDeliveryAddress;

    @FindBy(css = "div.address-drawer__sub-header button[open-pickup-address-list]")
    public WebElement btn_pickupYourOrder;

    @FindBy(xpath = "/html/body/div[2]/fd-checkout/div/div[2]/div/fd-address-drawer/div/fd-address-drawer-form/form/div[2]/div[1]/h2")
    public WebElement popUp_DeliveryAddress;

    @FindBy(xpath = "/html/body/div[2]/fd-checkout/div/div[2]/div/fd-address-drawer/div/div/div[2]/div/div/div/label/div/span")
    public WebElement icon_Express;

    @FindBy(xpath = "/html/body/div[2]/fd-checkout/div/div[2]/div/fd-address-drawer/div/fd-address-drawer-form/form/div[2]/div[2]/div[6]/button")
    public WebElement btn_PickUpOrder;

    @FindBy(xpath = "/html/body/div[2]/fd-checkout/div/div[2]/div/fd-address-drawer/div/fd-address-drawer-form/form/div[3]")
    public WebElement popUp_pickUpLocation;

    @FindBy(xpath = "//select[@id='tip-select']")
    public WebElement dropDown_tip;

    @FindBy(tagName = "fd-checkout-order-tally")
    public WebElement orderTallyShadowRoot;

    public void clickOnAddPaymentMethod() {
        clickOnElement(btn_addPaymentMethod);
        holdExecution(2000);
    }

    public void clickOnPayPalButton(){
        clickOnElement(btn_payPal);
        holdExecution(2000);
    }

    public void clickOnPayWithCreditDebitCardButton(){
        clickOnElement(btn_masterPass);
        holdExecution(2000);
    }

    public void clickOnDeliveryAddressEditButton(){
        clickOnElement(btn_EditButton);
        holdExecution(3000);
    }

    public void switchToPaypalWindow(){
        switchWindow(1, false);
    }

    public void switchToAddDebitCreditCardWindow(){
        switchWindow(1, false);
        holdExecution(3000);
    }

    public void addPaymentMethodIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popUp_CheckOutPaymentMethod);

    }

    public void PayWithMasterPassIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popUp_payWithMasterPass);
    }

    public void verifyTimeSlotsEditPageUrl(){
        Verify.verifyCurrentUrlContainsText("/help/delivery_info.jsp");
    }

    public void verifyAddDeliveryAddressButtonIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(btn_addDeliveryAddress);
    }

    public void verifyPickupYourOrderButtonIsDisplayed() {
        Verify.verifyIfElementIsDisplayed(btn_pickupYourOrder);
    }

    public void clickOnAddDeliveryAddressButton(){
        clickOnElement(btn_addDeliveryAddress);
    }

    public void clickOnPickupYourOrder() {
        clickOnElement(btn_pickupYourOrder);
    }

    public void verifyPaypalButtonIsDisplayed(){
        Verify.verify("Paypal button is not present", "paypal",getAttributeValue(btn_addPayPal, "icon"));
    }

    public void deliveryAddressPageIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popUp_DeliveryAddress);
    }

    public void expressIconIsDisplayedInExpressEligibleAddress(){
        Verify.verifyIfElementIsDisplayed(icon_Express);
    }

    public void clickOnHowToPickUpOrder(){
        holdExecution(3000);
        clickOnElement(btn_PickUpOrder);
    }

    public void pickUpLocationPopUp(){
        Verify.verifyIfElementIsDisplayed(popUp_pickUpLocation);
    }

    public void verifyAddPaymentMethodButton(){
        Verify.verify( "Add Payment Button is not Displayed",getAttributeValue(btn_addPaymentMethod, "Add Payment Method"));
    }

    public void selectTipFromDropDownAmount(String value){
        selectDropdownOptionByValue(dropDown_tip, value);
    }

    public void verifySelectedTipAmountDisplayedCorrectlyInOrderTally(double selectedAmount) {
      Verify.verify(selectedAmount, getAmountOfTip());
    }

    private double getAmountOfTip() {
        WebElement lbl_tip = getShadowRootElement(orderTallyShadowRoot).findElement(By.cssSelector("div.tip_container div.value"));
        return getUSDFrom(getElementText(lbl_tip));
    }

    public double getBottleDeposit() {
        WebElement lbl_bottleDeposit = getShadowRootElement(orderTallyShadowRoot).findElement(By.cssSelector("div.bottle-deposit_container div.value"));
        return getUSDFrom(getElementText(lbl_bottleDeposit));
    }

    public void verifyBottleDepositDisplayedCorrectlyInOrderTally() {
        Verify.verify(getUSDFrom(PropertyLoader.getValue("global.bottleDeposit")), getBottleDeposit());
    }
}
