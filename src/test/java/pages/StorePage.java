package pages;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Step;

public class StorePage {

    @Step("Проверить, что URL страницы магазина содержит 'store.spartak.com'")
    public StorePage checkUrl() {
        String currentUrl = url();
        assertTrue(currentUrl.contains("store.spartak.com"), "URL должен содержать store.spartak.com");
        return this;
    }
}