package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.model.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Story("Search field")
    @Description("Verify the search field visibility")
    public void testSearchFieldVisibility() {

        boolean isSearchFieldVisible = new HomePage(getDriver())
                .getHeader().isSearchFieldVisible();

        Assert.assertTrue(isSearchFieldVisible, "The Search field is not visible");
    }

    @Test
    @Story("Search field")
    @Description("Verify the search result page heading")
    public void testSearchResultInPageHeading() {
        final String searchValue = "Samsung";

        String searchPageHeading = new HomePage(getDriver())
                .getHeader().typeInSearchValue(searchValue)
                .clickSearchButton()
                .getPageHeading();

        Assert.assertEquals(searchPageHeading, searchValue);
    }

    @Test
    @Story("Search field")
    @Description("Verify the message when the search term does not match any products")
    public void testMessageForEmptySearchResult() {
        final String searchValue = "Xiaomi";
        final String expectedNoSearchResultMessage = "There is no product that matches the search criteria.";

        String actualNoSearchResultMessage = new HomePage(getDriver())
                .getHeader().typeInSearchValue(searchValue)
                .clickSearchButton()
                .getNoResultMessage();

        Assert.assertEquals(actualNoSearchResultMessage, expectedNoSearchResultMessage);
    }

}
