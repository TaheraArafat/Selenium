package com.selenium.popup;

import com.selenium.configuration.CommonActions;
import com.selenium.pages.Verify;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class FDAddressSelectorPopUp extends CommonActions {
    public FDAddressSelectorPopUp(WebDriver driver) {
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div")
    public WebElement popup_addressSelector;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[5]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[1]/a")
    public WebElement link_editButton;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[2]/button")
    public WebElement link_addDeliveryAddress;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[1]/ul/li[2]/span/span/a")
    public WebElement link_aboutDelivery;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[1]/ul/li[3]/span/span/a")
    public WebElement link_availableTimeslots;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[1]/ul/li[1]/span/span/a")
    public WebElement link_deliveryPass;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[2]/div[1]/span[1]")
    public WebElement zipCode;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[2]/div[1]/button")
    public WebElement btn_change;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[1]/a")
    public WebElement link_editOfDeliveryAddress;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[2]/a")
    public WebElement link_editOfTimeSlots;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[3]/a")
    public WebElement btn_viewTimeSlots;

    @FindBy(xpath = "//form[@id='fddeliveryaddress']/div[@class='address-line-wrapper']")
    public List<WebElement> addressList;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[5]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/button/span[2]")
    public WebElement address_Locationbar;

    public void verifyAddressSelectorPopupIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popup_addressSelector);
    }

    public void clickOnTheEditButton(){
        clickOnElement(link_editButton);
    }

    public void verifyClickingOnEditButtonCanRedirectToDeliveryAddressPage(){
        Verify.verifyCurrentUrlContainsText("https://fdtest.freshdirect.com/your_account/delivery_information.jsp");
    }
    public void clickOnAddDeliveryAddress(){
        clickOnElement(link_addDeliveryAddress);
    }

    public void clickOnAboutDelivery(){
        clickOnElement(link_aboutDelivery);
    }

    @Step
    public void clickOnAvailableTimeslots(){
        clickOnElement(link_availableTimeslots);
    }

    @Step
    public void clickOnADeliveryPass(){
        clickOnElement(link_deliveryPass);
    }

    public void clickOnChangeButton(){
        clickOnElement(btn_change);
    }

    public void verifySignInPageTitle(){
        Verify.verify("FreshDirect - Sign Up", getTitle());
    }

    public void clickingOnAboutDeliveryOpensDeliveryInfoPageTitle(){
        Verify.verify("Delivery Information | FreshDirect",getTitle());
    }

    @Step
    public void clickingOnAvailableTimeSlotsOpenAvailableDeliveryTimeslotsPage(){
        Verify.verify("Available Delivery Timeslots | FreshDirect",getTitle());
    }

    @Step
    public void clickingOnDeliveryPassLinkOpensDeliveryPassPage(){
        Verify.verify("Free Grocery Delivery | FreshDirect DeliveryPass",getTitle());
    }
    public void verifyZipCodeIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(zipCode);
    }

    @Step
    public void clickOnEditLinkOfDeliveryAddressForExistingUser(){
        clickOnElement(link_editOfDeliveryAddress);
    }

    @Step
    public void clickOnEditLinkOfTimeSlotsForExistingUser(){
        clickOnElement(link_editOfTimeSlots);
        holdExecution(1000);
    }

    @Step
    public void clickOnViewTimeSlotsButton(){
        clickOnElement(btn_viewTimeSlots);
    }

    public String getAddressListByIndex(int index){
        return getElementText(addressList.get(index));
    }

    @Step
    public void clickOnAnySavedAddressByIndex(){
        clickOnElement(addressList.get(1));
    }

    @Step
    public void verifyAddressCanBeChanged(){
        Verify.verifyIfElementIsDisplayed(address_Locationbar);
    }

}
