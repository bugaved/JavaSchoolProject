package com.tsystems.utils;

import org.springframework.stereotype.Component;

/**
 * Deletes symbol from string, formates string
 */
@Component
public class StringFormatter {
    /**
     * formates string input, deletes required symbol from string
     *
     * @param input - our string
     * @param symbol - symbol required to delete
     * @return object of type string
     */
    public String deleteSymbolFromString(String input, char symbol) {
        return input.replace(symbol, ' ');
    }

}
