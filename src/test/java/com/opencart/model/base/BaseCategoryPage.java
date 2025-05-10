package com.opencart.model.base;

import com.opencart.model.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseCategoryPage extends BasePage<BaseCategoryPage> {
    public BaseCategoryPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickProductImage(String productId) {
        getDriver().findElement(By.cssSelector(".image [href$='product_id=" + productId + "']")).click();
        return new ProductPage(getDriver());
    }


}
