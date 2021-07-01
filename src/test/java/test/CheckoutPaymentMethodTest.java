package test;


import com.selenium.configuration.PropertyLoader;
import com.selenium.pages.CheckoutPage;
import com.selenium.pages.CheckoutPaypalPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckoutPaymentMethodTest extends TestBase {
    CheckoutPage checkoutPage = new CheckoutPage (driver);
    CheckoutPaypalPage checkoutPaypalPage = new CheckoutPaypalPage(driver);
    private static String navigateToCheckout = "https://fdtest.freshdirect.com/expressco/checkout.jsp";
    private static final String USER_ID = PropertyLoader.getValue("viewCart.user");

    /** clicking on Add payment method can open Payment method Popup.
     * clicking on paypal button open a new window.
     * clicking on Add Debit credit Card button open Welcome to Click to Pay popup window
     */

    @BeforeClass
    public static void setupTest() throws InterruptedException {
        signIn(USER_ID);
    }
    @Before
    public void initCheckoutSetUpTest(){
        checkoutPage.navigateTo(navigateToCheckout);
    }

    @Test
    public void clickingOnAddPaymentMethodCanOpenPaymentMethodPopUp(){
        checkoutPage.clickOnAddPaymentMethod();
        checkoutPage.verifyAddPaymentMethodButton();
        checkoutPage.addPaymentMethodIsDisplayed();
    }
    @Test
    public void clickingOnPayPalCanOpenPayWithPayPalWindow()throws InterruptedException{
        checkoutPage.clickOnPayPalButton();
        checkoutPage.verifyPaypalButtonIsDisplayed();
        checkoutPage.switchToPaypalWindow();
        checkoutPaypalPage.payPalPopUpWindowIsDisplayed();
    }

    @Test
    public void clickOnMasterPassButttOnCanRedirectToPAyWithMasterpass(){
        checkoutPage.clickOnPayWithCreditDebitCardButton();
        checkoutPage.switchToAddDebitCreditCardWindow();
        checkoutPage.PayWithMasterPassIsDisplayed();
    }

}