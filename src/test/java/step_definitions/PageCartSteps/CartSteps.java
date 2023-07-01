package step_definitions.PageCartSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.CartPage;
import pageObject.LoginPage;
import pageObject.YourInformationPage;
import step_definitions.Hooks;

public class CartSteps {
    public WebDriver webDriver;

    public CartSteps() {
        super();
        this.webDriver = Hooks.webDriver;
    }

    @When("User sort product list by {string}")
    public void selectProductSort(String sort) throws InterruptedException {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.selectProductFilter(sort);
//        Thread.sleep(2000);
    }

    @And("User select item product {string} and {string}")
    public void userSelectItemProductAnd(String onesie, String allthings) throws InterruptedException {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.addProduct(onesie);
        cartPage.addProduct(allthings);
//        Thread.sleep(2000);
    }

    @And("User open cart button")
    public void theUserOpenCartButton() throws InterruptedException {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.basket.click();
//        Thread.sleep(2000);
    }

    @And("User click checkout button")
    public void userClickCheckoutButton() throws InterruptedException {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.checkout.click();
//        Thread.sleep(2000);
    }


    //NEGATIVE
    @Given("User on login page")
    public void userOnLoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.verifyLandingPage());
    }

    @When("User input {string} as UserName and input {string} as Password")
    public void userInputAsUserNameAndInputAsPassword(String userName, String passWord) throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginInput(userName, passWord);
        loginPage.clickLogin();
    }

    @Then("User already on product page")
    public void userAlreadyOnProductPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.verifyDshboard());
    }

    @And("User select item product {string}")
    public void userSelectItemProduct(String allthings) {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.addProduct(allthings);
    }
    @And("User click cart button")
    public void userClickCartButton(){
        CartPage cartPage = new CartPage(webDriver);
        cartPage.basket.click();
    }

//    @And("User click checkout button with empty prodcut")
//    public void userClickCheckoutButtonWithEmptyProdcut() throws InterruptedException {
//
//        boolean expectedResult = cart.verifyProductAvailable();
//        boolean actualResult = cart.verifyProductList();
//        Assert.assertEquals(expectedResult, actualResult);
////        Thread.sleep(2000);
//    }

    @Then("User already on checkout information")
    public void userAlreadyOnCheckoutInformation() {
        YourInformationPage pageInfo = new YourInformationPage(webDriver);
        Assert.assertTrue(pageInfo.verifyDshboardInfo());
    }
}