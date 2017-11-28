package com.tsystems.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Converts strings to date and date times
 */
@Component
public class DateTimeComponent {
    /**
     * Converts string to data time object
     *
     * @param stringDate - string with required date
     * @param pattern - pattern of the date
     * @return object of type DateTime
     */

    public DateTime convertStringToDateTime(String stringDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return formatter.parseDateTime(stringDate);
    }

    /**
     * Converts string to data time object
     *
     * @param stringDate - string with required date
     * @param pattern - pattern of the date
     * @return object of type Date
     */
    public Date convertStringToDate(String stringDate, String pattern) {

        Date date = null;

        try {
            date = new SimpleDateFormat(pattern).parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
