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

    @And("User click checkout button")
    public void userClickCheckoutButton() throws InterruptedException {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.checkout.click();
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
    public void userAlreadyOnProductPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.verifyDshboard());
    }

    @Then("User already on checkout information")
    public void userAlreadyOnCheckoutInformation() throws InterruptedException {
        YourInformationPage pageInfo = new YourInformationPage(webDriver);
        Assert.assertTrue(pageInfo.verifyDshboardInfo());
    }

    @And("User delete product {string}")
    public void userDeleteProduct(String deleteProduk) throws InterruptedException {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.deleteProduct(deleteProduk);
        Thread.sleep(2000);
    }

    @Then("User already on cart page")
    public void userAlreadyOnCartPage() {
        CartPage cartPage = new CartPage(webDriver);
        Assert.assertTrue(cartPage.verifyLinkCart());
    }
}