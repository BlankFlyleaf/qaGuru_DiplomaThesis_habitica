package com.habitica.ui.pages.component;

import com.codeborne.selenide.SelenideElement;
import com.habitica.ui.pages.TaskPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DeleteModalComponent   {

    private final SelenideElement confirmDeleteButton = $(".btn.btn-danger");

    @Step("Подтверждаем удаление задачи")
    public TaskPage confirmDelete() {
        confirmDeleteButton
                .click();
        return new TaskPage();
    }
}
