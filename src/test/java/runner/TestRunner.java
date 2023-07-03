package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/incomeTaxCalculator.feature",
        glue = {"stepDefinitions",
                "hooks",
                "drivers"},
        monochrome = true,
        plugin = {"pretty", "junit:target/JUnitReports/report.xml",
                "json:target/JSONReports/report.json",
                "html:target/cucumber/CucumberHTMLReport.html"}
)

public class TestRunner {
}
