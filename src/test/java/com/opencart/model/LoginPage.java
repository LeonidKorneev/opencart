package com.opencart.model;

import com.opencart.model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(css = "[value='Login']")
    private WebElement loginButton;

    @FindBy(className = "list-group-item")
    private List<WebElement> loginSidebarOptions;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterLoginData() {
        emailField.sendKeys("abanabmbajh@yandex.ru");
        passwordField.sendKeys("hsdkjhfgkjsdgfs");

        return this;
    }

    public AccountPage clickLoginButton() {
        loginButton.click();
        return new AccountPage(getDriver());
    }

    public List<String> getSidebarMenuOptions() {
        return loginSidebarOptions.stream()
                .map(WebElement::getText)
                .toList();
    }
}
