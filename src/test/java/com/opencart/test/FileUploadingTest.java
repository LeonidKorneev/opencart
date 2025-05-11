package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.model.HomePage;
import com.opencart.model.ProductAppleCinemaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadingTest extends BaseTest {

    @Test
    public void testAppleCinemaFileUploading() {

        new HomePage(getDriver())
                .getTopMenu().hoverOverComponentsCategory()
                .getTopMenu().openMonitorsSubcategory()
                .clickAppleCinemaImage()
                .uploadFile("src/test/resources/toTestUploading.txt");

        Assert.assertEquals(new ProductAppleCinemaPage(getDriver()).getSuccessfullyUploadedFileAlertMessage(),
                "Your file was successfully uploaded!");
    }
}
