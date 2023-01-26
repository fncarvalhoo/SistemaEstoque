package com.project.estoque.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor {

    public static String converterDateForDateAndTimeISO(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        return formatter.format(date) + "T" + converterDateForTime(date);
    }

    public static String converterDateForDateAndTime(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatter.format(date);
    }

    public static String converterDateForDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        return formatter.format(date);
    }

    public static String converterDateForTime(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }

}
