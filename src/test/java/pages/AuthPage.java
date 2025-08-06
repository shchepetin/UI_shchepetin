package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    private final SelenideElement authTitle = $(".sc-d5460369-2.tKmaF");

    public AuthPage checkAuthTitleIsCorrect(String expectedTitle) {
        authTitle.shouldHave(text(expectedTitle));
        return this;
    }
}