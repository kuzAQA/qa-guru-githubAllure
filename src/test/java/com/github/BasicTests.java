package com.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Owner("kuzAQA")
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории. Тест на Selenide")
public class BasicTests {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "74";

    @Test
    @DisplayName("Базовый Selenide тест + Listener")
    void basicTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(byName("q")).click();
        $(byName("q")).setValue(REPOSITORY).pressEnter();

        $(byLinkText(REPOSITORY)).click();
        $(byPartialLinkText("Issues")).click();
        $(withText(ISSUE_NUMBER)).click();
    }
}
