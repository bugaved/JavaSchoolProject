package com.tsystems.utils;

/**
 * Created by bugav on 08.10.2017.
 */
public enum DateTimePatterns {

    DATE_WITHOUT_TIME_SLAHED("dd/MM/yyyy"),
    DATE_WITHOUT_TIME_DOTTED("dd.MM.yyyy"),
    DATE_WITH_TIME("dd.MM.yyyy HH:mm"),
    DATE_WITHOUT_TIME("dd-MM-yyyy"),
    DATE_AMERICA_WITH_TIME("yyyy-MM-dd HH:mm"),
    DATE_WITHOUT_TIME_AMERICAN("yyyy-MM-dd");

    DateTimePatterns(String value) {
        this.value = value;
    }

    String value;

    public String getValue() {
        return value;
    }
}
