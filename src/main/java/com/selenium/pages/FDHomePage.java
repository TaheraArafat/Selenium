package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FDHomePage extends CommonActions {
    public HeaderArea headerArea;
    public  FooterArea footerArea;
    public FDHomePage(WebDriver driver) {
        this.driver = driver;
        initElement();
        headerArea = new HeaderArea(driver);
        footerArea = new FooterArea(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/fd-logo-bar/div/div[2]/div[2]/a")
    public WebElement btn_createAccount;

    @FindBy(xpath ="/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[2]/div/fd-user/fd-dropdown-menu")
    public WebElement accountMenu;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[2]/div/fd-user/fd-dropdown-menu/div/ul/li[1]/a")
    public WebElement btn_signIn;

    @FindBy(xpath = "//*[@id='sign-in-forms-container']")
    public WebElement popup_createAccount;

    @FindBy(xpath = "//*[@id='sign-in-controller']")
    public WebElement popup_signIn;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/button")
    public WebElement fd_Icon;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu/div/div/div[2]/button")
    public WebElement btn_addDeliveryAddress;

    @FindBy(xpath = "//*[@id='sign_up-input-278621961']")
    public WebElement deliveryCreateAccount;

    @FindBy(name = "email" )
    public WebElement fieldEmail;

    @FindBy(name = "password")
    public WebElement fieldPassword;

    @FindBy(xpath = "//*[@id='form-error-container-2133072658']/div/div/a")
    public WebElement popup_deliveryCreateAccount;

    @FindBy(xpath = "//fd-tabs[@id='sign-in-container']/descendant::iframe[@title='Login with Social Networks'][1]")
    public WebElement iframe_socialLogin;

    @FindBy(id = "button_facebook")
    public  WebElement btn_facebook;

    @FindBy(xpath = "//*[@id=\"sign_in-input--542112152\"]")
    public WebElement sign_inInput;

    @FindBy(name = "userId")
    public WebElement emailField;

    @FindBy(name ="password" )
    public WebElement passwordField;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div")
    public WebElement popup_addressSelectorForExistingUser;

    @FindBy(xpath = "//*[@id=\"sec_avocado_deviled_eggs\"]/div/div[2]/div/a")
    public WebElement link_viewAll;

    @Step
    public void navigateToHomePage() {
        navigateTo("https://fdtest.freshdirect.com/");
    }


    public void clickOnCreateAccountButton() {
        clickOnElement(btn_createAccount);
    }

    public void hoverOnAccountMenu() {
        hoverOnElement(accountMenu);
    }

    public void hoverOnAccountMenuForExistingUser(){
        hoverOnElement(popup_addressSelectorForExistingUser);
    }

    public void clickOnSignInButton() {
        clickOnElement(btn_signIn);
    }

    public void verifyCreateAccountPopupIsDisplayed() {
        Verify.verifyIfElementIsDisplayed(popup_createAccount);
    }

    public void verifySignInPopupIsDisplayed() {
        Verify.verifyIfElementIsDisplayed(popup_signIn);
    }

    public void hoverOnFdIcon(){
        hoverOnElement(fd_Icon);
    }

    public void clickOnAddDeliveryAddress(){
        clickOnElement(btn_addDeliveryAddress);
    }

    public void enterEmailAddressField(){
        typeText(fieldEmail,"abc@gmail.com");
    }

    public void enterPasswordField(){
        typeText(fieldPassword,"Password");
    }

    public void clickOnDeliveryCreateAccount(){
        clickOnElement(deliveryCreateAccount);
    }

    public void verifyPopupDeliveryCreateAccountIsDisplayed() {
        Verify.verifyIfElementIsDisplayed(popup_deliveryCreateAccount);
    }

    public void switchToSocialLoginFrame() {
        switchToAnIframe(iframe_socialLogin);
    }

    public void clickOnSignInWithFacebook(){
        clickOnElement((btn_facebook));
    }

    public void signInForAccount(){
        clickOnElement(sign_inInput);
    }
    public void SignInWithEmail(String userId){
        typeText(emailField, userId);
    }
    public void SignInWithPassword(){
        typeText(passwordField,"testing");
    }
    public void clickOnViewAllLink(){
        clickOnElement(link_viewAll);
    }



}
