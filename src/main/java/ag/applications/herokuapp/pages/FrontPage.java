package ag.applications.herokuapp.pages;

import ag.framework.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrontPage extends BasePage {

    private By dropDown = By.cssSelector("a[href='/dropdown']");
    public FrontPage(WebDriver driver) {
        super(driver);
    }
    public void clickDropdownLink(){
        System.out.println("clicking dropdown link in Heroku app.");
        click(this.dropDown);
    }
}
