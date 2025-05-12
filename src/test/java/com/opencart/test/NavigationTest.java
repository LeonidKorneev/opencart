package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.base.TestUtils;
import com.opencart.data.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    @Story("Navigation")
    @Description("Verify the Store home page is opened via current URL and the page title")
    public void testStoreHomePageURLAndTitle() {

        final String expectedURL = "https://naveenautomationlabs.com/opencart" + "/";
        final String expextedTitle = "Your Store";

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Assert.assertEquals(actualURL, expectedURL, "Actual URL is different");

        Assert.assertEquals(actualTitle, expextedTitle, "Actual title is different");
    }

    @Test(dataProvider = "withDropdownNavigationData", dataProviderClass = TestData.class)
    @Story("Navigation")
    @Description("TC_02 Verify the Store navigation menu options via dropdown")
    public void testNavigationBarMenuWithDropdown(By navBarMenu, By navBarDropdownMenu, String expextedURL, String expectedTitle) {

        TestUtils.hoverOverAnElement(this, navBarMenu);
        getDriver().findElement(navBarDropdownMenu).click();

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Assert.assertEquals(actualURL, expextedURL, "Actual URL is different");
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is different");
    }

    @Test(dataProvider = "withoutDropdownNavigationData", dataProviderClass = TestData.class)
    @Story("Navigation")
    @Description("TC_03 Verify the Store navigation menu options without dropdown")
    public void testNavigationBarMenuWithoutDropdown(By navBarMenu, String expectedURL, String expectedTitle) {

        getDriver().findElement(navBarMenu).click();

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Assert.assertEquals(actualURL, expectedURL, "Actual URL is different");
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is different");
    }

    @Test(dataProvider = "componentsCategoryNavigationData", dataProviderClass = TestData.class)
    @Story("Navigation")
    @Description("TC_04 Verify the 'Components' category dropdown options navigation")
    public void testComponentsDropdownNavigation(By componentsCategory, By componentsDropdownMenuOption,
                                                 String expectedURL, String expectedTitle) {
        TestUtils.hoverOverAnElement(this, componentsCategory);
        getDriver().findElement(componentsDropdownMenuOption).click();

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Assert.assertEquals(actualURL, expectedURL, "Actual URL is different");
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is different");
    }

}

