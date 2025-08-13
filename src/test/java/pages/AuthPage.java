package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import io.qameta.allure.Step;

public class AuthPage {

    private final SelenideElement authTitle = $(".sc-d5460369-2.tKmaF");

    @Step("Проверить, что заголовок страницы 'Авторизация' отображается корректно")
    public AuthPage checkAuthTitleIsCorrect(String expectedTitle) {
        authTitle.shouldHave(text(expectedTitle));
        return this;
    }
}