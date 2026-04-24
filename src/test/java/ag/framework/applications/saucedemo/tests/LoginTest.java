package ag.framework.applications.saucedemo.tests;

import ag.framework.base.BaseTest;
import ag.framework.applications.saucedemo.data.TestDataProvider;
import ag.applications.saucedemo.pages.ProductPage;
import ag.applications.saucedemo.pages.LoginPage;
import ag.applications.saucedemo.data.LoginTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "validLogins",
            dataProviderClass = TestDataProvider.class,
            groups = {"saucedemo","regression","smoke"})
    public void validLoginTest(LoginTestData data){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(data.username,data.password);

        if(data.expectedSuccess){
            ProductPage productPage = new ProductPage(driver);
            Assert.assertTrue(productPage.isInventoryPageDisplayed());
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed());
        }
        ProductPage productPage = new ProductPage(driver);

        Assert.assertTrue(productPage.isInventoryPageDisplayed());
    }
    @Test(dataProvider = "invalidLogins",
            dataProviderClass = TestDataProvider.class,
            groups = {"saucedemo","regression"})
    public void invalidLogins(LoginTestData data){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(data.username, data.password);

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }


}
