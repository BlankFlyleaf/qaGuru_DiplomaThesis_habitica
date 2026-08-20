package com.habitica.ui.data;

import com.habitica.ui.utils.RandomUtils;

public class DynamicTestData {
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

    public void randomVariableGeneration() {
        titleRandom = RandomUtils.getRandomString(10);
        noteRandom = RandomUtils.getRandomString(120);
        firstListItem = RandomUtils.getRandomString(5);
        secondListItem = RandomUtils.getRandomString(5);
        typeRandom = RandomUtils.getRandomHabitType();
        difficultyRandom = RandomUtils.getRandomDifficulty();
        firstTagRandom = RandomUtils.getRandomTag();
        secondTagRandom = RandomUtils.getRandomTag();
        counterRandom = RandomUtils.getRandomResetCounter();
        repeatRandom = RandomUtils.getRandomRepeatDay();
        repeatIntervalRandom = RandomUtils.getRandomInt(1, 50);
        dayRandom = RandomUtils.getRandomInt(1, 28);
        monthRandom = RandomUtils.getRandomMonth();
        yearRandom = RandomUtils.getRandomInt(2020, 2029);
    }
}
