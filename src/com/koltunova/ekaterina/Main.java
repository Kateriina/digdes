package com.koltunova.ekaterina;

import java.util.*;

public class Main {
    public static void main (String[] args) {
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

                System.out.println(dates1);
    }
}
