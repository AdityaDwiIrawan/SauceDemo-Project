package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

    public static WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    public WebElement totalPrice;

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishBtn;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement itemTotal;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    public WebElement taxTotal;

    public void verifyInvoice(String invoiceProduct){
        driver.findElement(By.xpath("//div[text()='" + invoiceProduct + "']//ancestor::div[@class='cart_item']/div[2]/a/div")).isDisplayed();
    }
}
