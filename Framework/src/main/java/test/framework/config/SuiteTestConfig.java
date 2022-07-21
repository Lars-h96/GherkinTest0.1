package test.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties
public class SuiteTestConfig {
    private String url;
    private String testUrl;
    private boolean scenarioCleanup = true;
    private boolean messageLogging = false;

    /** @return Test URL */
    public String getTestUrl() {
        return testUrl;
    }

}
