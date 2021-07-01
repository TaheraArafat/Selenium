package test.checkout;

import com.selenium.configuration.PropertyLoader;
import com.selenium.popup.AddDeliveryAddressPopUp;
import com.selenium.pages.PickUpLocationPage;
import com.selenium.pages.CheckoutPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.TestBase;

public class CheckoutAddDeliveryAddressNewUserTests extends TestBase {
    CheckoutPage checkout = new CheckoutPage(driver);
    private static final String USER_ID = PropertyLoader.getValue("checkout.DeliveryAddress.NewUser");
    private  static  String navigateToViewCart="https://fdtest.freshdirect.com/expressco/checkout.jsp";

    /**
     * Add delivery address and pick up your order buttons should display;
     *  Verify Clicking on Add delivery address button opens address Popup;
     *  Verify Clicking on Pickup your order button opens pickup address selector
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
    public void addDeliveryAddressAndPickupButtonsShouldDisplay() {
        checkout.verifyAddDeliveryAddressButtonIsDisplayed();
        checkout.verifyPickupYourOrderButtonIsDisplayed();
    }

    @Test
    public void clickingOnAddDeliveryAddressOpenAddressPopup() {
        checkout.clickOnAddDeliveryAddressButton();
        AddDeliveryAddressPopUp deliveryAddressPopUp = new AddDeliveryAddressPopUp(driver);
        deliveryAddressPopUp.verifyAddAddressPopupDisplayed();
    }

    @Test
    public void pickupOrdersButtonShouldOpenPickupAddress() {
        checkout.clickOnPickupYourOrder();
        PickUpLocationPage pickUpLocationPopUp = new PickUpLocationPage(driver);
        pickUpLocationPopUp.verifyPickupLocationsListIsDisplayed();
    }












}




