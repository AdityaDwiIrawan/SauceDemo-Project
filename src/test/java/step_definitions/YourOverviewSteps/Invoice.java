package step_definitions.YourOverviewSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.CheckoutOverviewPage;
import step_definitions.Hooks;

import static org.junit.Assert.assertEquals;

public class Invoice {

    public WebDriver webDriver;

    public Invoice() {
        super();
        this.webDriver = Hooks.webDriver;
    }

    @Then("User verify that {string}")
    public void userVerifyThat(String expectedPrice) throws InterruptedException {
        CheckoutOverviewPage informationPage = new CheckoutOverviewPage(webDriver);
        System.out.println(informationPage.getTotalResult());
        assertEquals(expectedPrice, informationPage.getTotalResult());
        Thread.sleep(2000);
    }

    @And("User clicks finish button")
    public void theUserClicksFinishButton() throws InterruptedException {
        CheckoutOverviewPage clickFinish = new CheckoutOverviewPage(webDriver);
        clickFinish.finishBtn.click();
    }

    @And("User verify product {string}")
    public void userVerifyProduct(String verifyProd) throws InterruptedException {
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(webDriver);
        overviewPage.verifyInvoice(verifyProd);
        Thread.sleep(2000);
    }

    @And("User verify inventory item price {string}")
    public void userVerifyInventoryItemPrice(String expectedInventoryItemPrice) {
        CheckoutOverviewPage informationPage = new CheckoutOverviewPage(webDriver);
        System.out.println(informationPage.getPriceBar());
        assertEquals(expectedInventoryItemPrice, informationPage.getPriceBar());
    }

    @Then("User already on overview page")
    public void userAlreadyOnOverviewPage() throws InterruptedException {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(webDriver);
        Assert.assertTrue(checkoutOverviewPage.verifyTitleOverview());
        Thread.sleep(2000);
    }

    @And("User verify tax {string}")
    public void userVerifyTax(String taxCalculate) {
        CheckoutOverviewPage informationPage = new CheckoutOverviewPage(webDriver);
        System.out.println(informationPage.getTotalTax());
        assertEquals(taxCalculate, informationPage.getTotalTax());
    }

    @And("User verify price total {string}")
    public void userVerifyPriceTotal(String expectedItemPrice) {
        CheckoutOverviewPage informationPage = new CheckoutOverviewPage(webDriver);
        System.out.println(informationPage.getItemTotal());
        assertEquals(expectedItemPrice, informationPage.getItemTotal());
    }
}
