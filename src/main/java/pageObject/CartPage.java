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

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkout;

    public void deleteProduct(String deleteProd){
        driver.findElement(By.xpath("//div[text()='" + deleteProd + "']//ancestor::div[@class='cart_item']/div[2]/div[2]/button")).click();
    }
}
