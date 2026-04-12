package ag.framework.tests.base;

import ag.framework.config.ConfigReader;
import ag.framework.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    //Whenever you set up groups in your tests,
    //you must always use the alwaysRun = true inside your
    //lifecycle methods. (i.e. BeforeMethod, AfterMethod)
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = DriverFactory.createDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
