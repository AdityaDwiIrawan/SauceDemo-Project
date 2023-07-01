package step_definitions.LoginPageSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import step_definitions.Hooks;

public class LoginSteps {

    public WebDriver webDriver;

    public LoginSteps(){
        super();
        this.webDriver = Hooks.webDriver;
    }

    @Given("User already on login page")
    public void verifyLandingPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.verifyLandingPage());
        Thread.sleep(2000);
    }

    @When("User input {string} as userName and input {string} as password")
    public void inputCredential(String userName, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginInput(userName, password);
        loginPage.clickLogin();
        Thread.sleep(2000);
    }

    @Then("User already on sales page")
    public void verifyDashboard() throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.verifyDshboard());
        Thread.sleep(2000);
    }

    @Then("User see {string} error text on login page")
    public void verifyErrorText(String errorText) throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertEquals(errorText, loginPage.textError());
        Thread.sleep(2000);
    }
}
