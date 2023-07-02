package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;

public class CheckoutOverviewPage {

    public static WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class='title']")
    public WebElement title;

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishBtn;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement itemTotal;

    public void verifyInvoice(String invoiceProduct) {
        driver.findElement(By.xpath("//div[text()='" + invoiceProduct + "']//ancestor::div[@class='cart_item']/div[2]/a/div")).isDisplayed();
    }

    public boolean verifyTitleOverview() {
        return title.isDisplayed();
    }

    public String getTotalTax() {
        double subtotal = Double.parseDouble(itemTotal.getText().replaceAll("[^0-9, .]", ""));
        double taxrate = 0.08;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double taxAmounts = subtotal * taxrate;
        return String.valueOf("Tax: $" + decimalFormat.format(taxAmounts));
    }


    public String getTotalResult() {
        double subtotal = Double.parseDouble(itemTotal.getText().replaceAll("[^0-9, .]", ""));
        double tax = Double.parseDouble(getTotalTax().replaceAll("[^0-9, .]", ""));
        double totalResult = roundAvoid(subtotal + tax, 2);
        return String.valueOf("Total: $" + totalResult);
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
