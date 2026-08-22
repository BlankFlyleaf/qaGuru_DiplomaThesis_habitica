package com.habitica.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.habitica.common.data.TaskType;
import com.habitica.ui.pages.component.DailyModalComponent;
import com.habitica.ui.pages.component.HabitModalComponent;
import com.habitica.ui.pages.component.ToDoModalComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TaskPage {

    private final SelenideElement userAvatar = $(".avatar-container");
    private final SelenideElement createTaskButton = $("#create-task-btn");

    private final ElementsCollection dropdownMenu = $$(".dropdown-item");
    private final ElementsCollection characterName = $$("span");

    private ElementsCollection taskCards(TaskType taskType) {
        return $$(".task.type_" + taskType.cssType);
    }

    private void openCreateMenu(TaskType taskType) {
        createTaskButton
                .click();
        dropdownMenu
                .findBy(text(taskType.dropdownTitle)).click();
    }

    private void openEditMenu(TaskType taskType, String cardName) {
        SelenideElement taskCard = taskCards(taskType).findBy(text(cardName));
        taskCard.$(".habitica-menu-dropdown")
                .click();
        taskCard.$(".edit-task-item")
                .shouldBe(visible)
                .click();
    }


    @Step("Проверяем аватар на странице")
    public TaskPage checkAvatar() {
        userAvatar
                .shouldBe(visible);
        return this;
    }

    @Step("Проверяем на странице имя персонажа: {name}")
    public TaskPage checkCharacterName(String name) {
        characterName
                .findBy(text(name)).shouldBe(visible);
        return this;
    }

    @Step("Проверяем наличие кнопки 'Добавить задачу' на странице")
    public TaskPage checkCreateTaskButton() {
        createTaskButton
                .shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Создаём привычку")
    public HabitModalComponent createHabitTask() {
        openCreateMenu(TaskType.HABIT);
        return new HabitModalComponent();
    }

    @Step("Создаём ежедневное дело")
    public DailyModalComponent createDailyTask() {
        openCreateMenu(TaskType.DAILY);
        return new DailyModalComponent();
    }

    @Step("Создаём задачу")
    public ToDoModalComponent createToDoTask() {
        openCreateMenu(TaskType.TODO);
        return new ToDoModalComponent();
    }

    @Step("Открываем редактирование привычки: {cardName}")
    public HabitModalComponent editHabitTask(String cardName) {
        openEditMenu(TaskType.HABIT, cardName);
        return new HabitModalComponent();
    }

    @Step("Открываем редактирование ежедневного дела: {cardName}")
    public DailyModalComponent editDailyTask(String cardName) {
        openEditMenu(TaskType.DAILY, cardName);
        return new DailyModalComponent();
    }

    @Step("Открываем редактирование задачи: {cardName}")
    public ToDoModalComponent editToDoTask(String cardName) {
        openEditMenu(TaskType.TODO, cardName);
        return new ToDoModalComponent();
    }

    @Step("Проверяем удаление карточки '{cardName}' в столбце '{taskType}'")
    public TaskPage checkTaskCardDeleted(TaskType taskType, String cardName) {
        taskCards(taskType)
                .findBy(text(cardName)).shouldNot(exist);
        return this;
    }
}
