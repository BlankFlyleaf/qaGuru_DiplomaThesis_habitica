package com.habitica.ui.utils;

import com.habitica.ui.data.HabitType;
import com.habitica.ui.data.MonthData;
import com.habitica.ui.data.RepeatDay;
import com.habitica.ui.data.ResetCounter;

import static com.habitica.common.utils.RandomUtils.getRandomInt;

public class UiRandomUtils {

    public static MonthData getRandomMonth() {
        MonthData[] months = MonthData.values();
        return months[getRandomInt(0, months.length - 1)];
    }

    public static RepeatDay getRandomRepeatDay() {
        RepeatDay[] values = RepeatDay.values();
        return values[getRandomInt(0, values.length - 1)];
    }

    public static HabitType getRandomHabitType() {
        HabitType[] values = HabitType.values();
        return values[getRandomInt(0, values.length - 1)];
    }

    public static ResetCounter getRandomResetCounter() {
        ResetCounter[] values = ResetCounter.values();
        return values[getRandomInt(0, values.length - 1)];
    }
}
