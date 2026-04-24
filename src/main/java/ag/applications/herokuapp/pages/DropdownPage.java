package ag.applications.herokuapp.pages;

import ag.framework.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    private By dropdown = By.id("dropdown");
    public DropdownPage(WebDriver driver) {
        super(driver);
    }
    //using the driver from BasePage here for Selenium specific constructs that do not map
    //cleanly to a single reusable helper.

    // TODO: 4/24/2026 put these methods into BasePage as reusable when multiple tests begin to use them
    public String getDefaultSelectedText(){
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }
    public void getSelectedOptionByVisibleText(String option){
        System.out.println("Selecting option: " + option);
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(option);
    }
}
