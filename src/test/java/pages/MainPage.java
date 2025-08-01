package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    private final SelenideElement teamLink = $(".header-navigation-menu__item a[href='/team/']");
    private final SelenideElement storeLink = $(".header-navigation-menu__item a[href='https://store.spartak.com']");
    private final SelenideElement newsLink = $(".header-navigation-menu__item a[href='/news/']");
    private final SelenideElement matchesLink = $(".header-navigation-menu__item a[href='/matches/']");
    private final SelenideElement mainLogo = $(".header-logo");

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

    public MainPage checkLogoIsVisible() {
        mainLogo.shouldBe(visible);
        return this;
    }
}