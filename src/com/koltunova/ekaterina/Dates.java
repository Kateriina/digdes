package com.koltunova.ekaterina;

import java.util.List;

public class Dates implements DatesToCronConverter{

    public Dates(){}

    @Override
    public String convert(List<String> dates) throws DatesToCronConvertException {
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
