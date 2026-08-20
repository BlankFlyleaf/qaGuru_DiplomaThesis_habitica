package com.habitica.ui.pages.component;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.habitica.ui.data.Difficulty;
import com.habitica.ui.data.HabitType;
import com.habitica.ui.data.ResetCounter;
import com.habitica.ui.data.Tags;
import com.habitica.ui.pages.TaskPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HabitModalComponent {

    private final SelenideElement modalWindow = $(".modal.show");
    private final SelenideElement titleInput = $("input.input-title");
    private final SelenideElement notesInput = $("textarea.input-notes");
    private final SelenideElement createButton = $("button.btn-footer");
    private final SelenideElement difficultyDropdown = $(".difficulty-select .dropdown-toggle");
    private final SelenideElement tagsDropdown = $(".tags-select .dropdown-toggle");
    private final SelenideElement counterDropdown = $(".array-select .dropdown-toggle");
    private final SelenideElement deleteButton = $("button.delete-task-btn");

    private final ElementsCollection clickHabitType = $$("button.habit-option-container");
    private final ElementsCollection clickDropdown = $$("a.dropdown-item");
    private final ElementsCollection clickTag = $$("button.dropdown-item");

    private SelenideElement getSelectedTag(String tagName) {
        return $(".multi-item[title='" + tagName + "']");
    }

    @Step("Проверяем что модальное окно открыто")
    public HabitModalComponent checkModalVisible() {
        modalWindow
                .shouldBe(visible);
        titleInput
                .shouldBe(visible);
        return this;
    }

    @Step("Вводим заголовок задачи: {title}")
    public HabitModalComponent setTitle(String title) {
        titleInput
                .setValue(title);
        return this;
    }

    @Step("Вводим заметку: {notes}")
    public HabitModalComponent setNotes(String notes) {
        notesInput
                .setValue(notes);
        return this;
    }

    @Step("Выбираем тип привычки: {type}")
    public HabitModalComponent selectHabitType(HabitType type) {
        clickHabitType
                .findBy(text(type.getDisplayName()))
                .click();
        return this;
    }

    @Step("Выбираем сложность: {difficulty}")
    public HabitModalComponent selectDifficulty(Difficulty difficulty) {
        difficultyDropdown
                .click();
        clickDropdown
                .findBy(text(difficulty.getDisplayName()))
                .click();
        return this;
    }

    @Step("Выбираем тег: {tag}")
    public HabitModalComponent selectTag(Tags tag) {
        tagsDropdown
                .click();
        clickTag
                .findBy(text(tag.getDisplayName())).click();
        titleInput
                .click();
        return this;
    }

    @Step("Выбираем сброс счётчика: {period}")
    public HabitModalComponent selectResetCounter(ResetCounter period) {
        counterDropdown
                .click();
        clickDropdown
                .findBy(text(period.getDisplayName()))
                .click();
        return this;
    }

    @Step("Проверяем заголовок задачи: {title}")
    public HabitModalComponent checkTitle(String title) {
        titleInput
                .shouldHave(value(title));
        return this;
    }

    @Step("Проверяем заметку: {notes}")
    public HabitModalComponent checkNotes(String notes) {
        notesInput
                .shouldHave(value(notes));
        return this;
    }

    @Step("Проверяем тип привычки: {type}")
    public HabitModalComponent checkHabitType(HabitType type) {
        clickHabitType
                .findBy(text(type.getDisplayName()))
                .shouldBe(enabled);
        return this;
    }

    @Step("Проверяем сложность: {difficulty}")
    public HabitModalComponent checkDifficulty(Difficulty difficulty) {
        difficultyDropdown
                .shouldHave(text(difficulty.getDisplayName()));
        return this;
    }

    @Step("Проверяем тег: {tag}")
    public HabitModalComponent checkTag(Tags tag) {
        getSelectedTag(tag.getDisplayName())
                .shouldBe(visible);
        return this;
    }

    @Step("Проверяем сброс счётчика: {period}")
    public HabitModalComponent checkResetCounter(ResetCounter period) {
        counterDropdown
                .shouldHave(text(period.getDisplayName()));
        return this;
    }

    @Step("Нажимаем 'Создать'")
    public TaskPage clickCreate() {
        createButton
                .shouldBe(enabled)
                .click();
        return new TaskPage();
    }

    @Step("Нажимаем кнопку удаления задачи")
    public DeleteModalComponent clickDeleteButton() {
        deleteButton
                .click();
        return new DeleteModalComponent();
    }
}
