package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;

public class TeamPage {

    private final SelenideElement pageTitle = $(".page-title");
    private final ElementsCollection playerCards = $$(".squad-item");
    private final SelenideElement firstPlayerCard = playerCards.first();
    private final SelenideElement teamStaffLink = $("[data-filter-id='staff']");

    public TeamPage checkPageTitleIsVisible() {
        pageTitle.shouldBe(visible);
        return this;
    }

    public TeamPage checkPlayerCardsCount() {
        playerCards.shouldHave(sizeGreaterThanOrEqual(20));
        return this;
    }

    public TeamPage goToFirstPlayerProfile() {
        firstPlayerCard.click();
        return this;
    }

    public TeamPage checkPlayerNameIsDisplayed(String name) {
        $(".player-card__name").shouldHave(text(name));
        return this;
    }

    public TeamPage checkTeamStaffLinkIsVisible() {
        teamStaffLink.shouldBe(visible);
        return this;
    }
}