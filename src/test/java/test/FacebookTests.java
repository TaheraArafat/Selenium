package test;

import com.selenium.configuration.WebDriverConfig;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FacebookTests extends WebDriverConfig {

    @Test
    public void facebookForgetPasswordTest() throws InterruptedException{
        //click on create account button
        driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
        Thread.sleep(1000);
        Assert.assertEquals("Forgot Password | Can't Log In | Facebook", driver.getTitle());
        Thread.sleep(5000);
    }

    @Test
    public void facebookSignInTest() throws InterruptedException{
        //Login with Email and Password field
        driver.findElement(By.id("email")).sendKeys("sadfdf@gd.com");
        driver.findElement(By.id("pass")).sendKeys("Password");
        driver.findElement(By.name("login")).click();
        System.out.println( driver.findElement(By.xpath("//*[@id=\"email_container\"]/div[2]")).getText());
        //assert mean verify that it is throwing an error message .
        Assert.assertEquals("The email or mobile number you entered isn’t connected to an account. ", driver.findElement(By.xpath("//*[@id=\"email_container\"]/div[2]")).getText());
        Thread.sleep(5000);
    }
}
