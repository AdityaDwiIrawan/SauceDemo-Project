package step_definitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver webDriver;

    @Before
    public void openBrowser(){
        ChromeOptions co = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        co.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(co);
        String URL = "https://www.saucedemo.com/";
        webDriver.get(URL);
        webDriver.manage().window().maximize();
    }

    /*@After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();
    }*/
}
