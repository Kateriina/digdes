package com.koltunova.ekaterina;

import java.util.*;

public class Dates implements DatesToCronConverter{

    public Dates(){}

    @Override
    public String convert(List<String> list) throws DatesToCronConvertException {
        List<Format> formats = new ArrayList<>();
        Collections.sort(list);
        for (String s : list) { formats.add(new Format(s)); }

        Map<String, List<Format>> mapDayOfMonth = new HashMap();
        Map<String, List<Format>> mapMonth = new HashMap();
        Map<String, List<Format>> mapWeekD = new HashMap();
        Map<String, List<Format>> mapHour = new LinkedHashMap<>();

        for (Format format : formats) {
            String dayOfWeek = format.getWeekD();
            if (!mapWeekD.containsKey(dayOfWeek)) mapWeekD.put(dayOfWeek, new ArrayList<>());
            mapWeekD.get(dayOfWeek).add(format);

            String dayOfMonth = format.getDay();
            if (!mapDayOfMonth.containsKey(dayOfMonth)) mapDayOfMonth.put(dayOfMonth, new ArrayList<>());
            mapDayOfMonth.get(dayOfMonth).add(format);

            String month = format.getMonth();
            if (!mapMonth.containsKey(month)) mapMonth.put(month, new ArrayList<>());
            mapMonth.get(month).add(format);

            String hour = format.getHour();
            if (!mapHour.containsKey(hour)) mapHour.put(hour, new ArrayList<>());
            mapHour.get(hour).add(format);
        }

        String secSol = SecForm(formats);
        String minuteSol = MinForm(formats);
        String hourSol = HourForm(mapHour, formats.size());
        String dayOfMonthSol = MonthForm(mapDayOfMonth, formats.size());
        String monthSol = MonthForm(mapMonth, formats.size());
        String dayOfWeekSol = MonthForm(mapWeekD, formats.size());

        String[] resArr = new String[6];

        resArr[0] = (secSol ==null)?"*": secSol;
        resArr[1] = (minuteSol ==null)?"*": minuteSol;
        resArr[2] = (hourSol ==null)?"*": hourSol;
        resArr[3] = (dayOfMonthSol ==null)?"*": dayOfMonthSol;
        resArr[4] = (monthSol ==null)?"*": monthSol;
        resArr[5] = (dayOfWeekSol ==null)?"*": dayOfWeekSol;

        String result = Arrays.toString(resArr)
                .replace(",","")
                .replace("[","'")
                .replace("]","'");

        if (result.equals("'* * * * * *'")) throw new DatesToCronConvertException();

        System.out.println(result);
        return result;
    }

    String MonthForm(Map<String, List<Format>> map, int size) {
        List<Map.Entry<String, List<Format>>> list = new ArrayList<>(map.entrySet());
        int maxLength = 0;

        for (Map.Entry<String, List<Format>> stringListEntry : list) {
            int solutionLength = stringListEntry.getValue().size();
            if (solutionLength > maxLength) {
                maxLength = solutionLength;
                if (maxLength > size/2) return stringListEntry.getKey();
            }
        }
        return null;
    }

    String HourForm(Map <String, List<Format>> map, int size) {
        List<Map.Entry<String, List<Format>>> listHour = new ArrayList<>(map.entrySet());
        int firstHour = 25;
        int timeInterval = 1;
        List<Format> tempList = new ArrayList<>();
        String tempStr = "*";

        for (int i = 0; i < listHour.size(); i++) {
            Map.Entry<String, List<Format>> stringListEntry = listHour.get(i);

            int currentHour = Integer.parseInt(stringListEntry.getKey());

            if (i==0) {
                firstHour = currentHour;
                tempList = stringListEntry.getValue();
                continue;
            }

            if (currentHour-firstHour==timeInterval) {
                tempStr = firstHour + "-" + currentHour;
                tempList.addAll(stringListEntry.getValue());
                timeInterval++;
            }
        }

        if (tempList.size() > size/2) {
            return tempStr;
        }
        else return null;
    }

    String MinForm(List<Format> formats) {
        int period = 0;
        List<Format> tempList = new ArrayList<>();
        String tempStr = "*";

        for (int i = 1; i < formats.size(); i++) {
            int firstMinute = Integer.parseInt(formats.get(i-1).getMin());
            int secondMinute = Integer.parseInt(formats.get(i).getMin());

            if (i==1) {
                period =  secondMinute - firstMinute;
                if (period>1) {
                    tempStr = firstMinute + "/" + period;
                    tempList = new ArrayList<>();
                    tempList.add(formats.get(0));
                    tempList.add(formats.get(1));
                }
            }

            if (i>1 && Math.abs(secondMinute - firstMinute) == period) {
                tempList.add(formats.get(i));
            }
            if (tempList.size() > formats.size()/2) {
                return tempStr;
            }
        }
        return null;
    }

    String SecForm(List<Format> formats) {
        int period = 0;
        List<Format> tempList = new ArrayList<>();
        String tempStr = "*";

        for (int i = 1; i < formats.size(); i++) {
            int firstSec = Integer.parseInt(formats.get(i-1).getSec());
            int secondSec = Integer.parseInt(formats.get(i).getSec());

            if (i==1) {
                period =  secondSec - firstSec;
                if (period>1) {
                    tempStr = firstSec + "/" + period;
                    tempList = new ArrayList<>();
                    tempList.add(formats.get(0));
                    tempList.add(formats.get(1));
                }
            }

            if (i>1 && Math.abs(secondSec - firstSec) == period) {
                tempList.add(formats.get(i));
            }
            if (tempList.size() > formats.size()/2) {
                return tempStr;
            }
        }
        return null;
    }

    @Override
    public String getImplementationInfo() {
        return "ФИО: Колтунова Екатерина Владимировна\n" +
                "Имя класса реализации: " + this.getClass().getName() + "\n" +
                "Пакет: " + this.getClass().getPackage() + "\n" +
                "Ссылка на github: https://github.com/Kateriina/digdes";
    }
}
