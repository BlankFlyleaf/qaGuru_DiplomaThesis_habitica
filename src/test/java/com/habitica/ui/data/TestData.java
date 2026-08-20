package com.habitica.ui.data;

import com.habitica.ui.config.TestConfig;
import com.habitica.ui.utils.RandomUtils;
import org.aeonbits.owner.ConfigFactory;

public class TestData {
    private static final TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

    public static final String username = config.getUsername();
    public static final String password = config.getPassword();
    public static final String mail = config.getMail();
    public static final String boldUsername = config.getBoldUsername();

    public static final String cyrillicUsername = "ТестТестТест";
    public static final String longUsername = "TestTestTestTestTestTestTest";
    public static final String shortPassword = "T";
    public static final String alertText = "Ваша электронная почта, имя пользователя или пароль неверны";
    public static final String sizeUsernameError = "Имя пользователя должно быть от 1 до 20 символов.";
    public static final String langUsernameError = "Имя пользователя может содержать только буквы от a-z, цифры 0-9, дефисы или подчеркивания.";
    public static final String sizePasswordError = "Ваш пароль должен содержать как минимум 8 символов.";

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
    public Tags firstTagRandom;
    public Tags secondTagRandom;
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
