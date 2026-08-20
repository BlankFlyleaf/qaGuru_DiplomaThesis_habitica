package com.habitica.ui.data;

public enum MonthData {
    JANUARY("January", "Jan"),
    FEBRUARY("February", "Feb"),
    MARCH("March", "Mar"),
    APRIL("April", "Apr"),
    MAY("May", "May"),
    JUNE("June", "Jun"),
    JULY("July", "Jul"),
    AUGUST("August", "Aug"),
    SEPTEMBER("September", "Sep"),
    OCTOBER("October", "Oct"),
    NOVEMBER("November", "Nov"),
    DECEMBER("December", "Dec");

    private final String displayName;
    private final String shortName;

    MonthData(String displayName, String shortName) {
        this.displayName = displayName;
        this.shortName = shortName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}