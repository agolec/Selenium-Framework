package ag.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static void waitForElementToBeVisible(WebDriver driver, By locator, int secondsOfWaiting){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondsOfWaiting));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
