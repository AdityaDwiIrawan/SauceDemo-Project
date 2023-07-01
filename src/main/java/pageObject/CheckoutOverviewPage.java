package pageObject;

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


    public double getTotalResult() {
        double subtotal = Double.parseDouble(itemTotal.getText().replaceAll("[^0-9, .]", ""));
        double tax = Double.parseDouble(taxTotal.getText().replaceAll("[^0-9, .]", ""));
        double totalResult = roundAvoid(subtotal + tax, 2);
        return totalResult;
    }

    public double getTotalValue() {
        double totalValue = Double.parseDouble(totalPrice.getText().replaceAll("[^0-9, .]", ""));
        return totalValue;
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
