package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import com.selenium.configuration.PropertyLoader;
import com.selenium.popup.TimeSlotsPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//fd-close-button[@color='white']")
    public WebElement btn_checkoutCrossButton;

    @FindBy(css = "body > div:nth-child(6) > fd-checkout:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > fd-promo:nth-child(1) > fd-input-action:nth-child(2)")
    public WebElement promoCodeShadowRoot;

    @FindBy(tagName = "fd-checkout-timeslot")
    public List<WebElement> container_viewTimeSlotShadowRoot;

    @FindBy(tagName = "fd-checkout-delivery-fee")
    public WebElement deliveryFeeShadowRoot;



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

    public double getFuelSurcharge() {
        double fuelSurcharge = 0.00;
        List<WebElement> lbl_fuelSurcharge = getShadowRootElement(orderTallyShadowRoot).findElements(By.cssSelector("div.fuel-surcharge_container div.value"));
        if(lbl_fuelSurcharge.size() > 0) {
            fuelSurcharge = getUSDFrom(getElementText(lbl_fuelSurcharge.get(0)));
        }
        return fuelSurcharge;
    }

    public void verifyFuelSurchargeDisplayedCorrectlyInOrderTally() {
        Verify.verify(getUSDFrom(PropertyLoader.getValue("global.fuelSurcharge")), getFuelSurcharge());
    }

    public void clickOnFuelSurchargeLink() {
        WebElement lnk_fuelSurcharge = getShadowRootElement(orderTallyShadowRoot).findElement(By.cssSelector("div.fuel-surcharge_container fd-overlay"))
                .findElement(By.cssSelector("a"));
        clickOnElement(lnk_fuelSurcharge);
    }

    public void verifyFuelSurchargeInfoOverlayOpened() {
        WebElement fuelSurcharge= getShadowRootElement(orderTallyShadowRoot).findElement(By.cssSelector("div.fuel-surcharge_container fd-overlay div#storefront-fscharge-container h1"));
        Verify.verify("Fuel Surcharge Details",getElementText(fuelSurcharge));
    }

    public void clickOnCheckoutCrossButton() {
        clickOnElement( btn_checkoutCrossButton);
    }

    public double getSubTotal(){
        WebElement lbl_subtotalAmount = getShadowRootElement(orderTallyShadowRoot).findElement(By.cssSelector("div.subtotal_container > div.value"));
        return getUSDFrom(getElementText(lbl_subtotalAmount));
    }

    public void PromoCodeTypeTypeText(String promoCode) {
        WebElement inp_promoCode = getShadowRootElement( promoCodeShadowRoot).findElement(By.cssSelector("input[title='Promo code']"));
        typeText(inp_promoCode, promoCode);
    }

    public void clickOnPromoCodeApplyButton() {
        WebElement btn_PromoButton = getShadowRootElement(promoCodeShadowRoot).findElement(By.cssSelector("button.apply"));
        holdExecution(1000);
        clickOnElement(btn_PromoButton);
    }

    public void verifyPromoIsDisplayedInOrderTally() {
        WebElement lbl_Promo = getShadowRootElement(orderTallyShadowRoot).findElement(By.cssSelector("div.redemption-promo_container div.title span"));
        Verify.verify("CHECKOUT PROMOTION", getElementText(lbl_Promo));
    }

    public boolean TimeSlotSelected() {
        WebElement shadowRoot1 = getShadowRootElement(container_viewTimeSlotShadowRoot.get(0));
        List<WebElement> timeDetails = shadowRoot1.findElements(By.cssSelector("div.timeslot__preview > div"));
        return timeDetails.size() > 0;
    }

    public void clickViewTimeslots() {
        WebElement shadowRoot1 = getShadowRootElement(container_viewTimeSlotShadowRoot.get(0));
        WebElement btn_viewTimeslot = shadowRoot1.findElement(By.cssSelector("div.timeslot__empty > button"));
        clickOnElement(btn_viewTimeslot);
    }

    public void selectATimeSlotIfAlreadyNotSelected() {
        if(!TimeSlotSelected()) {
            clickViewTimeslots();
            TimeSlotsPopUp timeSlotsPopUp = new TimeSlotsPopUp(driver);
            timeSlotsPopUp.selectActiveTimeSlotByIndex(0);
            holdExecution(1000);
            initElement();
        }
    }
    public boolean isRegularFeeSelected() {
        WebElement regularFee =getShadowRootElement(deliveryFeeShadowRoot).findElement(By.cssSelector("div.delivery_option input#regular"));
        return regularFee.isSelected();
    }

    public double getDeliveryFee() {
        double deliveryFee = 0.00;
        WebElement lbl_deliveryFee = getShadowRootElement(orderTallyShadowRoot).findElement(By.cssSelector("div.delivery-free_container div.value"));
        String fee =getElementText(lbl_deliveryFee);
        if(fee.contains("FREE with DeliveryPass")) {
            deliveryFee = 0.00;
        } else {
            deliveryFee = getUSDFrom(fee);
        }
        return deliveryFee;
    }

    public void verifyRegularFeeForDeliveryInOrderTally() {
        if(isRegularFeeSelected()) {
            Verify.verify(getUSDFrom(PropertyLoader.getValue("global.deliveryCharge")), getDeliveryFee());
        } else
            Verify.assertFail("Regular fee radio button is not selected");
    }


    public double getTaxFor(double amount) {
        double nyTaxPer =getUSDFrom(PropertyLoader.getValue("global.tax.ny"));
        return (amount * nyTaxPer) / 100;
    }

    public double getTotalTax() {
        WebElement totalTax = getShadowRootElement(orderTallyShadowRoot).findElement(By.cssSelector("div.total-tax_container div.value"));
        return getUSDFrom(totalTax.getText());
    }

    public void clickOnContactUsLink() {
        WebElement lnk_contactUs =getShadowRootElement(orderTallyShadowRoot).findElement(By.cssSelector("div.static-content  div.help button.fdfw-link"));
        scrollToView(lnk_contactUs);
        clickOnElement(lnk_contactUs);
        holdExecution(3000);
    }

    public void verifyTaxShouldCountCorrectly(double actualTax){
        double saleTax = getTotalTax();
        Verify.verifyTrue(actualTax + "tax is not mach ",saleTax < actualTax);
    }
}
