package com.habitica.common.data;

public enum Difficulty {
    TRIVIAL("Пустяк", 0.1),
    EASY("Легко", 1),
    MEDIUM("Нормально", 1.5),
    HARD("Сложно", 2);

    private final String displayName;
    private final double priority;

    Difficulty(String displayName, double priority) {
        this.displayName = displayName;
        this.priority = priority;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Double getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
