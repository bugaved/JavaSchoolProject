package com.tsystems.utils;

/**
 * Created by bugav on 29.11.2017.
 */
public enum ErrorMessages {

    USER_HAS_TICKET_ON_THIS_ROUTE("User has ticket on this route"),
    NO_SUCH_REGISTERED_USER("No such registered user"),
    USER_IS_ALLREADY_REGISTERED("User is allready registered"),
    USER_HAS_FUTURE_DATE("User has future date");

    ErrorMessages(String value) {
        this.value = value;
    }

    String value;

    public String getValue() {
        return value;
    }

}
