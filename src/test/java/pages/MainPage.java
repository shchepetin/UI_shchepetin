package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import io.qameta.allure.Step;


public class MainPage {

    private final SelenideElement academyLink = $("[data-testid='header-navMenu'] a[href='/en/academy/about']");
    private final SelenideElement teamLink = $("a[href='/en/teams/94974f94-27da-4350-81b3-9eb7afa82237']");
    private final SelenideElement storeLink = $("[data-testid='header-navMenu'] a[href*='store.spartak.com']");
    private final SelenideElement authLink = $("[data-testid='header-userinfo-authorization']");
    private final SelenideElement youtubeLink = $("a[aria-label='youtube channel']");

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Перейти на страницу команды")
    public TeamPage goToTeamPage() {
        teamLink.click();
        return new TeamPage();
    }

    @Step("Перейти на страницу магазина")
    public StorePage goToStorePage() {
        storeLink.click();
        return new StorePage();
    }

    @Step("Перейти на страницу академии")
    public AcademyPage goToAcademyPage() {
        academyLink.click();
        return new AcademyPage();
    }

    @Step("Перейти на страницу авторизации")
    public AuthPage goToAuthPage() {
        authLink.click();
        return new AuthPage();
    }

    @Step("Перейти на YouTube-канал")
    public YouTubePage goToYoutubeChannel() {
        youtubeLink.click();
        return new YouTubePage();
    }
}