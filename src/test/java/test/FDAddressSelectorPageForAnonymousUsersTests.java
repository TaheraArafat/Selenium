package test;

import com.selenium.configuration.WebDriverConfig;
import com.selenium.popup.FDAddressSelectorPopUp;
import com.selenium.pages.FDHomePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

public class FDAddressSelectorPageForAnonymousUsersTests extends WebDriverConfig {
    /**
     *Verify that address selector popup opens by hovering on address selector field
     * verify clicking on add Delivery Address PopUp opens up Sign in page
     * verify click on About Delivery Link opens Delivery Information Page
     * verify clicking on Available time slots link opens  available Delivery Timeslots for for different Address
     * verify clicking on DeliveryPass link opens Delivery Pass Page
     * Verify Zip Code Is Displayed.
     */

    FDAddressSelectorPopUp selectorPage = new FDAddressSelectorPopUp(driver);

    @Before
    public void initAddressSelectorSetUpTest() {
        FDHomePage fdHomePage = new FDHomePage(driver);
        fdHomePage.navigateToHomePage();
        fdHomePage.headerArea.hoverOnAddressSelector();
    }

    @Test
    public void verifyAddressSelectorPopupOpensByHoveringOnIt() throws InterruptedException{
        selectorPage.verifyAddressSelectorPopupIsDisplayed();
        selectorPage.holdExecution(3000);
    }

    @Test
    public void clickingOnAddDeliveryAddressPopUpOpensSignInPage() throws InterruptedException{
        selectorPage.clickOnAddDeliveryAddress();
        selectorPage.verifySignInPageTitle();
        selectorPage.holdExecution(2000);

    }

    @Test
    public void clickingAboutDeliveryLinkPopUpOpensDeliveryInfoPage() throws InterruptedException{
        selectorPage.clickOnAboutDelivery();
        selectorPage.clickingOnAboutDeliveryOpensDeliveryInfoPageTitle();
        selectorPage.holdExecution(3000);

    }

    @Test
    @DisplayName("Clicking on timeslots open delivery timeslots")
    @Epic("group")
    @Story("Sub-group")
    @Feature("Feature")
    public void  clickingOnAvailableTimeSlotSOpensAvailableDeliveryTimeslots() throws InterruptedException{
        selectorPage.clickOnAvailableTimeslots();
        selectorPage.clickingOnAvailableTimeSlotsOpenAvailableDeliveryTimeslotsPage();
        selectorPage.holdExecution(3000);

    }

    @Test
    @DisplayName("Clicking on delivery pass link open delivery pass page")
    @Epic("group")
    @Story("Sub-group")
    @Feature("Feature")
    public void clickingOnDeliveryPassLinkOpensDeliveryPassPage()throws InterruptedException{
        selectorPage.clickOnADeliveryPass();
        selectorPage.clickingOnDeliveryPassLinkOpensDeliveryPassPage();
        selectorPage.holdExecution(3000);
    }

    @Test
    public void VerifyDeliveryPopUpZipCodeIsDisplayed()throws InterruptedException{
        selectorPage.verifyZipCodeIsDisplayed();
        selectorPage.holdExecution(2000);

    }
    @Test
    public void VerifyZChangButtonCanBeClickAble()throws InterruptedException{
        selectorPage.clickOnChangeButton();
        selectorPage.holdExecution(3000);
    }



}
