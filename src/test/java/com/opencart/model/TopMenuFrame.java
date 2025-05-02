package com.opencart.model;

import com.opencart.model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuFrame<T extends BasePage<T>> extends BasePage<T> {

    @FindBy(linkText = "Tablets")
    private WebElement tabletsLink;

    @FindBy(linkText = "Desktops")
    private WebElement desktopsLink;

    @FindBy(css = "[href$='20_27']")
    private WebElement macSubcategoryLink;

    @FindBy(linkText = "Components")
    private WebElement componentsLink;

    @FindBy(css = "[href&='25_28']")
    private WebElement monitorSubcategoryLink;

    public TopMenuFrame(WebDriver driver, T returnPage) {
        super(driver);
    }

}
