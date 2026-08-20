package com.habitica.ui.data;

public enum ResetCounter {
    DAILY("ежедневное дело"),
    WEEKLY("еженедельно"),
    MONTHLY("ежемесячно");

    private final String displayName;

    ResetCounter(String displayName) {
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
