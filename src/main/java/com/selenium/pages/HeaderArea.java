package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import com.selenium.popup.FDAddressSelectorPopUp;
import com.selenium.popup.FDCreateAccountPopUp;
import com.selenium.popup.FDSignInPopUp;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderArea extends CommonActions {
    public FDCreateAccountPopUp fdCreateAccountPopUp;
    public FDAddressSelectorPopUp fdAddressSelectorPopUp;
    public FDSignInPopUp fDSignInPopUp;

    public HeaderArea(WebDriver driver) {
        this.driver = driver;
        initElement();
        fdAddressSelectorPopUp = new FDAddressSelectorPopUp(driver);
        fDSignInPopUp = new FDSignInPopUp(driver);
        fdCreateAccountPopUp= new FDCreateAccountPopUp(driver);
    }

    @FindBy(xpath = "//div[@class='static_header']/descendant::input[@name='searchParams'][2]")
    public WebElement inp_search;

    @FindBy(xpath = "/html/body/div[2]/fd-logo-bar/div/div[1]/div/fd-search-input/form/button/fd-icon")
    public WebElement fd_searchIcon;

    @FindBy(xpath = "//fd-timeslot-delivery/fd-dropdown-menu")
    public WebElement btn_addressSelector;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[1]/div/fd-timeslot-delivery/fd-dropdown-menu")
    public WebElement popUp_AddressSelector;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[2]/div/fd-user/fd-dropdown-menu")
    public WebElement accountMenu;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[2]/div/fd-user/fd-dropdown-menu")
    public WebElement popUp_AccountMenu;

    @FindBy(xpath = "/html/body/div[2]/div/fd-locationbar/div[3]/div/div[4]/ul/li[3]/div")
    public WebElement btn_viewCart;

    @FindBy(xpath = "//div[@class='fd-logo-bar-container']/descendant::fd-logo")
    public WebElement logo_freshDirect;

    @FindBy(xpath = "//div[@class='static_header']/fd-globalnav-department[@class='fd-department-bar-superdepartment']/descendant::a[contains(@class,'fdfw-department-link')]")
    public List<WebElement> link_departmentItems;

    @FindBy(xpath = "//fd-globalnav-department[@superdepartment]//descendant::fd-dropdown-menu[@class='active']/descendant::div[@class='header-block']/descendant::h3[@class='column-heading']")
    public List<WebElement> popUp_LinkDepartmentItems;

    @FindBy(xpath = "/html/body/div[2]/fd-globalnav-department/fd-department-bar/fd-dropdown-menu[1]")
    public WebElement popup_PreparedFoods;

    @FindBy(xpath = "/html/body/div[2]/fd-logo-bar/div/div[2]/div[2]/a")
    public WebElement btn_createAccount;

    @FindBy(xpath = "//*[@id=\"sign-in-forms-container\"]")
    public WebElement popup_createAccount;

    @Step
    public void hoverOnAddressSelector(){
        hoverOnElement(btn_addressSelector);
        holdExecution(2500);
    }

    public void hoverOnAccountMenu() {
        hoverOnElement(accountMenu);
    }

    public void enterTextOnSearchField(String text) {
        typeText(inp_search, text);
    }

    public void verifyPopUpAddressSelectorIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popUp_AccountMenu);
    }

    public void verifyPopUpAccountMenuIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popUp_AccountMenu);
    }

    public void clickOnCartIcon(){
        clickOnElement(btn_viewCart);
    }

    public void hoverOnAnItemDepartmentLinkByIndex(int index){
        hoverOnElement(link_departmentItems.get(index));
    }
    public String getProductDepartmentNameByIndex(int index){
        return getElementText(link_departmentItems.get(index));
    }

    public String getOpenedPopupDepartmentNameByIndex(int index) {
        return getElementText(popUp_LinkDepartmentItems.get(index));
    }

    public void verifyRedirectToTheCartJspPage(){
        Verify.verifyCurrentUrlContainsText("https://fdtest.freshdirect.com/expressco/view_cart.jsp");
    }

    public void verifyPreparedFoodPopUpIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popup_PreparedFoods);
    }

    public void clickOnFreshDirectLogo(){
        clickOnElement(logo_freshDirect);
    }

    public void verifyClickOnFdLogoRedirectPage(){
        Verify.verifyCurrentUrlContainsText("https://fdtest.freshdirect.com/");
    }

    public void clickOnCreateAccountButton(){
        clickOnElement(btn_createAccount);
    }

    public void verifyCreateAccountPopUpIsDisplayed(){
        Verify.verifyIfElementIsDisplayed(popup_createAccount);
    }

    public void clickOnAnyProductsButton(){
        clickOnElement(link_departmentItems.get(0));
    }

    public void verifyProductRedirectToJspPage(){
        Verify.verifyCurrentUrlContainsText("https://fdtest.freshdirect.com/browse.jsp");
    }

    public void clickOnSearchButton(){
        clickOnElement(inp_search);
    }

    public void typeItemNameOnSearchField(String itemName){
        typeText(inp_search, itemName);
    }

    public void clickOnFdSearchIcon(){
        clickOnElement(fd_searchIcon);
    }

    public void verifySearchingForAnItemRedirectToSearchjspPage(){
        Verify.verifyCurrentUrlContainsText("https://fdtest.freshdirect.com/srch.jsp");
    }

    public void verifyTextMatched(boolean condition, String message) {
        if(!condition) {
            Verify.fail(message);
        }
    }

}
