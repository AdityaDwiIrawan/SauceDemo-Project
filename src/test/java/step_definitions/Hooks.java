package step_definitions;

import context.TestContext;
import driver.WebDriverInstance;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Hooks {

    public static WebDriver webDriver;
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void openBrowser() {
        webDriver = WebDriverInstance.initialize(Boolean.parseBoolean(System.getProperty("running-on-hub", "false")));
        context.driver = webDriver;
        context.driverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }


//    @After
//    public void closeBrowser() throws InterruptedException {
//        Thread.sleep(2000);
//        webDriver.quit();
//    }
}
