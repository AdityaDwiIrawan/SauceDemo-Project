package step_definitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        tags = "@Login or @Sales",
        features = {"classpath:features/"},
        glue = {"classpath:step_definitions"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber/cucumber.json",
                "html:target/cucumber-report/cucumber.html",
                "junit:target/cucumber-report/cucumber.xml",
                "message:target/cucumber-report/cucumber.json",
                "html:target/result.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunCukesTest {
}

