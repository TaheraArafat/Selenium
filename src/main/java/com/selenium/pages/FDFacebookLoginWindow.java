package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FDFacebookLoginWindow extends CommonActions {
    public FDFacebookLoginWindow(WebDriver driver) {
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//h2[@id='homelink']")
    public WebElement headerTitle;

    public void verifyFacebookLoginWindowHeaderTitle() {
        Verify.verify("Facebook", getElementText(headerTitle));
    }

    public void verifyFacebookLoginWindowUrl() {
        Verify.verifyCurrentUrlContainsText("https://www.facebook.com/login.php");
    }
}
