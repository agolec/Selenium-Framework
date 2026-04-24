package ag.applications.saucedemo.pages;

import ag.framework.ui.base.BasePage;
import ag.applications.saucedemo.enums.SortOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

//Handles UI Interaction
// UI ===> Product conversion
public class ProductPage extends BasePage {
    private By inventoryContainer = By.id("inventory_container");
    private By sortProductsDropdown = By.className("product_sort_container");
    private By productCards = By.className("inventory_item");
    private By productName = By.cssSelector(".inventory_item_name");
    private By productPrice = By.cssSelector(".inventory_item_price");

    public ProductPage(WebDriver driver){
        super(driver);
    }
    //Interface between Selenium and my test logic.
    public void sortBy(SortOption option){
        selectDropdown(this.sortProductsDropdown,option.getLabel());
    }
    //extract products off page.
    public List<Product> getProducts(){

        List<WebElement> cards = driver.findElements(this.productCards);
        List<Product> products = new ArrayList<>();

        for(WebElement card: cards){
            String name = card.findElement(productName).getText();

            String priceText = card.findElement(productPrice).getText();
            Double price = new Double(priceText.replace("$",""));

            products.add(new Product(name,price));
        }
        return products;
    }
    public boolean isInventoryPageDisplayed(){
        return isDisplayed(inventoryContainer);
    }
}
