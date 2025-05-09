package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.model.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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

        List<String> expectedLoginSidebarOptionsList = List.of("Login", "Register", "Forgotten Password",
                "My Account", "Address Book", "Wish List", "Order History", "Downloads", "Recurring payments",
                "Reward Points", "Returns", "Transactions", "Newsletter");

        Assert.assertEquals(actualSidebarOptionsList, expectedLoginSidebarOptionsList);
    }

}

