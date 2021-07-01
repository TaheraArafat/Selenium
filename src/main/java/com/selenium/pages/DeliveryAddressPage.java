package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DeliveryAddressPage extends CommonActions {
    public DeliveryAddressPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @Step
    public void verifyDeliveryInformationPageUrl(){
        Verify.verifyCurrentUrlContainsText("/your_account/delivery_information.jsp");
    }

}
