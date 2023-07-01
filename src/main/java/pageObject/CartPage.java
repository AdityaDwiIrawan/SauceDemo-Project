package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    public static WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='cart_item']")
    private WebElement productQuantity;

    @FindBy(xpath = "//div[@class='cart_list']")
    private WebElement productList;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectFilter;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement productHeader;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement basket;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkout;

    public boolean verifyProductAvailable(){
        return productQuantity.isDisplayed();
    }

    public boolean verifyProductList(){
        return productList.isDisplayed();
    }

    public void selectProductFilter(String sort) {
        Select a = new Select(selectFilter);
        a.selectByVisibleText(sort);
    }

    public void addProduct(String productName){
        driver.findElement(By.xpath("//div[text()='"+productName+"']//ancestor::div[@class='inventory_item']/div[2]/div[2]/button")).click();
    }
}
