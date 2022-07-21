package webdriver.config;

import lombok.Data;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import webdriver.UIConfig;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "browsers.firefox")
public class FirefoxConfig implements DriverConfig{

    @Autowired
    private UIConfig uiConfig;

    private Map<String, String> preferences;

    @Override
    public FirefoxOptions getCapabilities() {
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(uiConfig.isHeadless());
        if (!uiConfig.isMaximize() && uiConfig.getWindowsizeX() != 0) {
            firefoxOptions.addArguments(
                    String.format("--window-size=%d,%d", uiConfig.getWindowsizeX(), uiConfig.getWindowsizeY()));
        }

        if (preferences != null) {
            FirefoxProfile customProfile = new FirefoxProfile();
            for (Map.Entry<String, String> entry : preferences.entrySet()) {
                customProfile.setPreference(entry.getKey(), entry.getValue());
            }
            firefoxOptions.setProfile(customProfile);
        }

        return firefoxOptions;
    }
}
