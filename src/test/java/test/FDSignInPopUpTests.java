package test;

import com.selenium.configuration.WebDriverConfig;
import com.selenium.popup.FDSignInPopUp;
import org.junit.Test;

public class FDSignInPopUpTests extends WebDriverConfig {
    FDSignInPopUp fdSignInPopUp = new FDSignInPopUp(driver);

    @Test
    public void freshDirectSignIn() throws InterruptedException{
        fdSignInPopUp.hoverOnAccountMenu();
        fdSignInPopUp.clickOnSignInButton();
        fdSignInPopUp.SignInWithEmail("test0421@fd.com");
        fdSignInPopUp.SignInWithPassword();
        fdSignInPopUp.signInForAccount();
        fdSignInPopUp.holdExecution(4000);
    }
}
