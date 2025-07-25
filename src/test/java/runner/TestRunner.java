package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/resources/featureFile/login.feature",
        glue = {"stepDeinition"},
        monochrome = true,
        tags = "@login",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)


public class TestRunner {

}
