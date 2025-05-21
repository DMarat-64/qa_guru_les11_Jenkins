package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    static String selenoidUserLogin = System.getProperty("selenoidUserLogin", "user1");
    static String selenoidUserPassword = System.getProperty("selenoidUserPassword", "1234");
    static String selenoidRemoteServerUrl = System.getProperty(
            "selenoidRemoteServerUrl", "selenoid.autotests.cloud");
    static String browser = System.getProperty("browser", "chrome");
    static String browserVersion = System.getProperty("browserVersion", "128.0");
    static String browserSize = System.getProperty("browserResolution", "1920x1080");

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = browserSize;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

        Configuration.remote = "https://" +
                selenoidUserLogin + ":" + selenoidUserPassword +"@" + selenoidRemoteServerUrl + "/wd/hub";

       // Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @AfterEach

    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
