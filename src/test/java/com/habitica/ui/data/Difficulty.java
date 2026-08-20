package com.habitica.ui.data;

public enum Difficulty {
    TRIVIAL("Пустяк"),
    EASY("Легко"),
    MEDIUM("Нормально"),
    HARD("Сложно");

    private final String displayName;

    Difficulty(String displayName) {
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
