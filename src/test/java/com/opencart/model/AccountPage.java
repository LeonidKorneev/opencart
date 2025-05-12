package com.opencart.model;

import com.opencart.model.base.BasePage;
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

    public String getAccountHeading() {
        getWait2().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(accountHeading)));
        return accountHeading.getText();
    }
}
