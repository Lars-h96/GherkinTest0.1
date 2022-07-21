package test.ui.stepDefinitions.common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import test.framework.config.SuiteTestConfig;

@Slf4j
@RequiredArgsConstructor
public class BeforeAfterUiSteps extends BaseUiSteps{

    @Before("@UI")
    public void uiInit() {
        final String url = suiteTestConfig.getTestUrl();
        webDriver.initWebdriver();
        webDriver.get(url);
    }

    @After("@UI")
    public void afterUI() {
        webDriver.close();
        webDriver.quit();
    }
}
