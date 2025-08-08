package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.attribute;

public class MainPage {

    private final SelenideElement
            academyLink = $("[data-testid='header-navMenu'] a[href='/academy/about']"),
            teamLink = $(byXpath("//nav[@data-testid='header-navMenu']//a[contains(text(), 'команды')]")),
            storeLink = $("[data-testid='header-navMenu'] a[href*='store.spartak.com']"),
            authLink = $("[data-testid='header-userinfo-authorization']"),
            languageSwitcher = $("[data-testid='header-change-localization']");

    public MainPage openMainPage() {
        open("/");

        if ($("html").getAttribute("lang").equals("en")) {
            languageSwitcher.click();
        }

        $("html").shouldHave(attribute("lang", "ru"));

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