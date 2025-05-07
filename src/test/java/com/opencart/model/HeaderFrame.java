package com.opencart.model;

import com.opencart.model.base.BaseFrame;
import com.opencart.model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFrame <T extends BasePage<T>> extends BaseFrame<T> {

    @FindBy(name = "search")
    private WebElement searchField;

    @FindBy(css = "[class$='search']")
    private WebElement searchButton;

    @FindBy(css = "[title='Shopping Cart']")
    private WebElement cartButton;

    @FindBy(css = "[title='My Account']")
    private WebElement myAccountButton;

    @FindBy(css = "li [href$='account/login']")
    private WebElement loginPageButton;

    public HeaderFrame(WebDriver driver, T returnPage) {
        super(driver, returnPage);
    }

    public boolean isSearchFieldVisible() {
       return searchField.isDisplayed();
    }

    public HeaderFrame<T> typeInSearchValue(String value) {
        searchField.sendKeys(value);

        return this;
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();

        return new SearchResultPage(getDriver());
    }

    public T clickMyAccountButton() {
        myAccountButton.click();

        return getReturnPage();
    }

    public LoginPage clickLoginPageButton() {
        loginPageButton.click();

        return new LoginPage(getDriver());
    }

}
