package com.tsystems.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bugav on 08.10.2017.
 */
@Component
public class DateTimeComponent {

    public DateTime convertStringToDateTime(String stringDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return formatter.parseDateTime(stringDate);
    }

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
