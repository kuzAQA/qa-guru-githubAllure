package com.github;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Ищем реопзиторий {repo}")
    public void findRepository() {
        $(byName("q")).click();
        $(byName("q")).setValue("eroshenkoam/allure-example").pressEnter();
    }
    @Step("Переходим по ссылке репозитория {repo}")
    public void openRepository(String repo) {
        $(byLinkText(repo)).click();
    }
    @Step("Кликаем на таб Issues")
    public void openIssuesTab() {
        $(byPartialLinkText("Issues")).click();
    }
    @Step("Проверяем что существует Issue с номером {issue}")
    public void checkIssue(String issue_number) {
        $(withText(issue_number)).click();
    }
}
