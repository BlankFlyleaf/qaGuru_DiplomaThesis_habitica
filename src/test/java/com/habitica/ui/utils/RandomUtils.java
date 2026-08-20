package com.habitica.ui.utils;

import com.habitica.ui.data.*;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();
        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }
        return result.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static HabitType getRandomHabitType() {
        HabitType[] values = HabitType.values();
        return values[getRandomInt(0, values.length - 1)];
    }

    public static Difficulty getRandomDifficulty() {
        Difficulty[] values = Difficulty.values();
        return values[getRandomInt(0, values.length - 1)];
    }

    public static Tags getRandomTag() {
        Tags[] values = Tags.values();
        return values[getRandomInt(0, values.length - 1)];
    }

    public static ResetCounter getRandomResetCounter() {
        ResetCounter[] values = ResetCounter.values();
        return values[getRandomInt(0, values.length - 1)];
    }

    public static MonthData getRandomMonth() {
        MonthData[] months = MonthData.values();
        return months[getRandomInt(0, months.length - 1)];
    }

    public static RepeatDay getRandomRepeatDay() {
        RepeatDay[] values = RepeatDay.values();
        return values[getRandomInt(0, values.length - 1)];
    }
}
