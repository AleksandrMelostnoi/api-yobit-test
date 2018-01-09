import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, features = "src/test/features", format = { "pretty",
        "json:target/cucumber.json" }, tags = { "~@ignore" })

public class RunBDDTest {
}
