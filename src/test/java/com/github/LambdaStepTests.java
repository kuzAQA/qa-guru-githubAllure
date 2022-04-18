package com.github;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("kuzAQA")
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории. Lambda Steps")
public class LambdaStepTests {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "74";

    @Test
    @DisplayName("Тест через lambda steps")
    void lambdaStepTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем реопзиторий " + REPOSITORY, () -> {
            $(byName("q")).click();
            $(byName("q")).setValue("eroshenkoam/allure-example").pressEnter();
        });
        step("Переходим по ссылке репозитория " + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
        });
        step("Кликаем на таб Issues", () -> {
            $(byPartialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue с номером " + ISSUE_NUMBER, () -> {
            $(withText(ISSUE_NUMBER)).click();
        });
    }
}
