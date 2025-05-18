package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.data.TestData;
import com.opencart.model.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    @Story("Product page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the opened product name")
    public void testProductName() {

        String actualProductName = new HomePage(getDriver())
                .getTopMenu().hoverOverDesktopsCategory()
                .getTopMenu().openMacSubcategory()
                .clickProductImage("41")
                .getProductName();

        Assert.assertEquals(actualProductName, "iMac");
    }

    @Test(groups = "regression")
    @Story("Product page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the opened product breadcrumb path")
    public void testProductPath() {

        String actualProductName = new HomePage(getDriver())
                .getTopMenu().hoverOverDesktopsCategory()
                .getTopMenu().openMacSubcategory()
                .clickProductImage("41")
                .getProductBreadCrumbPath();

        Assert.assertEquals(actualProductName, "Desktops Mac iMac");
    }

    @Test(groups = "regression")
    @Story("Product page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the Apple Cinema minimal quantity warning message")
    public void testAppleCinemaWarningMessage() {

        String actualAppleCinemaWarningMessage = new HomePage(getDriver())
                .getTopMenu().hoverOverComponentsCategory()
                .getTopMenu().openMonitorsSubcategory()
                .clickAppleCinemaImage()
                .getMinimumAppleCinemaQuantityMessage();

        Assert.assertEquals(actualAppleCinemaWarningMessage, TestData.APPLE_CINEMA_QUANTITY_MESSAGE);
    }
}
