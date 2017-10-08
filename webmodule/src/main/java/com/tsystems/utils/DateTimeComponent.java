package com.tsystems.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

/**
 * Created by bugav on 08.10.2017.
 */
@Component
public class DateTimeComponent {


    public DateTime convertStringToDate(String stringDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return formatter.parseDateTime(stringDate);
    }

}
