package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement newsLink = $("[data-testid='header-navMenu'] a[href='/media/news']");
    private final SelenideElement matchesLink = $("[data-testid='header-navMenu'] a[href='/matches/forthcoming']");
    private final SelenideElement teamLink = $x("//nav[@data-testid='header-navMenu']//a[contains(text(), 'команды')]");
    private final SelenideElement storeLink = $("[data-testid='header-navMenu'] a[href*='store.spartak.com']");

    public MainPage openMainPage() {
        open("/");
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

    public MainPage goToNewsPage() {
        newsLink.click();
        return this;
    }

    public MainPage goToMatchesPage() {
        matchesLink.click();
        return this;
    }
}