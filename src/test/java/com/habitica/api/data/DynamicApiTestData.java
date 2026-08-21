package com.habitica.api.data;

import com.habitica.common.data.Difficulty;
import com.habitica.common.data.TaskTags;
import com.habitica.common.utils.RandomUtils;

public class DynamicApiTestData {
    public String titleRandom;
    public String noteRandom;
    public Difficulty difficultyRandom;
    public TaskTags firstTagRandom;
    public TaskTags secondTagRandom;


    public void randomApiVariableGeneration() {
        titleRandom = RandomUtils.getRandomString(10);
        noteRandom = RandomUtils.getRandomString(120);
        difficultyRandom = RandomUtils.getRandomDifficulty();
        firstTagRandom = RandomUtils.getRandomTag();
        secondTagRandom = RandomUtils.getRandomTag();
    }
}
