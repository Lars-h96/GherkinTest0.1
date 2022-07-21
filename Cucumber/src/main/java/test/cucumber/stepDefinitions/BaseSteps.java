package test.cucumber.stepDefinitions;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import test.framework.config.SuiteTestConfig;

@NoArgsConstructor
public class BaseSteps {
    @Autowired
    protected SuiteTestConfig suiteTestConfig;
}
