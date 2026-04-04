package ag.framework.tests.base;

import ag.framework.config.ConfigReader;
import ag.framework.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
