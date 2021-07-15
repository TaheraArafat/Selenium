package com.selenium.popup;

import com.selenium.configuration.CommonActions;
import com.selenium.pages.Verify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsPopUp  extends CommonActions {
    public ContactUsPopUp(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//fd-overlay[@id='contact_us_dialog']/div")
    public WebElement popup_contactUs;

    public void verifyContactUsPopupIsDisplayed() {
       Verify.verifyIfElementIsDisplayed(popup_contactUs);
    }

}
