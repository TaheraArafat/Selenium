package com.selenium.popup;

import com.selenium.configuration.CommonActions;
import com.selenium.configuration.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FDSignInPopUp extends CommonActions {

    public FDSignInPopUp(WebDriver driver) {
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[2]/div/fd-user/fd-dropdown-menu")
    public WebElement accountMenu;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[2]/div/fd-user/fd-dropdown-menu/div/ul/li[1]/a")
    public WebElement btn_signIn;

    @FindBy(name = "userId")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"sign_in-input--542112152\"]")
    public WebElement sign_inInput;

    @FindBy(xpath = "//*[@id='sign-in-controller']")
    public WebElement popup_signIn;

    public void hoverOnAccountMenu() {
        hoverOnElement(accountMenu);
    }

    public void clickOnSignInButton() {
        clickOnElement(btn_signIn);
    }

    public void SignInWithEmail(String userId) {
        typeText(emailField, userId);
    }

    public void SignInWithPassword(){
        typeText(passwordField, PropertyLoader.getValue("global.validPassword"));
    }

    public void signInForAccount(){
        clickOnElement(sign_inInput);
        holdExecution(5000);
    }


}

