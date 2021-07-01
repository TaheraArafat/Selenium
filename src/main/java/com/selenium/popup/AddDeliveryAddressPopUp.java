package com.selenium.popup;

import com.selenium.configuration.CommonActions;
import com.selenium.pages.Verify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddDeliveryAddressPopUp extends CommonActions {
    public AddDeliveryAddressPopUp(WebDriver driver){
        this.driver = driver;
        initElement();
    }
   @FindBy(xpath = "//*[@id=\"dialog_m-delivery-address\"]/div/fd-delivery-address-form")
   public WebElement popUp_addHomeAddressForm;

    public void verifyAddAddressPopupDisplayed(){
      Verify.verifyIfElementIsDisplayed(popUp_addHomeAddressForm);
    }
}
