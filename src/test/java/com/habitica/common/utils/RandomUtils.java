package com.habitica.common.utils;

import com.habitica.common.data.Difficulty;
import com.habitica.common.data.TaskTags;

import java.security.SecureRandom;
import java.util.Arrays;
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

    public static Difficulty getRandomDifficulty() {
        Difficulty[] values = Difficulty.values();
        return values[getRandomInt(0, values.length - 1)];
    }

    public static TaskTags getRandomTag() {
        TaskTags[] values = TaskTags.values();
        return values[getRandomInt(0, values.length - 1)];
    }

    public static TaskTags getRandomTagExcluding(TaskTags excluded) {
        TaskTags[] values = Arrays.stream(TaskTags.values())
                .filter(tag -> tag != excluded)
                .toArray(TaskTags[]::new);
        return values[getRandomInt(0, values.length - 1)];
    }
}
