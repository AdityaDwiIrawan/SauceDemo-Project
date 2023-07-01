package step_definitions.YourOverviewSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObject.CheckoutOverviewPage;
import pageObject.YourInformationPage;
import step_definitions.Hooks;

import static org.junit.Assert.assertEquals;

public class Invoice {

    public WebDriver webDriver;

    public Invoice(){
        super();
        this.webDriver = Hooks.webDriver;
    }

    @Then("User verify that {string}")
    public void userVerifyThat(String expectedPrice) throws InterruptedException {
        CheckoutOverviewPage informationPage = new CheckoutOverviewPage(webDriver);
        System.out.println(informationPage.getTotalResult());
        assertEquals(expectedPrice,informationPage.getTotalValue());
        Thread.sleep(2000);
    }

    @And("User clicks finish button")
    public void theUserClicksFinishButton() throws InterruptedException {
        CheckoutOverviewPage clickFinish = new CheckoutOverviewPage(webDriver);
        clickFinish.finishBtn.click();
        Thread.sleep(2000);
    }

    @Then("User able to see  confirmation message as {string}")
    public void theUserAbleToSeeConfirmationMessageAs(String expectedMessage) throws InterruptedException {
        YourInformationPage informationMessage = new YourInformationPage(webDriver);
        assertEquals(expectedMessage,informationMessage.confirmationMessage.getText());
        Thread.sleep(2000);
    }
}
