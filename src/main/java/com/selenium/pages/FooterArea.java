package com.selenium.pages;

import com.selenium.configuration.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class
FooterArea extends CommonActions {
    public FooterArea(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = " //footer[@id='mainfooter']/descendant::div[@class='footer-links']/a")
    private List<WebElement> link_footer;

    public void clickOnFooterLinkByIndex(int index){
        clickOnElement(link_footer.get(index));
    }
}
