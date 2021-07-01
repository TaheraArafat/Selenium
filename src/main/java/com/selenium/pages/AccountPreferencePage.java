package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPreferencePage extends CommonActions {
    public HeaderArea headerArea;

    public AccountPreferencePage(WebDriver driver) {
        this.driver = driver;
        initElement();
        headerArea = new HeaderArea(driver);
    }

    @FindBy(id = "email_format")
    public WebElement inp_NewEmail;

    @FindBy(name = "repeat_email")
    public WebElement inp_retypeNewEmail;

    @FindBy(xpath = "//form[@fdform='changeUserID-form']/descendant::button")
    public WebElement btn_saveForChangeYourEmail;

    @FindBy(xpath = "//span[@fdform-error='email']")
    public WebElement errorMsg_newEmail;

    @FindBy(xpath = "//span[@fdform-error='repeat_email']")
    public WebElement errorMsg_repeatEmail;

    @FindBy(xpath = "//div[@fdform-error-for='repeat_email']/span")
    public WebElement errorMsg_mismatchEmail;

    @FindBy(xpath = "/html/body/main/div/div[1]")
    public WebElement confirmationMessage;

    @FindBy(id = "password")
    public WebElement inp_newPassword;

    @FindBy(id = "repeat_password")
    public WebElement inp_retypeNewPassword;

    @FindBy(xpath = "//form[@fdform='changePassword-form']/descendant::button")
    public WebElement btn_saveForChangeYourPassword;

    @FindBy(xpath = "//div[@fdform-error-for='password']/descendant::span[@fdform-error='password']")
    public WebElement lbl_lessThanSixCharErrorForPassword;

    @FindBy(xpath = "/html/body/main/div/div[1]")
    public WebElement confirmMessage_Password;

    public String getEmailFromNewEmailField() {
        return getAttributeValue(inp_NewEmail, "value");
    }

    @Step
    public void typeEmailInNewEmailField(String newEmail) {
        clearInputField(inp_NewEmail);
        typeText(inp_NewEmail, newEmail);
    }

    @Step
    public void retypeEmailInNewEmailField(String retypeEmail) {
        clearInputField(inp_retypeNewEmail);
        typeText(inp_retypeNewEmail, retypeEmail);
    }

    @Step
    public void clickOnSaveForChangeYourEmail() {
        clickOnElement(btn_saveForChangeYourEmail);
    }

    @Step
    public void verifyInvalidNewEmailErrorMessage() {
        Verify.verify("Please enter an email address", getElementText(errorMsg_newEmail));
    }

    @Step
    public void verifyInvalidRepeatEmailErrorMessage() {
        Verify.verify("Please enter an email address", getElementText(errorMsg_repeatEmail));
    }

    @Step
    public void verifyMismatchedEmailErrorMessage() {
        Verify.verify("Please enter your email again - it doesn't match what you entered above.",
                getElementText(errorMsg_mismatchEmail));
    }

    @Step
    public void verifyConfirmationMessageForValidEmailAddress() {
        Verify.verify("Your changes have been saved.", getElementText(confirmationMessage));
    }

    @Step
    public void enterNewPassword(String newPassword) {
        typeText(inp_newPassword, newPassword);
    }

    @Step
    public void typePasswordInNewPasswordField(String newPassword) {
        clearInputField(inp_newPassword);
        typeText(inp_newPassword, newPassword);
    }

    @Step
    public void retypePasswordInNewPasswordField(String retypePassword) {
        clearInputField(inp_retypeNewPassword);
        typeText(inp_retypeNewPassword, retypePassword);
    }

    @Step
    public void clickOnSaveForChangeYourPassword() {
        clickOnElement(btn_saveForChangeYourPassword);
    }

    @Step
    public void verifyLessThanSixCharactersPasswordErrorMsg() {
        Verify.verify("Minimum 6 characters", getElementText(lbl_lessThanSixCharErrorForPassword));
    }

    @Step
    public void verifyYourPasswordChangesHaveBeenSaved() {
        Verify.verify("Your changes have been saved.", getElementText( confirmMessage_Password));
    }
}
