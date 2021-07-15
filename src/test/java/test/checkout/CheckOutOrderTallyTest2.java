package test.checkout;

import com.selenium.configuration.PropertyLoader;
import com.selenium.pages.CheckoutPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.TestBase;

public class CheckOutOrderTallyTest2 extends TestBase {

    CheckoutPage checkoutPage = new CheckoutPage(driver);
    private static String navigateToCheckout = "https://fdtest.freshdirect.com/expressco/checkout.jsp";
    private static final String USER_ID = PropertyLoader.getValue("viewCart.user");

    @BeforeClass
    public static void setupTest() throws InterruptedException {
        signIn(USER_ID);
    }

    @Before
    public void initCheckoutSetUpTest(){
        checkoutPage.navigateTo(navigateToCheckout);
    }

    @Test
    public void verifyTipTextIsDisplayed(){
        checkoutPage.verifyTipText();
    }

    @Test
    public void verifyTipAmountCanBeSelected(){
        checkoutPage.clickOnTipAmountField();
        checkoutPage.selectAnAmount();
        checkoutPage.verifyTipAmountIsSelected();
    }

    @Test
    public void verifyCustomTipAmountCanBeSelectedFromTipSelectorDropDown(){
        checkoutPage.clickOnTipAmountField();
        checkoutPage.selectOtherAmount();
        checkoutPage.enterAnyTipAmount();
        checkoutPage.verifyOtherAmountIsSelected();
    }

    @Test
    public void verifyToolTipCanBeOpenedByHoveringOnTheInfoIcon(){
        checkoutPage.hoverOnTipInfoIcon();
        checkoutPage.verifyToolTipIsDisplaying();
    }

    @Test
    public void verifyMaxTipAmountCanNotExceedOrderSubtotal(){
        checkoutPage.clickOnTipAmountField();
        checkoutPage.selectOtherAmount();
        checkoutPage.enterTip();
        checkoutPage.verifyMaxTipIsNotMoreThanSubTotal();
    }
}
