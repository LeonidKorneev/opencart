package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.model.HomePage;
import com.opencart.model.ProductAppleCinemaPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadingTest extends BaseTest {

    @Test(groups = "regression")
    @Story("Product page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the successful file uploading on the Apple Cinema page")

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
