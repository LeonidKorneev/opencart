package com.opencart.model;

import com.opencart.model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage<ProductPage> {

    @FindBy(tagName = "h1")
    private WebElement productName;

    @FindBy(css = "#product-product .breadcrumb")
    private WebElement productBreadcrumbPath;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductBreadCrumbPath() {
        return productBreadcrumbPath.getText();
    }
}
