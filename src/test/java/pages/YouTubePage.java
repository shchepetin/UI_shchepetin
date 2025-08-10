package pages;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YouTubePage {

    public YouTubePage checkUrl() {
        switchTo().window(1);
        String currentUrl = url();
        assertTrue(currentUrl.contains("https://www.youtube.com/user/fcsmofficial"), "URL должен содержать https://www.youtube.com/user/fcsmofficial");
        return this;
    }
}