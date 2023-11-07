package com.learning.springsecuritybasic.model.common.character;

public enum Gender {
    FEMALE("f"), MALE("m");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
