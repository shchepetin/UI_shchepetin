package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://spartak.com/");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = System.getProperty("remote");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @AfterEach
    public void tearDown() {
        addVideo();
        addBrowserLogs();
        Selenide.closeWebDriver();
    }

    private void addVideo() {
        String sessionId = Selenide.sessionId().toString();
        if (Configuration.remote != null) {
            String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId + ".mp4";
            try {
                Allure.addAttachment("Video", "video/mp4", Files.newInputStream(new File(videoUrl).toPath()), ".mp4");
            } catch (IOException e) {
                Logger.getLogger(BaseTest.class.getName()).log(Level.WARNING, "Could not attach video", e);
            }
        }
    }

    private void addBrowserLogs() {
        Allure.addAttachment("Browser logs",
                String.join("\n", Selenide.getWebDriverLogs("browser"))
        );
    }
}