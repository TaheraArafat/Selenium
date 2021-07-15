package com.selenium.configuration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonActions {
    public static WebDriver driver;

    public void initElement() {
        PageFactory.initElements(driver,this);
    }

    protected void clickOnElement(WebElement elementToClick) {
        elementHighlighter(elementToClick);
        elementToClick.click();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void typeText(WebElement element, String text) {
        elementHighlighter(element);
        element.sendKeys(text);
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected void hoverOnElement(WebElement elementToHover) {
        elementHighlighter(elementToHover);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).build().perform();
    }

    public void holdExecution(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    protected String getElementText(WebElement element) {
        elementHighlighter(element);
        return element.getText();
    }

    public void switchWindow(int windowIndex, boolean closeCurrentWindow) {
        Set<String> availableWindows = driver.getWindowHandles();
        List<String> windowsList = new ArrayList<>(availableWindows);
        //System.out.println("\t\n"+windowsList.size()+"\t\n");
        if (closeCurrentWindow && windowsList.size() > 1)
            driver.close();
        if (windowIndex < windowsList.size()) {
            driver.switchTo().window(windowsList.get(windowIndex));
        }
    }

    protected void switchToAnIframe(WebElement iframe) {
        elementHighlighter(iframe);
        driver.switchTo().frame(iframe);
    }

    protected void switchBackToDefaultIframe() {
        driver.switchTo().defaultContent();
    }

    protected void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    protected void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getDefaultValueFromADropdown(WebElement element) {
        elementHighlighter(element);
        Select select = new Select(element);
        WebElement option = select.getFirstSelectedOption();
        return option.getText();
    }

    protected void selectDropdownOptionByIndex(WebElement element, int index) {
        elementHighlighter(element);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    protected void selectDropdownOptionByIndex(WebElement element, String index) {
        elementHighlighter(element);
        Select select = new Select(element);
        select.selectByValue(index);
    }

    protected void selectDropdownOptionByValue(WebElement element,String value) {
        elementHighlighter(element);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    protected void selectDropdownOptionByVisibleText(WebElement element, String Text) {
        elementHighlighter(element);
        Select select= new Select(element);
        select.selectByVisibleText(Text);
    }

    protected void datePicker() {

    }

    protected int getSizeFromList(List<WebElement> list){
        return list.size();
    }

    protected void waitForElementToBeDisplayed(WebElement element, long timeInSeconds) {
        elementHighlighter(element);
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeDisappear(WebElement element, long timeInSeconds) {
        elementHighlighter(element);
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element, long timeInSeconds) {
        elementHighlighter(element);
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void elementHighlighter(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: #FFFF00');", element);
    }

    public String getAttributeValue(WebElement element, String attributeName){
        return element.getAttribute(attributeName);
    }

    public WebElement getShadowRootElement(WebElement element) {
        elementHighlighter(element);
        return (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot",element);
    }

    public double getUSDFrom(String givenString) {
        return getDoubleFrom(givenString, "[0-9]+.[0-9]+");
    }

    public double getDoubleFrom(String givenString, String pattern) {
        double value = 0.0;
        Matcher matcher = Pattern.compile(pattern).matcher(givenString);
        if (matcher.find()) {
            value = Double.parseDouble(matcher.group(0));
        }
        return value;
    }

    public void clearInputField(WebElement element){
        element.clear();
    }

//    public WebElement getShadowRootElement(WebElement element) {
//        WebElement ele = (WebElement) ((JavascriptExecutor)driver)
//                .executeScript("return arguments[0].shadowRoot", element);
//        return ele;
//    }

}
