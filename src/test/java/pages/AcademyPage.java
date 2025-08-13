package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import io.qameta.allure.Step;

public class AcademyPage {

    private final SelenideElement academyTitle = $(".sc-450f9b26-3.hBqoYv");

    @Step("Проверить, что заголовок страницы 'Академия' отображается корректно")
    public AcademyPage checkAcademyTitleIsCorrect(String expectedTitle) {
        academyTitle.shouldHave(text(expectedTitle));
        return this;
    }
}