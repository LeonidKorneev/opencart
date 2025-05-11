package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.model.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.opencart.data.TestData.expectedLoginSidebarOptionsList;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        String actualHeading = new HomePage(getDriver())
                .getHeader().clickMyAccountButton()
                .getHeader().clickLoginPageButton()
                .enterLoginData()
                .clickLoginButton()
                .getAccountHeading();

        Assert.assertEquals(actualHeading, "My Account");
    }

    @Test
    public void testSidebarMenuOptions() {

        List<String> actualSidebarOptionsList = new HomePage(getDriver())
                .getHeader().clickMyAccountButton()
                .getHeader().clickLoginPageButton()
                .getSidebarMenuOptions();


        Assert.assertEquals(actualSidebarOptionsList, expectedLoginSidebarOptionsList);
    }

}

