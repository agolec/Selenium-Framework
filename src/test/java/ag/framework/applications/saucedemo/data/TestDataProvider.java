package ag.framework.applications.saucedemo.data;

import ag.applications.saucedemo.data.LoginTestData;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "validLogins")
    public Object[][] validLogins() {
        return new Object [][] {
                {new LoginTestData("standard_user", "secret_sauce",true)},
                {new LoginTestData("problem_user","secret_sauce", true)}
        };
    }
    @DataProvider(name = "invalidLogins")
    public static Object[][] invalidLogins(){
        return new Object[][] {
                {new LoginTestData("standard_user","wrongpass",false)},
                {new LoginTestData("standard_user","",false)},
                {new LoginTestData("locked_out_user","secret_sauce",false)},
                {new LoginTestData("","secret_sauce",false)},
                {new LoginTestData("","",false)}
        };
    }
}
