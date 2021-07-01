package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PickUpLocationPage extends CommonActions {
    public PickUpLocationPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }
    @FindBy(xpath = "/html/body/div[2]/fd-checkout/div/div[2]")
    public WebElement popup_pickUpLocation;

    public void verifyPickupLocationsListIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popup_pickUpLocation);
    }

}
