package test.ui.testRun;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue = {"test/ui/stepDefinitions"},
        plugin ={"pretty", "json:target/reports/jsonReports/Regression.json",
                "junit:target/reports/junitReports/Regression.xml",
                "html:target/reports/htmlReports/Regression.html"} )

public class suiteRun {
}
