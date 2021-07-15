package com.selenium.popup;

import com.selenium.configuration.CommonActions;
import com.selenium.pages.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TimeSlotsPopUp extends CommonActions {
    public TimeSlotsPopUp(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(css = "fd-checkout-timeslot")
    public List<WebElement> container_viewTimeSlotShadowRoot;

    public String selectActiveTimeSlotByIndex(int index) {
        WebElement parentRoot = getShadowRootElement(container_viewTimeSlotShadowRoot.get(0)).findElement(By.tagName("fd-timeslot-selector"));
        WebElement timeSlotSelector = getShadowRootElement(parentRoot);
        List<WebElement> timeSlots = timeSlotSelector.findElements(By.cssSelector("div.fd-timeslot-selector-calendar > div.group > div.day > div.day-slots > div[class='slot']:not([sold-out='']):not([class*=slot--empty]) > label > div > span.slot-date"));
        String selectedTime = "";
        if (timeSlots.size() > index) {
            selectedTime = getElementText(timeSlots.get(index));
            clickOnElement(timeSlots.get(index));
            holdExecution(1750);
        } else {
            Verify.verifyTrue("Not timeslot available", false);
        }
        return selectedTime;
    }
}
