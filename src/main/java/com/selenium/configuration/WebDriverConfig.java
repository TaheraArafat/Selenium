package com.selenium.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
public class WebDriverConfig implements StepLifecycleListener {

    public static WebDriver driver;
    //private static String navigateToUrl = "https://fdtest.freshdirect.com";
    protected static String baseUrl;
    private Deque<String> names = new LinkedList<>();
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Rule
    public TestWatcher testLogs = new LoggingRule(logger);

    @Rule
    public TestWatcher screenshotTaker = new ScreenShotTaker((TakesScreenshot) driver);

    @Override
    public void beforeStepStart(final StepResult result) {
        names.push(result.getName());
        logger.info(getOffset() + "@Step:" + names.getFirst());
    }

    @Override
    public void afterStepStop(final StepResult result) {
        logger.info(getOffset() + "@Step done " + names.poll());
    }

    private String getOffset() {
        return new String(new char[names.size() == 0 ? 0 : names.size() - 1]).replaceAll("\0", "   ");
    }

    @Rule
    public TestName currentTestName = new TestName();

    public WebDriverConfig() {
    }

    public static void openBrowser() {
        if(PropertyLoader.getValue("browser.default").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver =  new ChromeDriver();
        } else if(PropertyLoader.getValue("browser.default").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }
    }

    @BeforeClass
    public static void initWebDriverSetUp() throws IOException {
        PropertyLoader.loadProperties();
        baseUrl= System.getProperty("app.url");
        openBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.close();
        driver.quit();
    }

}
