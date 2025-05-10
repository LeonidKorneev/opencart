package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.model.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void testProductName() {

        String actualProductName = new HomePage(getDriver())
                .getTopMenu().hoverOverDesktopsCategory()
                .getTopMenu().openMacSubcategory()
                .clickProductImage("41")
                .getProductName();

        Assert.assertEquals(actualProductName, "iMac");
    }

    @Test
    public void testProductPath() {

        String actualProductName = new HomePage(getDriver())
                .getTopMenu().hoverOverDesktopsCategory()
                .getTopMenu().openMacSubcategory()
                .clickProductImage("41")
                .getProductBreadCrumbPath();

        Assert.assertEquals(actualProductName, "Desktops Mac iMac");
    }

    @Test
    public void testAppleCinemaWarningMessage() {

        String actualAppleCinemaWarningMessage = new HomePage(getDriver())
                .getTopMenu().hoverOverComponentsCategory()
                .getTopMenu().openMonitorsSubcategory()
                .clickAppleCinemaImage()
                .getMinimumAppleCinemaQuantityMessage();

        Assert.assertEquals(actualAppleCinemaWarningMessage, "This product has a minimum quantity of 2");
    }
}
