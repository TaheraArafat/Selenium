package test;

import com.selenium.configuration.PropertyLoader;
import com.selenium.pages.FDHomePage;
import com.selenium.pages.FDViewCartPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FDViewCartPageTests extends TestBase {
    FDViewCartPage cartPage = new FDViewCartPage(driver);
    private static String navigateToViewCart= "https://fdtest.freshdirect.com/expressco/view_cart.jsp";

    /**
     * verify product quantity can be increased
     * verify product quantity can be decreased
     * verify cart can be emptied
     * verify increasing quantity also increase the subtotal
     * verify decreasing quantity also decrease the subtotal
     * verify clicking on a product link redirects to PDP
     * verify a product can be deleted
     * verify clicking on Free link opens 60 days free trial popup
     * Residential: verify order minimum warning message for less than minimum cart total ($30)
     * Corporate: verify order minimum warning message for less than minimum cart total ($50) - optional
     * Verify clicking on Checkout button opens checkout page
     */
    private static FDHomePage fdHomePage;
    private static final String USER_ID = PropertyLoader.getValue("viewCart.user");

    @BeforeClass
    public static void setupTest() throws InterruptedException {
        signIn(USER_ID);
       // homePage.hoverOnAccountMenu();
       // homePage.clickOnSignInButton();
       // homePage.SignInWithEmail("test0421@fd.com");
       // homePage.SignInWithEmail("hashe@test.com");
        //homePage.SignInWithPassword();
        //homePage.signInForAccount();
        //homePage.holdExecution(3000);
    }

    @Before
    public void initViewCartSetUpTest() {
        cartPage.navigateTo(navigateToViewCart);
    }

    @Test
    public void verifyQuantityCanBeIncreased() {
        int increaseBy = 2;
        int currentValue = cartPage.getItemQtyDropdownValue(0);
        cartPage.changeQuantityValue(0, currentValue + increaseBy);
        int afterValue = cartPage.getItemQtyDropdownValue(0);
        cartPage.verifyQuantityIsIncreased(increaseBy , currentValue, afterValue);
        cartPage.holdExecution(5000);
    }

    @Test
    public void verifyQuantityCanBeDecreased() {
       int decreaseBy =1;
       int currentValue = cartPage.getItemQtyDropdownValue(0);
       cartPage.changeQuantityValue(0, currentValue - decreaseBy);
       int afterValue = cartPage.getItemQtyDropdownValue(0);
       cartPage.verifyQuantityIsDecreased(decreaseBy , currentValue, afterValue);
       cartPage.holdExecution(5000);
    }

    @Test
    public void verifyClickingOnEmptyCartOpensEmptyCartConfirmPopup(){
        cartPage.clickOncEmptyCartButton();
        cartPage.verifyCartEmptyConfirmDisplayed();
        cartPage.holdExecution(2000);
    }

    @Test
    public void verifyIncreaseSubtotal(){
        cartPage.changeQuantityValue(0, 3);
        int currentValue = cartPage.getItemQtyDropdownValue(0);
        cartPage.holdExecution(2000);
        double initialPrice = cartPage.findInitSubtotalForEachProduct(0);
        int increaseBy = 1;
        cartPage.changeQuantityValue(0,  currentValue + increaseBy);
        double afterPrice = cartPage.findInitSubtotalForEachProduct(0);
        cartPage.holdExecution(2000);
        cartPage.verifyPriceChangedWithQuantityIncrease( 0, initialPrice < afterPrice);
    }

    @Test
    public void verifyDecreaseSubtotal(){
        int setQuantity = 7;
        int decreaseTo = 2;
        cartPage.changeQuantityValue(0, setQuantity);
        cartPage.holdExecution(2000);
        double initialPrice = cartPage.findInitSubtotalForEachProduct(0);
        double unitPrice = initialPrice / 7;
        int QuantityChange = setQuantity - decreaseTo;
        double totalChange = unitPrice * QuantityChange;
        cartPage.changeQuantityValue(0,  decreaseTo);
        cartPage.holdExecution(2000);
        double expectedTotal = initialPrice - totalChange;
        cartPage.verifyPriceChangedWithQuantityDecrease(0, expectedTotal);
    }

    @Test
    public void verifyClickInProductLinkRedirectToPDP(){
        cartPage.clickOnAnItemLink(0);
        cartPage.verifyRedirectToTheProductPdpPage();
        cartPage.holdExecution(2000);
    }

    @Test
    public void verifyProductCanBeDeleted(){
        int startCount = cartPage.getProductCount();
        cartPage.clickOnDeleteButton(0);
        int endCount = cartPage.getProductCount();
        cartPage.verifyProductIsDeleted(startCount - 1, endCount);
    }

    @Test
    public void verifyClickingOnFreeLinkOpensFreeTrialPopUp(){
        cartPage.clickOnFreeButtonLink();
        cartPage.verifyFreeDeliveryPopupIsDisplayed();
        cartPage.holdExecution(2000);
    }

    @Test
    public void verifyOrderMinimumWarningMessageForLessThanMinimumCartTotal(){
        double miniMunCartPrice = 30.00;
        cartPage.changeQuantityValue(0, 2);
        cartPage.holdExecution(2500);
        double currentSubTotal = cartPage.findAllSubtotalProductAmount();
        while(currentSubTotal < miniMunCartPrice){
            int currentValue = cartPage.getItemQtyDropdownValue(0);
            cartPage.changeQuantityValue(0, currentValue +1);
            int afterValue = cartPage.getItemQtyDropdownValue(0);
            cartPage.holdExecution(2500);
            currentSubTotal = cartPage.findAllSubtotalProductAmount();
            System.out.println("currentSubtotal "+ currentSubTotal);
        }

    }

    @Test
    public void VerifyClickingOnCheckoutButtonOpensCheckoutPage(){
        cartPage.clickOnCheckoutButton();
        cartPage.verifyClickingOnCheckoutButtonCanOpenCheckoutPage();
        cartPage.holdExecution(2000);
    }
}