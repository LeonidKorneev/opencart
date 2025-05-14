package com.opencart.model;

import com.opencart.model.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AccountPage extends BasePage<AccountPage> {

    @FindBy(tagName = "h2")
    private WebElement accountHeading;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get the account page heading")
    public String getAccountHeading() {
        getWait2().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(accountHeading)));
        return accountHeading.getText();
    }
}
