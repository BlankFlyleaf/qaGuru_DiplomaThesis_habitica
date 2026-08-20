package com.habitica.ui.pages.component;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.habitica.ui.data.Difficulty;
import com.habitica.ui.data.MonthData;
import com.habitica.ui.data.TaskTags;
import com.habitica.ui.pages.TaskPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ToDoModalComponent {

    private final SelenideElement modalWindow = $(".modal.show");
    private final SelenideElement titleInput = $("input.input-title");
    private final SelenideElement notesInput = $("textarea.input-notes");
    private final SelenideElement createButton = $("button.btn-footer");
    private final SelenideElement difficultyDropdown = $(".difficulty-select .dropdown-toggle");
    private final SelenideElement tagsDropdown = $(".tags-select .dropdown-toggle");
    private final SelenideElement deleteButton = $("button.delete-task-btn");
    private final SelenideElement newChecklistInput = $("input[placeholder='Новый пункт списка']");
    private final SelenideElement calendarButton = $(".vdp-datepicker__calendar-button");
    private final SelenideElement calendar = $(".vdp-datepicker__calendar");
    private final SelenideElement dateInput = $("input.form-control[readonly]");
    private final SelenideElement monthButton = $(".day__month_btn.up");
    private final SelenideElement yearButton = $(".month__year_btn.up");

    private final ElementsCollection clickDropdown = $$("a.dropdown-item");
    private final ElementsCollection clickTag = $$("button.dropdown-item");
    private final ElementsCollection checklistItems = $$(".checklist-group:not(.new-checklist) input.checklist-item");
    private final ElementsCollection days = $$(".cell.day:not(.blank)");
    private final ElementsCollection months = $$(".cell.month");
    private final ElementsCollection years = $$(".cell.year");

    private SelenideElement getSelectedTag(String tagName) {
        return $(".multi-item[title='" + tagName + "']");
    }

    private String formattedDate(int day, MonthData month, int year) {
        return day + " " + month.getShortName() + " " + year;
    }

    @Step("Проверяем что модальное окно открыто")
    public ToDoModalComponent checkModalVisible() {
        modalWindow
                .shouldBe(visible);
        titleInput
                .shouldBe(visible);
        return this;
    }

    @Step("Вводим заголовок задачи: {title}")
    public ToDoModalComponent setTitle(String title) {
        titleInput
                .setValue(title);
        return this;
    }

    @Step("Вводим заметку: {notes}")
    public ToDoModalComponent setNotes(String notes) {
        notesInput
                .setValue(notes);
        return this;
    }

    @Step("Выбираем сложность: {difficulty}")
    public ToDoModalComponent selectDifficulty(Difficulty difficulty) {
        difficultyDropdown
                .click();
        clickDropdown
                .findBy(text(difficulty.getDisplayName()))
                .click();
        return this;
    }

    @Step("Выбираем тег: {tag}")
    public ToDoModalComponent selectTag(TaskTags tag) {
        tagsDropdown
                .click();
        clickTag
                .findBy(text(tag.getDisplayName()))
                .click();
        titleInput
                .click();
        return this;
    }

    @Step("Добавляем пункт чеклиста: {item}")
    public ToDoModalComponent addChecklistItem(String item) {
        newChecklistInput
                .setValue(item)
                .pressEnter();
        return this;
    }

    @Step("Открываем календарь")
    public ToDoModalComponent openCalendar() {
        calendarButton
                .click();
        return this;
    }

    @Step("Проверяем что календарь открыт")
    public ToDoModalComponent checkCalendarVisible() {
        calendar
                .shouldBe(visible);
        return this;
    }

    @Step("Открываем выбор года")
    public ToDoModalComponent openCalendarOnYear() {
        monthButton
                .click();
        yearButton
                .click();
        return this;
    }

    @Step("Выбираем год: {year}")
    public ToDoModalComponent selectYear(int year) {
        years
                .findBy(exactText(String.valueOf(year)))
                .click();
        return this;
    }

    @Step("Выбираем месяц: {month}")
    public ToDoModalComponent selectMonth(MonthData month) {
        months
                .findBy(exactText(month.getDisplayName()))
                .click();
        return this;
    }

    @Step("Выбираем день: {day}")
    public ToDoModalComponent selectDay(int day) {
        days
                .findBy(exactText(String.valueOf(day)))
                .click();
        return this;
    }

    @Step("Проверяем заголовок задачи: {title}")
    public ToDoModalComponent checkTitle(String title) {
        titleInput
                .shouldHave(value(title));
        return this;
    }

    @Step("Проверяем заметку: {notes}")
    public ToDoModalComponent checkNotes(String notes) {
        notesInput
                .shouldHave(value(notes));
        return this;
    }

    @Step("Проверяем сложность: {difficulty}")
    public ToDoModalComponent checkDifficulty(Difficulty difficulty) {
        difficultyDropdown
                .shouldHave(text(difficulty.getDisplayName()));
        return this;
    }

    @Step("Проверяем тег: {tag}")
    public ToDoModalComponent checkTag(TaskTags tag) {
        getSelectedTag(tag.getDisplayName())
                .shouldBe(visible);
        return this;
    }

    @Step("Проверяем количество пунктов чеклиста: {count}")
    public ToDoModalComponent checkChecklistSize(int count) {
        checklistItems
                .shouldHave(size(count));
        return this;
    }

    @Step("Проверяем доступность поля добавления нового пункта")
    public ToDoModalComponent checkNewChecklistAvailable() {
        newChecklistInput
                .shouldBe(visible)
                .shouldBe(enabled);
        return this;
    }

    @Step("Проверяем выбранную дату: {day} {month} {year}")
    public ToDoModalComponent checkDate(int day, MonthData month, int year) {
        dateInput
                .shouldHave(value(formattedDate(day, month, year)));
        return this;
    }

    @Step("Нажимаем 'Создать'")
    public TaskPage clickCreate() {
        createButton
                .shouldBe(enabled).click();
        return new TaskPage();
    }

    @Step("Нажимаем кнопку удаления задачи")
    public DeleteModalComponent clickDeleteButton() {
        deleteButton
                .click();
        return new DeleteModalComponent();
    }
}
