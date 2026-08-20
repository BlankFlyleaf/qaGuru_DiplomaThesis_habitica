package com.habitica.ui.tests;

import com.habitica.ui.data.TaskType;
import com.habitica.ui.data.StaticTestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Owner("BlankFlyleaf")
@Feature("Задачи")
public class TaskTest extends UiTestBase {

    @BeforeEach
    void loginBeforeEachTest() {
        login.openLoginPage()
                .setUsernameValue(StaticTestData.username)
                .setPasswordValue(StaticTestData.password)
                .clickSubmitButton();
    }

    @Test
    @Story("Создание привычки")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание привычки с заполнением всех полей")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void createHabitTaskTest() {
        task
                .createHabitTask()
                .checkModalVisible()
                .setTitle(tD.titleRandom)
                .setNotes(tD.noteRandom)
                .selectHabitType(tD.typeRandom)
                .selectDifficulty(tD.difficultyRandom)
                .selectTag(tD.firstTagRandom)
                .selectTag(tD.secondTagRandom)
                .selectResetCounter(tD.counterRandom)
                .clickCreate()
                .editHabitTask(tD.titleRandom)
                .checkTitle(tD.titleRandom)
                .checkNotes(tD.noteRandom)
                .checkHabitType(tD.typeRandom)
                .checkDifficulty(tD.difficultyRandom)
                .checkTag(tD.firstTagRandom)
                .checkTag(tD.secondTagRandom)
                .checkResetCounter(tD.counterRandom);
    }

    @Test
    @Story("Создание ежедневного дела")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание ежедневного дела с заполнением всех полей")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void createDailyTaskTest() {
        task
                .createDailyTask()
                .checkModalVisible()
                .setTitle(tD.titleRandom)
                .setNotes(tD.noteRandom)
                .addChecklistItem(tD.firstListItem)
                .addChecklistItem(tD.secondListItem)
                .selectDifficulty(tD.difficultyRandom)
                .openCalendar()
                .checkCalendarVisible()
                .openCalendarOnYear()
                .selectYear(tD.yearRandom)
                .selectMonth(tD.monthRandom)
                .selectDay(tD.dayRandom)
                .setRepeatInterval(tD.repeatIntervalRandom)
                .selectRepeatDay(tD.repeatRandom)
                .selectTag(tD.firstTagRandom)
                .selectTag(tD.secondTagRandom)
                .clickCreate()
                .editDailyTask(tD.titleRandom)
                .checkTitle(tD.titleRandom)
                .checkNotes(tD.noteRandom)
                .checkChecklistSize(2)
                .checkNewChecklistAvailable()
                .checkDifficulty(tD.difficultyRandom)
                .checkDate(tD.dayRandom, tD.monthRandom, tD.yearRandom)
                .checkRepeatInterval(tD.repeatIntervalRandom)
                .checkRepeatDayNotSelected(tD.repeatRandom)
                .checkTag(tD.firstTagRandom)
                .checkTag(tD.secondTagRandom);
    }

    @Test
    @Story("Создание задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание задачи с заполнением всех полей")
    @Tags({@Tag("UiTests"), @Tag("Smoke"), @Tag("Regression")})
    public void createToDoTaskTest() {
        task
                .createToDoTask()
                .checkModalVisible()
                .setTitle(tD.titleRandom)
                .setNotes(tD.noteRandom)
                .addChecklistItem(tD.firstListItem)
                .addChecklistItem(tD.secondListItem)
                .selectDifficulty(tD.difficultyRandom)
                .openCalendar()
                .checkCalendarVisible()
                .openCalendarOnYear()
                .selectYear(tD.yearRandom)
                .selectMonth(tD.monthRandom)
                .selectDay(tD.dayRandom)
                .selectTag(tD.firstTagRandom)
                .selectTag(tD.secondTagRandom)
                .clickCreate()
                .editToDoTask(tD.titleRandom)
                .checkTitle(tD.titleRandom)
                .checkNotes(tD.noteRandom)
                .checkChecklistSize(2)
                .checkNewChecklistAvailable()
                .checkDifficulty(tD.difficultyRandom)
                .checkDate(tD.dayRandom, tD.monthRandom, tD.yearRandom)
                .checkTag(tD.firstTagRandom)
                .checkTag(tD.secondTagRandom);
    }

    @Test
    @Story("Удаление задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление привычки")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void deleteHabitTaskTest() {
        task
                .createHabitTask()
                .setTitle(tD.titleRandom)
                .setNotes(tD.noteRandom)
                .clickCreate()
                .editHabitTask(tD.titleRandom)
                .checkTitle(tD.titleRandom)
                .checkNotes(tD.noteRandom)
                .clickDeleteButton()
                .confirmDelete()
                .checkTaskCardDeleted(TaskType.HABIT, tD.titleRandom);
    }

    @Test
    @Story("Удаление задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление ежедневного дела")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void deleteDailyTaskTest() {
        task
                .createDailyTask()
                .setTitle(tD.titleRandom)
                .setNotes(tD.noteRandom)
                .clickCreate()
                .editDailyTask(tD.titleRandom)
                .checkTitle(tD.titleRandom)
                .checkNotes(tD.noteRandom)
                .clickDeleteButton()
                .confirmDelete()
                .checkTaskCardDeleted(TaskType.DAILY, tD.titleRandom);
    }

    @Test
    @Story("Удаление задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление задачи (ToDo)")
    @Tags({@Tag("UiTests"), @Tag("Regression")})
    public void deleteToDoTaskTest() {
        task
                .createToDoTask()
                .setTitle(tD.titleRandom)
                .setNotes(tD.noteRandom)
                .clickCreate()
                .editToDoTask(tD.titleRandom)
                .checkTitle(tD.titleRandom)
                .checkNotes(tD.noteRandom)
                .clickDeleteButton()
                .confirmDelete()
                .checkTaskCardDeleted(TaskType.TODO, tD.titleRandom);
    }
}
