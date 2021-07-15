package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import com.sun.xml.internal.ws.api.server.SDDocument;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

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

    public static void verify(String message,double expected, double actual) {
        Assert.assertEquals(message, expected, actual, 2);
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

    public static void  verifyTrue(String message, boolean condition) {
        assertTrue(message, condition);
    }
    public static void assertFail(String message) {
        fail(message);
    }
}


