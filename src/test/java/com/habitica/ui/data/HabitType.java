package com.habitica.ui.data;

public enum HabitType {
    POSITIVE("Полезная"),
    NEGATIVE("Вредная");

    private final String displayName;

    HabitType(String displayName) {
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
