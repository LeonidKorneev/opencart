package com.opencart.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class ProductAppleCinemaPage extends ProductPage {

    @FindBy(id = "button-upload222")
    private WebElement uploadButton;

    @FindBy(css = "#form-upload input[type='file']")
    private WebElement uploadFileViaSelenium;

    @FindBy(className = "alert-info")
    private WebElement minimumProductQuantityMessage;

    public ProductAppleCinemaPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String pathToFile) {
        File file = new File(pathToFile);

        uploadButton.click();
        uploadFileViaSelenium.sendKeys(file.getAbsolutePath());

        getWait5().until(ExpectedConditions.alertIsPresent());
    }

    public String getSuccessfullyUploadedFileAlertMessage() {
        return getDriver().switchTo().alert().getText();
    }

    public String getMinimumAppleCinemaQuantityMessage() {
        return minimumProductQuantityMessage.getText();
    }
}
