package ag.framework.base;

import ag.framework.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * waitForVisibility will use an explicit wait and pause upto the number of seconds
     * you provide in secondsToWait before failing.
     *
     * @param locator locator from your page object.
     * @return the WebElement you are waiting for.
     */
    protected WebElement waitForVisibility(By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWaitDuration()))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement waitForClickable(By locator){
        return new WebDriverWait(driver,Duration.ofSeconds(ConfigReader.getExplicitWaitDuration()))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected WebElement waitForPresence(By locator){
        return new WebDriverWait(driver,Duration.ofSeconds(ConfigReader.getExplicitWaitDuration()))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    protected boolean waitForInvisibility(By locator){
        return new WebDriverWait(driver,Duration.ofSeconds(ConfigReader.getExplicitWaitDuration()))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    /**
     *
     * @param locator element on the page you intend to type text into.
     * @param text the text you are going to type into this field on the page.
     */
    protected void type(By locator,String text){
        driver.findElement(locator).sendKeys(text);
    }
    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }
    protected boolean isDisplayed(By locator){
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch(TimeoutException e){
            return false;
        }
    }
    protected void selectDropdown(By locator, String visibleText){
        WebElement dropdown = waitForClickable(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
}
