package com.opencart.base;

import com.opencart.utils.ChromeDriverConfig;
import com.opencart.utils.EdgeDriverConfig;
import com.opencart.utils.FireFoxDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public abstract class BaseTest {

    private final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    protected static final String LINK = "https://naveenautomationlabs.com/opencart";

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        WebDriver driver = createDriver(browser);
        threadLocalDriver.set(driver);
        getDriver().get(LINK);
    }

    private WebDriver createDriver(String browser) {
        return switch (browser.toLowerCase()) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = FireFoxDriverConfig.getFirefoxOptions();
                yield new FirefoxDriver(options);
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = EdgeDriverConfig.getEdgeOptions();
                yield new EdgeDriver(options);
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = ChromeDriverConfig.getChromeOptions();
                yield new ChromeDriver(options);
            }
        };
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            threadLocalDriver.remove();
        }
    }

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }
}
