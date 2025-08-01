package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.StorePage;
import pages.TeamPage;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("UI-тестирование")
@Feature("Навигация по сайту")
@Owner("Ilya Shchepetin")
public class NavigationTest extends BaseTest {

    MainPage mainPage = new MainPage();
    TeamPage teamPage = new TeamPage();
    StorePage storePage = new StorePage();

    @Test
    @Story("Переход на страницу 'Команда'")
    @DisplayName("Проверка перехода на страницу 'Команда' и отображение заголовка")
    @Severity(SeverityLevel.NORMAL)
    public void testGoToTeamPage() {
        mainPage
                .openMainPage()
                .goToTeamPage()
                .checkPageTitleIsVisible();
    }

    @Test
    @Story("Переход на страницу 'Новости'")
    @DisplayName("Проверка перехода на страницу 'Новости'")
    @Severity(SeverityLevel.NORMAL)
    public void testGoToNewsPage() {
        mainPage
                .openMainPage()
                .goToNewsPage();
        assertTrue(url().contains("/news"), "URL должен содержать '/news'");
    }

    @Test
    @Story("Переход на страницу 'Матчи'")
    @DisplayName("Проверка перехода на страницу 'Матчи'")
    @Severity(SeverityLevel.NORMAL)
    public void testGoToMatchesPage() {
        mainPage
                .openMainPage()
                .goToMatchesPage();
        assertTrue(url().contains("/matches"), "URL должен содержать '/matches'");
    }

    @Test
    @Story("Переход на страницу магазина")
    @DisplayName("Проверка перехода на внешний сайт магазина и корректность URL")
    @Severity(SeverityLevel.CRITICAL)
    public void testGoToStorePage() {
        mainPage
                .openMainPage()
                .goToStorePage()
                .checkUrl();
    }
}
