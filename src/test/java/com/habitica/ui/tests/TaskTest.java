package com.habitica.ui.tests;

import com.habitica.common.data.TaskType;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.habitica.common.data.CommonTestData.password;
import static com.habitica.common.data.CommonTestData.username;

@Owner("BlankFlyleaf")
@Feature("Задачи UI")
public class TaskTest extends UiTestBase {

    @BeforeEach
    void loginBeforeEachTest() {
        loginUi.openLoginPage()
                .setUsernameValue(username)
                .setPasswordValue(password)
                .clickSubmitButton();
    }

    @Test
    @Story("Создание задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание привычки с заполнением всех полей")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void createHabitTaskTest() {
        taskUi
                .createHabitTask()
                .checkModalVisible()
                .setTitle(testDataUi.titleRandom)
                .setNotes(testDataUi.noteRandom)
                .selectHabitType(testDataUi.typeRandom)
                .selectDifficulty(testDataUi.difficultyRandom)
                .selectTag(testDataUi.firstTagRandom)
                .selectTag(testDataUi.secondTagRandom)
                .selectResetCounter(testDataUi.counterRandom)
                .clickCreate()
                .editHabitTask(testDataUi.titleRandom)
                .checkTitle(testDataUi.titleRandom)
                .checkNotes(testDataUi.noteRandom)
                .checkHabitType(testDataUi.typeRandom)
                .checkDifficulty(testDataUi.difficultyRandom)
                .checkTag(testDataUi.firstTagRandom)
                .checkTag(testDataUi.secondTagRandom)
                .checkResetCounter(testDataUi.counterRandom);
    }

    @Test
    @Story("Создание задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание ежедневного дела с заполнением всех полей")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void createDailyTaskTest() {
        taskUi
                .createDailyTask()
                .checkModalVisible()
                .setTitle(testDataUi.titleRandom)
                .setNotes(testDataUi.noteRandom)
                .addChecklistItem(testDataUi.firstListItem)
                .addChecklistItem(testDataUi.secondListItem)
                .selectDifficulty(testDataUi.difficultyRandom)
                .openCalendar()
                .checkCalendarVisible()
                .openCalendarOnYear()
                .selectYear(testDataUi.yearRandom)
                .selectMonth(testDataUi.monthRandom)
                .selectDay(testDataUi.dayRandom)
                .setRepeatInterval(testDataUi.repeatIntervalRandom)
                .selectRepeatDay(testDataUi.repeatRandom)
                .selectTag(testDataUi.firstTagRandom)
                .selectTag(testDataUi.secondTagRandom)
                .clickCreate()
                .editDailyTask(testDataUi.titleRandom)
                .checkTitle(testDataUi.titleRandom)
                .checkNotes(testDataUi.noteRandom)
                .checkChecklistSize(2)
                .checkNewChecklistAvailable()
                .checkDifficulty(testDataUi.difficultyRandom)
                .checkDate(testDataUi.dayRandom, testDataUi.monthRandom, testDataUi.yearRandom)
                .checkRepeatInterval(testDataUi.repeatIntervalRandom)
                .checkRepeatDayNotSelected(testDataUi.repeatRandom)
                .checkTag(testDataUi.firstTagRandom)
                .checkTag(testDataUi.secondTagRandom);
    }

    @Test
    @Story("Создание задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание задачи (ToDo) с заполнением всех полей")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void createToDoTaskTest() {
        taskUi
                .createToDoTask()
                .checkModalVisible()
                .setTitle(testDataUi.titleRandom)
                .setNotes(testDataUi.noteRandom)
                .addChecklistItem(testDataUi.firstListItem)
                .addChecklistItem(testDataUi.secondListItem)
                .selectDifficulty(testDataUi.difficultyRandom)
                .openCalendar()
                .checkCalendarVisible()
                .openCalendarOnYear()
                .selectYear(testDataUi.yearRandom)
                .selectMonth(testDataUi.monthRandom)
                .selectDay(testDataUi.dayRandom)
                .selectTag(testDataUi.firstTagRandom)
                .selectTag(testDataUi.secondTagRandom)
                .clickCreate()
                .editToDoTask(testDataUi.titleRandom)
                .checkTitle(testDataUi.titleRandom)
                .checkNotes(testDataUi.noteRandom)
                .checkChecklistSize(2)
                .checkNewChecklistAvailable()
                .checkDifficulty(testDataUi.difficultyRandom)
                .checkDate(testDataUi.dayRandom, testDataUi.monthRandom, testDataUi.yearRandom)
                .checkTag(testDataUi.firstTagRandom)
                .checkTag(testDataUi.secondTagRandom);
    }

    @Test
    @Story("Удаление задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление привычки")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void deleteHabitTaskTest() {
        taskUi
                .createHabitTask()
                .setTitle(testDataUi.titleRandom)
                .setNotes(testDataUi.noteRandom)
                .clickCreate()
                .editHabitTask(testDataUi.titleRandom)
                .checkTitle(testDataUi.titleRandom)
                .checkNotes(testDataUi.noteRandom)
                .clickDeleteButton()
                .confirmDelete()
                .checkTaskCardDeleted(TaskType.HABIT, testDataUi.titleRandom);
    }

    @Test
    @Story("Удаление задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление ежедневного дела")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void deleteDailyTaskTest() {
        taskUi
                .createDailyTask()
                .setTitle(testDataUi.titleRandom)
                .setNotes(testDataUi.noteRandom)
                .clickCreate()
                .editDailyTask(testDataUi.titleRandom)
                .checkTitle(testDataUi.titleRandom)
                .checkNotes(testDataUi.noteRandom)
                .clickDeleteButton()
                .confirmDelete()
                .checkTaskCardDeleted(TaskType.DAILY, testDataUi.titleRandom);
    }

    @Test
    @Story("Удаление задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление задачи (ToDo)")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void deleteToDoTaskTest() {
        taskUi
                .createToDoTask()
                .setTitle(testDataUi.titleRandom)
                .setNotes(testDataUi.noteRandom)
                .clickCreate()
                .editToDoTask(testDataUi.titleRandom)
                .checkTitle(testDataUi.titleRandom)
                .checkNotes(testDataUi.noteRandom)
                .clickDeleteButton()
                .confirmDelete()
                .checkTaskCardDeleted(TaskType.TODO, testDataUi.titleRandom);
    }
}
