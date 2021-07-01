package com.selenium.popup;

import com.selenium.configuration.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Watchable;

public class FDCreateAccountPopUp extends CommonActions {
    public FDCreateAccountPopUp(WebDriver driver){
        this.driver = driver;
        initElement();
    }
    @FindBy(xpath = "/html/body/div[2]/fd-logo-bar/div/div[2]/div[2]/a")
    public WebElement btn_createAccount;

    @FindBy(id = "user email")
    public WebElement emailField;

    @FindBy(id ="user password")
    public WebElement passwordField;

    @FindBy(css = "input[id='sign_up-input-278621961']")
    public WebElement btn_createAccountPopUp;

    public void clickOnCreateAccountButton() {
        clickOnElement(btn_createAccount);
    }

    public void signInWithEmail(String userId) {
        typeText(emailField, userId);
    }

    public void signInWithPassword() {
        typeText(passwordField,"testing");
    }
    public void clickOnCreateAccount(){
        clickOnElement(btn_createAccountPopUp);
        holdExecution(5000);
    }






}
