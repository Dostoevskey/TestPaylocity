package test;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "cucumberSteps",
        tags = "@all",
        snippets = SnippetType.CAMELCASE
)

public class Driver {


}

