package com.habitica.ui.data;

import com.habitica.common.data.Difficulty;
import com.habitica.common.data.TaskTags;
import com.habitica.common.utils.RandomUtils;
import com.habitica.ui.utils.UiRandomUtils;

public class DynamicUiTestData {
    public String titleRandom;
    public String noteRandom;
    public String firstListItem;
    public String secondListItem;
    public int repeatIntervalRandom;
    public int dayRandom;
    public int yearRandom;
    public MonthData monthRandom;
    public HabitType typeRandom;
    public Difficulty difficultyRandom;
    public TaskTags firstTagRandom;
    public TaskTags secondTagRandom;
    public ResetCounter counterRandom;
    public RepeatDay repeatRandom;

    public void randomUiVariableGeneration() {
        titleRandom = RandomUtils.getRandomString(10);
        noteRandom = RandomUtils.getRandomString(120);
        firstListItem = RandomUtils.getRandomString(5);
        secondListItem = RandomUtils.getRandomString(5);
        difficultyRandom = RandomUtils.getRandomDifficulty();
        firstTagRandom = RandomUtils.getRandomTag();
        secondTagRandom = RandomUtils.getRandomTag();
        repeatIntervalRandom = RandomUtils.getRandomInt(1, 50);
        dayRandom = RandomUtils.getRandomInt(1, 28);
        yearRandom = RandomUtils.getRandomInt(2020, 2029);

        counterRandom = UiRandomUtils.getRandomResetCounter();
        typeRandom = UiRandomUtils.getRandomHabitType();
        repeatRandom = UiRandomUtils.getRandomRepeatDay();
        monthRandom = UiRandomUtils.getRandomMonth();
    }
}
