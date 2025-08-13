package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import io.qameta.allure.Step;

public class TeamPage {

    private final SelenideElement teamTitle = $(".sc-d792af70-0.kdBQTS");
    private final SelenideElement wfcSpartakLink = $(byText("WFC Spartak"));
    private final SelenideElement coachFamily = $("#playerFamily");

    @Step("Проверить, что заголовок страницы команды отображается корректно")
    public TeamPage checkTeamTitleIsCorrect(String expectedTitle) {
        teamTitle.shouldHave(text(expectedTitle));
        return this;
    }

    @Step("Перейти на страницу ЖФК Спартак")
    public TeamPage goToWfcSpartakPage() {
        wfcSpartakLink.click();
        return this;
    }

    @Step("Проверить, что фамилия главного тренера отображается корректно")
    public TeamPage checkCoachIsCorrect(String expectedFamily) {
        coachFamily.shouldHave(text(expectedFamily));
        return this;
    }
}