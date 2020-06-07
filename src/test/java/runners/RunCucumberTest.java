package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-reports" },
    features = { "classpath:features/" }, glue = { "steps", "hooks" })
public class RunCucumberTest {
}