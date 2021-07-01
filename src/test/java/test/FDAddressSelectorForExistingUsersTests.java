package test;

import com.selenium.pages.*;
import com.selenium.popup.FDAddressSelectorPopUp;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FDAddressSelectorForExistingUsersTests extends TestBase {
    /**
     *Verify that clicking on edit link of Delivery Addresses can redirects to delivery address page
     *Verify that new user can add delivery address by clicking on delivery address edit button
     *verify that saved residential address can show residential logo
     *verify that add can be changed
     *Verify that clicking on any option of pickup can re-directed to the delivery address page
     *Verify that clicking on edit button Timeslots  re-directed to the corresponding delivery timeslots page
     *Verify that clicking on ViewTimeslots button can re-directed to the corresponding Available Delivery Timeslots page
     */

    private static FDHomePage fdHomePage;
    FDAddressSelectorPopUp selectorPageForExistingUser;
    DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage(driver);
    DeliveryAddressPage deliveryAddressEditPage;
    TimeSlotsEditPage timeSlotsEditPage;
    ViewTimeSlotsForPage viewTimeSlotsForPage;

    @BeforeClass
    public static void setupAddressSelectorTestForExistingUser() throws InterruptedException {
        signIn("test0421@fd.com");
    }

    @Before
    public void initSetUpTest(){
        fdHomePage = new FDHomePage(driver);
        fdHomePage.navigateToHomePage();
        fdHomePage.headerArea.hoverOnAddressSelector();
        selectorPageForExistingUser = new FDAddressSelectorPopUp(driver);
    }

    @Test
    @DisplayName("clicking On Delivery Address Edit Link Redirect To Jsp")
    @Epic("group")
    @Story("For Existing user")
    @Feature("Delivery Address selector")
    public void clickingOnDeliveryAddressEditLinkRedirectToJsp() throws InterruptedException{
        selectorPageForExistingUser.clickOnEditLinkOfDeliveryAddressForExistingUser();
        deliveryAddressPage.verifyDeliveryInformationPageUrl();
    }

    @Test
    @DisplayName("clicking On TimeSlot Edit Link Redirect To Jsp")
    @Epic("Address selector popup")
    @Story("For Existing user")
    @Feature("Delivery Address selector")
    public void clickingOnTimeSlotEditLinkRedirectToJsp() throws InterruptedException{
        selectorPageForExistingUser.clickOnEditLinkOfTimeSlotsForExistingUser();
        timeSlotsEditPage = new TimeSlotsEditPage(driver);
        timeSlotsEditPage.verifyTimeSlotsEditPageUrl();
    }

    @Test
    @DisplayName("clicking On View TimeSlots Can Redirect To Delivery Info CheckSlots Jsp")
    @Epic("Address selector popup")
    @Story("For Existing user")
    @Feature("Delivery Address selector")
    public void clickingOnViewTimeSlotsCanRedirectToDeliveryInfoCheckSlotsJsp()throws InterruptedException{
        selectorPageForExistingUser.clickOnViewTimeSlotsButton();
        viewTimeSlotsForPage = new ViewTimeSlotsForPage(driver);
        viewTimeSlotsForPage.verifyDeliveryInfoCheckSlotsJsp();
    }

    @Test
    @DisplayName("address Can Be Change")
    @Epic("Address selector popup")
    @Story("For Existing user")
    @Feature("Delivery Address selector")
    public void addressCanBeChange()throws InterruptedException{
        selectorPageForExistingUser.clickOnAnySavedAddressByIndex();
        selectorPageForExistingUser.verifyAddressCanBeChanged();
    }
}
