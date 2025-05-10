package com.opencart.test;

import com.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void testStoreHomePageURLAndTitle() {

        final String expectedURL = "https://naveenautomationlabs.com/opencart" + "/";
        final String expextedTitle = "Your Store";

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Assert.assertEquals(actualURL, expectedURL, "Actual URL is different");

        Assert.assertEquals(actualTitle, expextedTitle,"Actual title is different");
    }


}
