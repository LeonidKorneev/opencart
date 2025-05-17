package com.opencart.model;

import com.opencart.model.base.BasePage;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage<CartPage> {

    @FindBy(css = ".table-bordered [class$='left'] [href*='product_id']")
    private WebElement addedItemName;

    @FindBy(css = "[name^='quantity']")
    private WebElement addedItemQuantity;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getAddedItemName() {
        try {
            getWait2().until(ExpectedConditions.visibilityOf(addedItemName));
            return addedItemName.getText();
        } catch (UnhandledAlertException e) {
            handleAlertIfPresent();

            getWait2().until(ExpectedConditions.visibilityOf(addedItemName));
            return addedItemName.getText();
        }
    }

    public String getAddedGoodsQuantity() {
        try {
            getWait5().until(ExpectedConditions.visibilityOf(addedItemQuantity));
            return addedItemQuantity.getAttribute("value");
        } catch (UnhandledAlertException e) {
            handleAlertIfPresent();

            getWait5().until(ExpectedConditions.visibilityOf(addedItemQuantity));
            return addedItemQuantity.getAttribute("value");

        }
    }
}
