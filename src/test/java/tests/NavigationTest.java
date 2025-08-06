package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AcademyPage;
import pages.AuthPage;
import pages.MainPage;
import pages.TeamPage;
import static com.codeborne.selenide.WebDriverRunner.url;

@Epic("UI-тестирование")
@Feature("Навигация по сайту")
@Owner("Ilya Shchepetin")
public class NavigationTest extends BaseTest {

    MainPage mainPage = new MainPage();
    TeamPage teamPage = new TeamPage();
    AcademyPage academyPage = new AcademyPage();
    AuthPage authPage = new AuthPage();

    @Test
    @Story("Переход на страницу 'Команда'")
    @DisplayName("Проверка перехода на страницу 'Команда' и отображение заголовка")
    @Severity(SeverityLevel.NORMAL)
    public void testGoToTeamPage() {
        mainPage
                .openMainPage()
                .goToTeamPage();
        teamPage.checkTeamTitleIsCorrect("Спартак");
    }

    @Test
    @Story("Переход на внешний сайт магазина")
    @DisplayName("Проверка перехода на внешний сайт магазина и корректность URL")
    @Severity(SeverityLevel.CRITICAL)
    public void testGoToStorePage() {
        mainPage
                .openMainPage()
                .goToStorePage()
                .checkUrl();
    }

    @Test
    @Story("Переход на страницу 'Академия'")
    @DisplayName("Проверка перехода на страницу 'Академия' и отображение заголовка")
    @Severity(SeverityLevel.NORMAL)
    public void testGoToAcademyPage() {
        mainPage
                .openMainPage()
                .goToAcademyPage();
        academyPage.checkAcademyTitleIsCorrect("Академия Спартак");
    }

    @Test
    @Story("Переход на страницу авторизации")
    @DisplayName("Проверка перехода на страницу авторизации и отображение заголовка")
    @Severity(SeverityLevel.NORMAL)
    public void testGoToAuthPage() {
        mainPage
                .openMainPage()
                .goToAuthPage();
        authPage.checkAuthTitleIsCorrect("Войти в личный кабинет ФК «Спартак»");
    }
}