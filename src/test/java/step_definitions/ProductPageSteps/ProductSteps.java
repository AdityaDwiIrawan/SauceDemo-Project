package step_definitions.ProductPageSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.ProductPage;
import step_definitions.Hooks;

public class ProductSteps {

    public WebDriver webDriver;

    public ProductSteps() {
        super();
        this.webDriver = Hooks.webDriver;
    }


    @When("User sort product list by {string}")
    public void userSortProductListBy(String filter) throws InterruptedException {
        ProductPage productPage = new ProductPage(webDriver);
        productPage.selectProductFilter(filter);
        Thread.sleep(2000);
    }

    @And("User select item product {string} and {string}")
    public void userSelectItemProductAnd(String onesie, String allthings) throws InterruptedException {
        ProductPage productPage = new ProductPage(webDriver);
        productPage.addProduct(onesie);
        productPage.addProduct(allthings);
        Thread.sleep(2000);
    }

    @And("User click cart button")
    public void theUserClickCartButton() throws InterruptedException {
        ProductPage productPage = new ProductPage(webDriver);
        productPage.basket.click();
        Thread.sleep(2000);
    }

    @And("User select item product {string}")
    public void userSelectItemProduct(String allthings) throws InterruptedException {
        ProductPage productPage = new ProductPage(webDriver);
        productPage.addProduct(allthings);
        Thread.sleep(2000);
    }

    @And("User click cart button")
    public void userClickCartButton() throws InterruptedException {
        ProductPage productPage = new ProductPage(webDriver);
        productPage.basket.click();
        Thread.sleep(2000);
    }
}
