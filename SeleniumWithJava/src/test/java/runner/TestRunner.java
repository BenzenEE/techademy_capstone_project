package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepdefinitions",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/CucumberReports/report.html",
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
