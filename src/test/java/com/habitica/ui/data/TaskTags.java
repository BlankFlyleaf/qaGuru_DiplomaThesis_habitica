package com.habitica.ui.data;

public enum TaskTags {
    WORK("Работа"),
    HEALTH("Здоровье и образ жизни"),
    EXERCISE("Спортивные упражнения"),
    STUDY("Учеба"),
    TEAMWORK("Работа в команде"),
    HOUSEWORK("Домашние дела"),
    CREATIVITY("Творчество");

    private final String displayName;

    TaskTags(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
