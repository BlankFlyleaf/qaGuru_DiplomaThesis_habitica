package com.habitica.ui.data;

public enum RepeatDay {
    SUNDAY("вс", 0),
    MONDAY("пн", 1),
    TUESDAY("вт", 2),
    WEDNESDAY("ср", 3),
    THURSDAY("чт", 4),
    FRIDAY("пт", 5),
    SATURDAY("сб", 6);

    private final String displayName;
    private final int tabIndex;

    RepeatDay(String displayName, int tabIndex) {
        this.displayName = displayName;
        this.tabIndex = tabIndex;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getTabIndex() {
        return tabIndex;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
