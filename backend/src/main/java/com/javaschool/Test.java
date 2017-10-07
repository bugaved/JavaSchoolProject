package com.javaschool;


import com.javaschool.dao.TrainDao;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        TrainDao trainDao = new TrainDao();

        String dateString = "04/09/2017 14:05";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");
        DateTime dt = formatter.parseDateTime(dateString);

        List list = trainDao.getTrainsByStationsAndDate("Novosibirsk", "Vladivostok", dt);

        System.out.println(list.size());

    }

}
