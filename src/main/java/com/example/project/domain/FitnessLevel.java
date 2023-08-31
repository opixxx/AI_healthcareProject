package com.example.project.domain;

public enum FitnessLevel {
    BEGINNER("초급"),
    INTERMEDIATE("중급");

    private final String level;

    FitnessLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
