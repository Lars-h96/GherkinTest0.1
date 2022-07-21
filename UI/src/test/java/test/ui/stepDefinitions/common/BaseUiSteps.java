package test.ui.stepDefinitions.common;

import org.springframework.beans.factory.annotation.Autowired;
import test.cucumber.stepDefinitions.BaseSteps;
import webdriver.Webdriver;

public class BaseUiSteps extends BaseSteps {

    @Autowired
    protected Webdriver webDriver;


}
