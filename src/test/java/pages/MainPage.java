package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.WebDriverRunner.url;

public class MainPage {

    private final SelenideElement academyLink = $("[data-testid='header-navMenu'] a[href='/academy/about']");
    private final SelenideElement teamLink = $(byXpath("//nav[@data-testid='header-navMenu']//a[contains(text(), 'команды')]"));
    private final SelenideElement storeLink = $("[data-testid='header-navMenu'] a[href*='store.spartak.com']");
    private final SelenideElement authLink = $("[data-testid='header-userinfo-authorization']");

    public MainPage openMainPage() {
        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            open("https://spartak.com/");

            if (url().contains("/en")) {
                attempts++;
                System.out.println("Обнаружена английская версия. Попытка " + attempts + " из " + maxAttempts + ".");
                closeWebDriver();
            } else {
                return this;
            }
        }

        if (url().contains("/en")) {
            throw new IllegalStateException("Не удалось открыть русскую версию сайта за " + maxAttempts + " попыток.");
        }
        return this;
    }

    public TeamPage goToTeamPage() {
        teamLink.click();
        return new TeamPage();
    }

    public StorePage goToStorePage() {
        storeLink.click();
        return new StorePage();
    }

    public AcademyPage goToAcademyPage() {
        academyLink.click();
        return new AcademyPage();
    }

    public AuthPage goToAuthPage() {
        authLink.click();
        return new AuthPage();
    }
}