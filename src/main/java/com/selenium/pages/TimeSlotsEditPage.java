package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TimeSlotsEditPage extends CommonActions {
    public TimeSlotsEditPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    public void verifyTimeSlotsEditPageUrl(){
        Verify.verifyCurrentUrlContainsText("/help/delivery_info.jsp");
    }
}
