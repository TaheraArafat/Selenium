package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPaypalPage extends CommonActions {
    public CheckoutPaypalPage(WebDriver driver) {
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath  =" //div[@id='main']")
    public WebElement window_Paypal;

    public void payPalPopUpWindowIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(window_Paypal);

    }
}
