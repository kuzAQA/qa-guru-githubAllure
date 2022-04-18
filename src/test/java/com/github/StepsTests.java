package com.github;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("kuzAQA")
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории. Тест на @Step")
public class StepsTests {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "74";
    WebSteps step = new WebSteps();

    @Test
    @DisplayName("Тест с шагами через аннотацию @Step")
    void stepsTests() {
        step.openMainPage();
        step.findRepository();
        step.openRepository(REPOSITORY);
        step.openIssuesTab();
        step.checkIssue(ISSUE_NUMBER);
    }
}
