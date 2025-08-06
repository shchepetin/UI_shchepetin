package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class TeamPage {

    private final SelenideElement pageTitle = $(".sc-d792af70-0.kdBQTS");
    private final SelenideElement teamSearchMenu = $(".sc-9d0a65de-2.fINLCJ");
    private final SelenideElement jfkSpartakButton = teamSearchMenu.$("div.ivmsQU", 0);
    private final SelenideElement mainCoachCard = $("#playerFamily");

    public TeamPage checkPageTitleIsVisible() {
        pageTitle.shouldBe(visible);
        return this;
    }

    public TeamPage checkTeamTitleIsCorrect(String teamName) {
        pageTitle.shouldHave(text(teamName));
        return this;
    }

    public TeamPage goToJfkSpartakTeam() {
        jfkSpartakButton.click();
        return this;
    }

    public TeamPage checkMainCoachNameIsDisplayed(String name) {
        mainCoachCard.shouldHave(text(name));
        return this;
    }
}