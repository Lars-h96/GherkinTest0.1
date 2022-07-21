package webdriver.config;

import lombok.Data;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import webdriver.UIConfig;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "browsers.chrome")
public class ChromeConfig implements DriverConfig{

    @Autowired
    private UIConfig uiConfig;

    private List<String> arguments;

    @Override
    public ChromeOptions getCapabilities() {
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(uiConfig.isHeadless());
        if (!uiConfig.isMaximize() && uiConfig.getWindowsizeX() != 0) {
            chromeOptions.addArguments(
                    String.format("--window-size=%dx%d", uiConfig.getWindowsizeX(), uiConfig.getWindowsizeY()));
        }

        if (arguments != null) {
            for (String argument : arguments) {
                chromeOptions.addArguments(argument);
            }
        }
        return chromeOptions;
    }

}
