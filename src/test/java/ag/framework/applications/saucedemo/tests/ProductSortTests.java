package ag.framework.applications.saucedemo.tests;

import ag.framework.base.BaseTest;
import ag.applications.saucedemo.enums.SortOption;
import ag.applications.saucedemo.pages.LoginPage;
import ag.applications.saucedemo.pages.Product;
import ag.applications.saucedemo.pages.ProductPage;
import ag.framework.applications.saucedemo.data.SortingTestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ProductSortTests extends BaseTest {

    @Test(dataProvider = "sortOptions",
            dataProviderClass = SortingTestDataProvider.class,
    groups={"saucedemo","regression"})
    public void products_shouldSortCorrectly(SortOption option) {

        // 1. Login (you cannot skip this in SauceDemo)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);

        Assert.assertTrue(productPage.isInventoryPageDisplayed(), "Inventory page did not load");

        // 2. Capture BEFORE state
        List<Product> before = productPage.getProducts();
        System.out.println("Before sort: " + before);

        // 3. Perform action
        productPage.sortBy(option);
        System.out.println("Sorting by: " + option);

        // 4. Capture AFTER state
        List<Product> after = productPage.getProducts();
        System.out.println("After sort: " + after);

        // 5. Build EXPECTED result
        List<Product> expected = new ArrayList<>(before);
        expected.sort(option.getComparator());
        System.out.println("Expected: " + expected);

        // 6. Assertion
        Assert.assertEquals(after, expected, "Products are not sorted correctly for: " + option);
    }
}