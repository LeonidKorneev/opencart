package com.opencart.model;

import com.opencart.model.base.BaseCategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonitorsSubcategoryPage extends BaseCategoryPage {

    @FindBy(css = ".image [href$='product_id=42']")
    private WebElement appleCinema;

    public MonitorsSubcategoryPage(WebDriver driver) {
        super(driver);
    }

    public ProductAppleCinemaPage clickAppleCinemaImage() {
        appleCinema.click();

        return new ProductAppleCinemaPage(getDriver());
    }
}
