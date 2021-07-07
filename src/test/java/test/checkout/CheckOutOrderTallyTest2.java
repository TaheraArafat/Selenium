package test.checkout;

import com.selenium.configuration.PropertyLoader;
import com.selenium.pages.CheckoutPage;
import com.selenium.pages.FDViewCartPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.TestBase;

public class CheckOutOrderTallyTest extends TestBase {

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
    public void verifyOtherAmountCanBeSelected(){
        checkoutPage.clickOnTipAmountField();
        checkoutPage.selectOtherAmount();
        System.out.println("selectOtherAmount");
        checkoutPage.initElement();
        System.out.println("holdExecution");
        checkoutPage.enterAnyTipAmount();
        System.out.println("enterAnyTipAmount");
        checkoutPage.clickOnTip();
        checkoutPage.verifyOtherAmountIsSelected();
        System.out.println("verifyOtherAmountIsSelected");
    }
}
