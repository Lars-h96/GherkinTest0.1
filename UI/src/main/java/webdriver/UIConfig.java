package webdriver;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "ui")
public class UIConfig {
    private boolean headless = false;
    private boolean maximize = true;
    private int windowsizeX = 1920;
    private int windowsizeY = 1080;
}
