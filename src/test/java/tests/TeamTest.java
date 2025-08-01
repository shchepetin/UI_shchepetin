package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.TeamPage;

@Epic("UI-тестирование")
@Feature("Страница команды")
@Owner("Ilya Shchepetin")
public class TeamTest extends BaseTest {

    MainPage mainPage = new MainPage();
    TeamPage teamPage = new TeamPage();

    @Test
    @Story("Проверка состава команды")
    @DisplayName("Проверка, что на странице команды отображается более 20 игроков")
    @Severity(SeverityLevel.BLOCKER)
    public void testTeamPlayersCountIsCorrect() {
        mainPage
                .openMainPage()
                .goToTeamPage();
        teamPage.checkPlayerCardsCount();
    }

    @Test
    @Story("Проверка профиля игрока")
    @DisplayName("Проверка перехода на профиль первого игрока и отображение его имени")
    @Severity(SeverityLevel.NORMAL)
    public void testPlayerProfileIsCorrect() {
        mainPage
                .openMainPage()
                .goToTeamPage()
                .goToFirstPlayerProfile()
                .checkPlayerNameIsDisplayed("Манфред Угальде");
    }

    @Test
    @Story("Проверка элементов страницы команды")
    @DisplayName("Проверка, что на странице команды есть вкладка 'Тренерский штаб'")
    @Severity(SeverityLevel.TRIVIAL)
    public void testTeamStaffLinkIsVisible() {
        mainPage
                .openMainPage()
                .goToTeamPage()
                .checkTeamStaffLinkIsVisible();
    }
}