package test;

import com.selenium.configuration.WebDriverConfig;
import com.selenium.pages.FDFacebookLoginWindow;
import com.selenium.pages.FDHomePage;
import com.selenium.pages.HeaderArea;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class HeaderAreaTest extends WebDriverConfig {
    public static HeaderArea headerArea = new HeaderArea(driver);

    /**
     * verify Address Selector Popup can Opens by Hovering on it.
     * verify Account Menu Popup can Opens by Hovering On it.
     * verify Fd Cart Count can be Click able.
     * Verify create Account Popup is displayed .
     * Verify department Popup is displayed by clicking on it.
     * Verify search field take input.
     * Verify FD logo  can redirect to the Fd page.
     */

    @Before
    public void initAddressSelectorSetUpTest() {
        FDHomePage fdHomePage = new FDHomePage(driver);
        fdHomePage.navigateToHomePage();
    }

    @Test
    public void verifyAddressSelectorPopupOpensHoveringOnIt() throws InterruptedException {
        headerArea.hoverOnAddressSelector();
        headerArea.verifyPopUpAddressSelectorIsDisplayed();
    }

    @Test
    public void verifyAccountMenuPopupOpensHoveringOnIt() throws InterruptedException {
        headerArea.hoverOnAccountMenu();
        headerArea.verifyPopUpAccountMenuIsDisplayed();
        headerArea.holdExecution(3000);
    }

    @Test
    public void verifyCartCountIsClickAble() throws InterruptedException {
        headerArea.clickOnCartIcon();
        headerArea.verifyRedirectToTheCartJspPage();
        headerArea.holdExecution(2000);
    }

    @Test
    public void VerifyPopUpIsDisplayedByClickingOnCreateAccountButton() {
        headerArea.clickOnCreateAccountButton();
        headerArea.verifyCreateAccountPopUpIsDisplayed();
        headerArea.holdExecution(3000);
    }

    @Test
    public void verifyClickOnFdLogoCanRedirect() throws InterruptedException {
        headerArea.clickOnFreshDirectLogo();
        headerArea.verifyClickOnFdLogoRedirectPage();
        headerArea.holdExecution(3000);
    }

    @Test
    public void verifyClickingOnAnyProductsRedirectToProductJspPage() throws InterruptedException {
        headerArea.clickOnAnyProductsButton();
        headerArea.verifyProductRedirectToJspPage();
        headerArea.holdExecution(3000);
    }

    @Test
    public void verifyDepartmentPopup() throws InterruptedException {
        int index = 0;
        String departmentName = headerArea.getProductDepartmentNameByIndex(index);
        System.out.println(departmentName);
        headerArea.hoverOnAnItemDepartmentLinkByIndex(index);
        headerArea.holdExecution(2000);
        String departmentNameOnPopup = headerArea.getOpenedPopupDepartmentNameByIndex(0);
        System.out.println(departmentNameOnPopup);
        headerArea.verifyTextMatched(departmentName.equalsIgnoreCase(departmentNameOnPopup), "String is not Equal");
    }

    @Test
    public void VerifyAnItemCanBeSearch() throws InterruptedException {
        headerArea.clickOnSearchButton();
        headerArea.typeItemNameOnSearchField("Meat");
        headerArea.clickOnFdSearchIcon();
        headerArea.holdExecution(3000);
        headerArea.verifySearchingForAnItemRedirectToSearchjspPage();
    }
//    @Test
//    public void freshDirectLoginWithFacebook()  throws InterruptedException{
//       headerArea.hoverOnAccountMenu();
//        headerArea.clickOnSignInButton();
//        headerArea.holdExecution(5000);
//        headerArea.switchToSocialLoginFrame();
//        headerArea.clickOnSignInWithFacebook();
//        try {
//            headerArea.switchWindow(1,false);
//            FDFacebookLoginWindow fdFacebookLoginWindow = new FDFacebookLoginWindow(driver);
//            fdFacebookLoginWindow.verifyFacebookLoginWindowHeaderTitle();
//            fdFacebookLoginWindow.verifyFacebookLoginWindowUrl();
//        } finally {
//            headerArea.switchWindow(0,true);
//        }

//    @Test
//    public void testDataBase(){
//
//        // Create a variable for the connection string.
//      String connectionUrl = "jdbc:sqlserver://ARAFATWINDOWS//SQLEXPRESS:1433;databaseName=test;user=hashe;password=arafat";
//
//    try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
//        String SQL = "SELECT  * FROM Worker";
//        ResultSet rs = stmt.executeQuery(SQL);
//
//        // Iterate through the data in the result set and display it.
//        while (rs.next()) {
//            System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
//        }
//    }
//    // Handle any errors that may have occurred.
//    catch (SQLException e) {
//        e.printStackTrace();
//    }
////
}
