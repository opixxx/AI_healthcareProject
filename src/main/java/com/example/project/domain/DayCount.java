package com.example.project.domain;

public enum DayCount {
    THREE_DAYS(3),
    FOUR_DAYS(4),
    FIVE_DAYS(5);

    private final int days;

    DayCount(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}