package ag.applications.saucedemo.pages;

import ag.framework.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginErrorMessage = By.cssSelector("div.error-message-container.error > h3");
    
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void enterUserName(String usernameText){
        type(this.username,usernameText);
    }
    public void enterPassword(String passwordText){
        type(this.password,passwordText);
    }
    public void clickLogin(){
        click(this.loginButton);
    }

    public void loginToApplication(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(this.loginErrorMessage);
    }
}
