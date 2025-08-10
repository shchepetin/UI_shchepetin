package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class TeamPage {

    private final SelenideElement teamTitle = $(".sc-d792af70-0.kdBQTS");
    private final SelenideElement wfcSpartakLink = $(byText("WFC Spartak"));
    private final SelenideElement coachFamily = $("#playerFamily");

    public TeamPage checkTeamTitleIsCorrect(String expectedTitle) {
        teamTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public TeamPage goToWfcSpartakPage() {
        wfcSpartakLink.click();
        return this;
    }

    public TeamPage checkCoachIsCorrect(String expectedFamily) {
        coachFamily.shouldHave(text(expectedFamily));
        return this;
    }
}