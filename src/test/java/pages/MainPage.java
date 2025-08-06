package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byXpath;


public class MainPage {

    private final SelenideElement academyLink = $("[data-testid='header-navMenu'] a[href='/academy/about']");
    private final SelenideElement clubLink = $("[data-testid='header-navMenu'] a[href='/club/results']");
    private final SelenideElement teamLink = $(byXpath("//nav[@data-testid='header-navMenu']//a[contains(text(), 'команды')]"));
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

    public AcademyPage goToAcademyPage() {
        academyLink.click();
        return new AcademyPage();
    }

    public MainPage goToClubPage() {
        clubLink.click();
        return this;
    }
}