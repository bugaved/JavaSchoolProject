package com.tsystems.utils;

import org.springframework.stereotype.Component;

/**
 * Created by bugav on 20.10.2017.
 */
@Component
public class StringFormatter {

    public String deleteSymbolFromString(String input, char symbol) {

        String formattedString = input.replace(symbol, ' ');
        return formattedString;
    }

}
