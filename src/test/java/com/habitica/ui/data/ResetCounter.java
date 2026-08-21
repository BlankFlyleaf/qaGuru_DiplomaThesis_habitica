package com.habitica.ui.data;

public enum ResetCounter {
    DAILY("ежедневное дело"),
    WEEKLY("еженедельно"),
    MONTHLY("ежемесячно");

    private final String displayName;

    ResetCounter(String ruDisplayName) {
        this.displayName = ruDisplayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
