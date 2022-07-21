package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import webdriver.config.*;

import java.util.List;
import java.util.Set;

public class Webdriver implements WebDriver {

    private RemoteWebDriver driver;

    @Value("${browserUnderTest:chrome}")
    private String browserUnderTest;

    @Autowired
    private UIConfig uiConfig;
    @Autowired
    private ChromeConfig chromeConfig;
    @Autowired
    private FirefoxConfig firefoxConfig;

    public void initWebdriver() {
        switch (browserUnderTest) {
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

                ChromeOptions chromeOptions = chromeConfig.getCapabilities();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver(firefoxConfig.getCapabilities());
                break;
            default:
                throw new UnsupportedOperationException(
                        browserUnderTest + " is not recognized as supported browser type");
        }
        maximize();
    }

    private void maximize() {
        if (uiConfig.isMaximize()) {
            driver.manage().window().maximize();
        }
    }

    @Override
    public void get(String url) {

    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }
}