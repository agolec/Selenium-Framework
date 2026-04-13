package ag.framework.driver;

import ag.framework.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver createDriver() {

        boolean isHeadless = Boolean.parseBoolean(
                System.getProperty("headless","false")
        );

        String browser = ConfigReader.getProperty("browser");

        WebDriver driver;

        switch(browser.toLowerCase()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                if (isHeadless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");

                    // Needed in the Docker/Jenkins container
                    String binaryPath = System.getProperty("chrome.binary");

                    //branch for setting binary path for jenkins runs.
                    if(binaryPath != null && !binaryPath.isEmpty()) {
                        options.setBinary(binaryPath);
                    }
                }
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("unsupported browser");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println("running headless: " + isHeadless);

        if(!isHeadless){
            driver.manage().window().maximize();
        }
        return driver;
    }
}
