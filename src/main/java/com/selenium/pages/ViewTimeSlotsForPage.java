package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ViewTimeSlotsForPage extends CommonActions {
    public ViewTimeSlotsForPage(WebDriver driver){
        this.driver =driver;
        initElement();
    }
    @Step
    public void verifyDeliveryInfoCheckSlotsJsp(){
        Verify.verifyCurrentUrlContainsText("/help/delivery_info_check_slots.jsp");
    }
}
