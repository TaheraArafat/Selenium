package test.checkout;

import com.selenium.configuration.PropertyLoader;
import com.selenium.pages.CheckoutPage;
import com.selenium.pages.FDViewCartPage;
import com.selenium.pages.Verify;
import com.selenium.popup.ContactUsPopUp;
import com.selenium.popup.TimeSlotsPopUp;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.TestBase;

public class CheckoutOrderTallyTests extends TestBase {
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    FDViewCartPage fdViewCartPage = new FDViewCartPage(driver);
    TimeSlotsPopUp timeSlotsPopUp = new TimeSlotsPopUp(driver);
    private  static  String navigateToViewCart="https://fdtest.freshdirect.com/expressco/checkout.jsp";
    private static final String USER_ID = PropertyLoader.getValue("viewCart.user");
    private static final String  EMPLOYEE_PROMOCARD  =PropertyLoader.getValue("global.validPromoCode");

    @BeforeClass
    public static void setupTest() throws InterruptedException {
        signIn(USER_ID);
    }

    @Before
    public void initViewCartSetUpTest() {
        checkoutPage.navigateTo(navigateToViewCart);
    }

    @Test
    public void subtotalShouldCorrectlyDisplayed() {
        checkoutPage.clickOnCheckoutCrossButton();
        FDViewCartPage fdViewCartPage = new FDViewCartPage(driver);
        double viewCartSubTotal = fdViewCartPage.findAllSubtotalProductAmount();
        System.out.println("SubTotal :" + viewCartSubTotal);
        fdViewCartPage.clickOnTheViewCartCheckOutButton();
        checkoutPage.initElement();
        double checkOutSubTotal = checkoutPage.getSubTotal();
        System.out.println("checkout subtotal :" + checkOutSubTotal);
        Verify.verify("SubTotal are not match ", viewCartSubTotal, checkOutSubTotal);
    }

    @Test
    public void TotalTaxShouldCorrectlyDisplayed() throws InterruptedException{
        checkoutPage.clickOnCheckoutCrossButton();
        FDViewCartPage fdViewCartPage = new FDViewCartPage(driver);
        double viewCartProductsTaxTotal = fdViewCartPage.getTaxPercentageFromTaxAbleItems();
        System.out.println( "tax Amount :"+ viewCartProductsTaxTotal);
        fdViewCartPage.clickOnTheViewCartCheckOutButton();
        checkoutPage.initElement();
        double expectedTax =viewCartProductsTaxTotal + checkoutPage.getTaxFor(checkoutPage.getFuelSurcharge()+ checkoutPage.getDeliveryFee());
        System.out.println("After tax :" + expectedTax);
        checkoutPage.verifyTaxShouldCountCorrectly(expectedTax);

    }

    @Test
    public void promoShouldCorrectlyDisplayed() throws InterruptedException {
        checkoutPage.PromoCodeTypeTypeText(EMPLOYEE_PROMOCARD);
        checkoutPage.clickOnPromoCodeApplyButton();
        checkoutPage.verifyPromoIsDisplayedInOrderTally();

    }

    @Test
    public void tipShouldBeDisplayedCorrectly(){
        int tipAmount = getRandomNumber();
        checkoutPage.selectTipFromDropDownAmount(String.valueOf(tipAmount));
        checkoutPage.verifySelectedTipAmountDisplayedCorrectlyInOrderTally(tipAmount);
    }

    @Test
    public void bottleDepositCanDisplayedCorrectly() {
        checkoutPage.verifyBottleDepositDisplayedCorrectlyInOrderTally();
    }

    @Test
    public void contactUsLinkOpensContactUsOverlay() {
        checkoutPage.clickOnContactUsLink();
        ContactUsPopUp contactUsPopUp = new ContactUsPopUp(driver);
        contactUsPopUp.verifyContactUsPopupIsDisplayed();
    }


    @Test
    public void fuelSurchargeShouldCorrectlyDisplayed() {
        checkoutPage.verifyFuelSurchargeDisplayedCorrectlyInOrderTally();
    }


    @Test
    public void fuelSurchargeLinkOpensFuelSurchargeInfoOverlay() {
        checkoutPage.clickOnFuelSurchargeLink();
        checkoutPage.verifyFuelSurchargeInfoOverlayOpened();
    }

    @Test
    public void deliveryFeeShouldCorrectlyDisplayed() {
        checkoutPage.selectATimeSlotIfAlreadyNotSelected();
        checkoutPage.verifyRegularFeeForDeliveryInOrderTally();
    }


}








