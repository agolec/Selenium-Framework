package ag.framework.tests;

import ag.framework.tests.base.BaseTest;
import ag.framework.pages.ProductPage;
import ag.framework.pages.LoginPage;
import ag.framework.utils.LoginTestData;
import ag.framework.tests.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "validLogins",
            dataProviderClass = TestDataProvider.class,
            groups = {"regression","smoke"})
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
            groups = {"regression"})
    public void invalidLogins(LoginTestData data){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(data.username, data.password);

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }


}
