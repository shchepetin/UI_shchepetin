package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.TeamPage;


@Epic("UI-тестирование")
@Feature("Страница команд")
@Owner("Ilya Shchepetin")
@Tag("Jenkins")
public class TeamTest extends BaseTest {

    MainPage mainPage = new MainPage();
    TeamPage teamPage = new TeamPage();

    @Test
    @Story("Проверка страницы команды")
    @DisplayName("Проверка перехода на страницу ЖФК Спартак и отображение заголовка")
    @Severity(SeverityLevel.NORMAL)
    public void testGoToWfcSpartakPageTest() {
        mainPage
                .openMainPage()
                .goToTeamPage();
        teamPage
                .goToWfcSpartakPage()
                .checkTeamTitleIsCorrect("WFC Spartak");
    }

    @Test
    @Story("Проверка страницы команды")
    @DisplayName("Проверка отображения фамилии главного тренера")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckCoachFamilyTest() {
        mainPage
                .openMainPage()
                .goToTeamPage();
        teamPage.checkCoachIsCorrect("Stankovic");
    }
}