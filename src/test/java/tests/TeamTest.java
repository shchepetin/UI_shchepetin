package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.TeamPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Epic("UI-тестирование")
@Feature("Страница команд")
@Owner("Ваше_Имя")
public class TeamTest extends BaseTest {

    MainPage mainPage = new MainPage();
    TeamPage teamPage = new TeamPage();

    @Test
    @Story("Проверка перехода на страницу команды")
    @DisplayName("Проверка, что заголовок страницы 'Команда' отображается корректно")
    @Severity(SeverityLevel.NORMAL)
    public void testTeamPageTitleIsCorrect() {
        mainPage
                .openMainPage()
                .goToTeamPage();
        teamPage.checkTeamTitleIsCorrect("Спартак");
    }

    @Test
    @Story("Проверка переключения команд")
    @DisplayName("Проверка перехода на страницу ЖФК Спартак и корректность заголовка")
    @Severity(SeverityLevel.NORMAL)
    public void testJfkSpartakPageTitleIsCorrect() {
        mainPage
                .openMainPage()
                .goToTeamPage();
        teamPage
                .goToJfkSpartakTeam()
                .checkTeamTitleIsCorrect("ЖФК Спартак");
    }

    @Test
    @Story("Проверка главного тренера")
    @DisplayName("Проверка, что на странице команды отображается главный тренер")
    @Severity(SeverityLevel.BLOCKER)
    public void testMainCoachIsDisplayed() {
        mainPage
                .openMainPage()
                .goToTeamPage();
        teamPage
                .checkMainCoachNameIsDisplayed("Станкович");
    }
}