package com.opencart.base;

import com.opencart.utils.ChromeDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected static final String LINK = "https://naveenautomationlabs.com/opencart";

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = ChromeDriverConfig.getChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(LINK);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

