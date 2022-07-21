package stepDefinitions.common;

import org.springframework.beans.factory.annotation.Autowired;
import webdriver.Webdriver;

public class BaseSteps {

    @Autowired
    protected Webdriver webDriver;


}
