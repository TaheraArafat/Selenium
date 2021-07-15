package test.checkout;

import com.selenium.configuration.PropertyLoader;
import com.selenium.pages.CheckoutPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.TestBase;

public class CheckoutAddDeliveryAddressExistingUserTests extends TestBase {
    CheckoutPage checkout = new  CheckoutPage (driver);
    private  static  String navigateToViewCart="https://fdtest.freshdirect.com/expressco/checkout.jsp";
    private static final String USER_ID = PropertyLoader.getValue("viewCart.user");

    /**
     * Clicking on delivery address Edit button opens up Deliver To popup ;
     * Express Icon is Displayed for Express Eligible address;
     * Clicking on pick up your order redirect to pick up location;
     */

    @BeforeClass
    public static void setupTest() throws InterruptedException {
        signIn(USER_ID);
    }

    @Before
    public void initViewCartSetUpTest() {
        checkout.navigateTo(navigateToViewCart);
    }

    @Test
    public void clickingOnEditButtonOpensDeliveryAddressPage()throws InterruptedException {
        checkout.clickOnDeliveryAddressEditButton();
        checkout.deliveryAddressPageIsDisplayed();
    }

    @Test
    public  void expressIconDisplayForEligibleExpressAddress() throws InterruptedException {
        checkout.expressIconIsDisplayedInExpressEligibleAddress();
    }

    @Test
    public void clickingOnPickUpYourOrderRedirectToPickUpLocation()throws InterruptedException{
        checkout.clickOnDeliveryAddressEditButton();
        checkout.clickOnHowToPickUpOrder();
        checkout.pickUpLocationPopUp();
    }
}