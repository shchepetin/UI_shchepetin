package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AcademyPage {

    private final SelenideElement academyTitle = $(".sc-450f9b26-3.hBqoYv");

    public AcademyPage checkAcademyTitleIsCorrect(String expectedTitle) {
        academyTitle.shouldHave(text(expectedTitle));
        return this;
    }
}