package test;

import com.selenium.configuration.PropertyLoader;
import com.selenium.pages.AccountPreferencePage;
import com.selenium.pages.FDHomePage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountPreferenceTests extends TestBase {
    /**
     * verify invalid New Email throws error message
     * Verify Mismatch email address throwing error
     * verify that New Email is saved when click on save button.
     * Verify response when valid password is entered
     * verify invalid password throws error message
     * Verify Mismatch password  throwing error message
     * verify that New Password is saved when click on save button.
     * Verify Display name Can be change
     * Verify that by default  dash and check mark can be selected
     * Verify that Selected option can be saved
     * Verify that Selected option can be cancel
     * when clicked on cancel button
     */
    AccountPreferencePage preferencePage = new AccountPreferencePage(driver);
   // private  static String navigateToAccountPreference="https://fdtest.freshdirect.com/your_account/signin_information.jsp";
     protected static String baseUrl;
    private static final String USER_ID = PropertyLoader.getValue("account.preference.user");

    @BeforeClass
    public static void setupTest() throws InterruptedException {
       signIn(USER_ID);
       // createANewAccount((USER_ID));
    }

    @Before
    public void initAccountPreferenceSetUp(){
       // preferencePage.navigateTo(navigateToAccountPreference);
        baseUrl =System.getProperty("accountPreference.url");
        driver.get(baseUrl);
    }

    @Test
    @DisplayName("Incomplete email error message validation")
    @Epic("Static pages")
    @Feature("Account settings")
    @Story("Account preferences")
    public void incompleteEmailAddressThrowsErrorMessage(){
        //preferencePage.getEmailFromNewEmailField());
        preferencePage.typeEmailInNewEmailField("@test.com");
        preferencePage.retypeEmailInNewEmailField("@test.com");
        preferencePage.clickOnSaveForChangeYourEmail();
        preferencePage.holdExecution(3000);
        preferencePage.verifyInvalidNewEmailErrorMessage();
        preferencePage.verifyInvalidRepeatEmailErrorMessage();
    }

    @Test
    @DisplayName("Mismatched email error message validation")
    @Epic("Static pages")
    @Feature("Account settings")
    @Story("Account preferences")
    public void misMatchedEmailErrorMessageValidation(){
        preferencePage.typeEmailInNewEmailField("test0421@fd.com");
        preferencePage.retypeEmailInNewEmailField("test0400@fd.com");
        preferencePage.clickOnSaveForChangeYourEmail();
        preferencePage.verifyMismatchedEmailErrorMessage();
    }

    @Test
    @DisplayName("verify that New Email is saved when click on save button.")
    @Epic("Static pages")
    @Feature("Account settings")
    @Story("Account preferences")
    public void verifyValidNewEmailAddressCanSaveClickingOnSaveButton() {
        preferencePage.typeEmailInNewEmailField("test0421@fd.com");
        preferencePage.retypeEmailInNewEmailField("test0421@fd.com");
        preferencePage.clickOnSaveForChangeYourEmail();
        preferencePage.verifyConfirmationMessageForValidEmailAddress();
    }

    @Test
    @DisplayName("less than 6 characters password error message validation")
    @Epic("Static pages")
    @Feature("Account settings")
    @Story("Account preferences")
    public void lessThenSixCharactersInPasswordFieldThrowsErrorMessage(){
        preferencePage.typePasswordInNewPasswordField("123");
        preferencePage.retypePasswordInNewPasswordField("123");
        preferencePage.clickOnSaveForChangeYourPassword();
        preferencePage.verifyLessThanSixCharactersPasswordErrorMsg();
    }

    @Test
    @DisplayName("Account password can be changed")
    @Epic("Static pages")
    @Feature("Account settings")
    @Story("Account preferences")
    public void changeAccountPasswordValidation() {
        String password = "test12345";
        preferencePage.enterNewPassword(password);
        preferencePage.retypePasswordInNewPasswordField(password);
        preferencePage.clickOnSaveForChangeYourPassword();
        preferencePage.verifyYourPasswordChangesHaveBeenSaved();
    }
}






