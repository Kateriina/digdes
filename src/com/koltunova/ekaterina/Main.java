package com.koltunova.ekaterina;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    public static String getCron(Date date) {
        String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
        return formatDateByPattern(date, DATE_FORMAT);
    }

    public static void main (String[] args) throws DatesToCronConvertException {
        DatesToCronConverter dates = new Dates();
        System.out.println(dates.getImplementationInfo());

        List<String> dates1 = Arrays.asList(
                "2022-01-25T08:00:00",
                "2022-01-25T08:30:00",
                "2022-01-25T09:00:00",
                "2022-01-25T09:30:00",
                "2022-01-26T08:00:00",
                "2022-01-26T08:30:00",
                "2022-01-26T09:00:00",
                "2022-01-26T09:30:00");
        System.out.println("\nПример 1. ");
        System.out.println(dates1);
        System.out.println("Cron: ");
        dates.convert(dates1);

        List<String> dates2 = Arrays.asList(
                "2022-01-24T19:53:00",
                "2022-01-24T19:54:00",
                "2022-01-24T19:55:00",
                "2022-01-24T19:56:00",
                "2022-01-24T19:57:00",
                "2022-01-24T19:58:00",
                "2022-01-24T19:59:00",
                "2022-01-24T20:00:00",
                "2022-01-24T20:01:00",
                "2022-01-24T20:02:00");
        System.out.println("\nПример 2.");
        System.out.println(dates2);
        System.out.println("Cron: ");
        dates.convert(dates1);

        List<String> dates3 = Arrays.asList(
                "2022-01-24T07:00:00",
                "2022-01-24T07:00:10",
                "2022-01-24T07:00:20",
                "2022-01-24T07:00:30",
                "2022-01-24T07:00:40",
                "2022-01-24T07:00:50",
                "2022-01-24T07:01:00"
                );
        System.out.println("\nПример 3.");
        System.out.println(dates3);
        System.out.println("Cron: ");
        dates.convert(dates3);

        List<String> dates4 = Arrays.asList(
                "2022-01-24T07:10:00",
                "2022-01-24T07:20:00",
                "2022-01-24T07:30:00",
                "2022-01-24T07:40:00",
                "2022-01-24T07:50:00",
                "2022-01-24T08:00:00"
        );
        System.out.println("\nПример 4.");
        System.out.println(dates4);
        System.out.println("Cron: ");
        dates.convert(dates4);

        List<String> dates5 = Arrays.asList(
                "2022-02-24T07:10:00",
                "2022-03-24T07:10:00",
                "2022-04-24T07:10:00"
        );
        System.out.println("\nПример 5.");
        System.out.println(dates5);
        System.out.println("Cron: ");
        dates.convert(dates5);

        List<String> dates6 = Arrays.asList(
                "2022-02-24T07:10:00",
                "2022-06-24T07:10:00",
                "2022-08-24T07:10:00"
        );
        System.out.println("\nПример 6.");
        System.out.println(dates6);
        System.out.println("Cron: ");
        dates.convert(dates6);
    }
}
