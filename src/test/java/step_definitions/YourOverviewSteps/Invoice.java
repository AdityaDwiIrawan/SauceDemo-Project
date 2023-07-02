package step_definitions.YourOverviewSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.CheckoutOverviewPage;
import pageObject.YourInformationPage;
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
//        String priceText = informationPage.itemTotal.getText();
//        Double pt = Double.parseDouble(priceText);
//        String taxText = informationPage.taxTotal.getText();
//        Double tt = Double.parseDouble(taxText);
////        String totalText = informationPage.totalPrice.getText();
////        Double tText = Double.parseDouble(totalText);
//
//        Double tText = pt + tt;
//        Double a = Double.parseDouble(tText.toString());

        System.out.println(informationPage.getTotalResult());
        assertEquals(expectedPrice, informationPage.getTotalResult());
        Thread.sleep(2000);
    }

    @And("User clicks finish button")
    public void theUserClicksFinishButton() throws InterruptedException {
        CheckoutOverviewPage clickFinish = new CheckoutOverviewPage(webDriver);
        clickFinish.finishBtn.click();
        Thread.sleep(2000);
    }

    @And("User verify product {string}")
    public void userVerifyProduct(String verifyProd) throws InterruptedException {
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(webDriver);
        overviewPage.verifyInvoice(verifyProd);
        Thread.sleep(2000);
    }

    @And("User verify price total {string}")
    public void userVerifyPriceTotal(String expectedItemPrice) throws InterruptedException {
        CheckoutOverviewPage informationPage = new CheckoutOverviewPage(webDriver);
        System.out.println(informationPage.itemTotal.getText());
        assertEquals(expectedItemPrice, informationPage.itemTotal.getText());
        Thread.sleep(2000);
    }

    @Then("User already on overview page")
    public void userAlreadyOnOverviewPage() throws InterruptedException {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(webDriver);
        Assert.assertTrue(checkoutOverviewPage.verifyTitleOverview());
        Thread.sleep(2000);
    }

    @And("User verify tax {string}")
    public void userVerifyTax(String taxCalculate) throws InterruptedException {
        CheckoutOverviewPage informationPage = new CheckoutOverviewPage(webDriver);
        System.out.println(informationPage.getTotalTax());
        assertEquals(taxCalculate, informationPage.getTotalTax());
        Thread.sleep(2000);
    }
}
