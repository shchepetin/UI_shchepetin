package pages;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StorePage {

    public StorePage checkUrl() {
        String currentUrl = url();
        assertTrue(currentUrl.contains("store.spartak.com"), "URL должен содержать store.spartak.com");
        return this;
    }
}