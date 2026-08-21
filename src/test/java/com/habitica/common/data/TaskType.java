package com.habitica.common.data;

public enum TaskType {
    HABIT("habit", "привычку"),
    DAILY("daily", "ежедневное дело"),
    TODO("todo", "задачу");

    public final String cssType;
    public final String dropdownTitle;

    TaskType(String cssType, String dropdownTitle) {
        this.cssType = cssType;
        this.dropdownTitle = dropdownTitle;
    }
}