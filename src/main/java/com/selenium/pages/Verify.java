package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Verify extends CommonActions {
    public static void verifyIfElementIsDisplayed(WebElement element) {
        Assert.assertTrue(element + " is not displayed", element.isDisplayed());
    }

    public static void verifyCurrentUrlContainsText(String url) {
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    public static void verify(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }

    public static void verify(String message, String expected, String actual) {
        Assert.assertEquals(message, expected, actual);
    }

    public static void verify(int expected, int actual) {
        Assert.assertEquals(expected, actual);
    }

    public static void verify(double expected, double actual) {
        Assert.assertEquals(expected, actual, 2);
    }

    public static void verify(boolean condition) {
        Assert.assertTrue(condition);
    }

    public static void fail(String message){
        Assert.fail(message);
    }



}


