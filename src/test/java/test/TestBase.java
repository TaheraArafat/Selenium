package test;

import com.selenium.configuration.WebDriverConfig;
import com.selenium.pages.FDHomePage;

import java.util.Random;

public class TestBase extends WebDriverConfig {

    public static void signIn(String userEmail){
        FDHomePage fdHomePage = new FDHomePage(driver);
        fdHomePage.headerArea.hoverOnAccountMenu();
        fdHomePage.headerArea.fDSignInPopUp.clickOnSignInButton();
        fdHomePage.headerArea.fDSignInPopUp.SignInWithEmail(userEmail);
        fdHomePage.headerArea.fDSignInPopUp.SignInWithPassword();
        fdHomePage.headerArea.fDSignInPopUp.signInForAccount();
    }

    public static String getEmailAddress(){
       Random randomGenerator = new Random();
       int randomInt = randomGenerator.nextInt(10000);
       String getText = "test" + randomInt +"@fd.com";
       return getText;
    }

    public static void createANewAccount(String username) {
        FDHomePage fdHomePage = new FDHomePage(driver);
        fdHomePage.headerArea.clickOnCreateAccountButton();
        fdHomePage.headerArea.fdCreateAccountPopUp.signInWithEmail(username);
        fdHomePage.headerArea.fdCreateAccountPopUp.signInWithPassword();
        fdHomePage.headerArea.fdCreateAccountPopUp.clickOnCreateAccount();

    }

    public static void createANewAccount() {
        createANewAccount(getEmailAddress());
    }

}

