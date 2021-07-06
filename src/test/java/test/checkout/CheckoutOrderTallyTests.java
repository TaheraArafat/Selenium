package test.checkout;

import com.selenium.configuration.PropertyLoader;
import com.selenium.pages.CheckoutPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.TestBase;

public class CheckoutOrderTallyTests extends TestBase {
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    private  static  String navigateToViewCart="https://fdtest.freshdirect.com/expressco/checkout.jsp";
    private static final String USER_ID = PropertyLoader.getValue("viewCart.user");

    @BeforeClass
    public static void setupTest() throws InterruptedException {
        signIn(USER_ID);
    }

    @Before
    public void initViewCartSetUpTest() {
        checkoutPage.navigateTo(navigateToViewCart);
    }

    @Test
    public void tipShouldBeDisplayedCorrectly() {
        int tipAmount = getRandomNumber();
        checkoutPage.selectTipFromDropDownAmount(String.valueOf(tipAmount));
        checkoutPage.verifySelectedTipAmountDisplayedCorrectlyInOrderTally(tipAmount);
    }

    @Test
    public void bottleDepositCanDisplayedCorrectly() {
        checkoutPage.verifyBottleDepositDisplayedCorrectlyInOrderTally();
    }



}








