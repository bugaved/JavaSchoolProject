package com.tsystems.utils;

/**
 * Created by bugav on 08.10.2017.
 */
public enum DateTimePatterns {

    COMMON_DATE_WITHOUT_TIME_SLAHED("dd/MM/yyyy"),
    COMMON_DATE_WITHOUT_TIME_DOTTED("dd.MM.yyyy"),
    COMMON_DATE_WITHOUT_TIME_AMERICAN("yyyy-MM-dd");

    DateTimePatterns(String value) {
        this.value = value;
    }

    String value;

    public String getValue() {
        return value;
    }
}
