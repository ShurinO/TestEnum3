package com.brainacad.oop.testenum3;

import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        TrainSchedule trainSchedule = new TrainSchedule(new TrainSchedule.Train[]{});
        add(trainSchedule);
        add(trainSchedule);
        add(trainSchedule);
        add(trainSchedule);

        //печатаем расписание поездов
        trainSchedule.printTrains();
        //Ищем поезд следования Mykolaiv - Kyiv на понедельник
        trainSchedule.searchTrain("Mykolaiv","Kyiv",DayOfWeek.MONDAY);

    }

    private static void add(TrainSchedule trainSchedule) {
        System.out.println("Введите данные поезда в указанном формате\n------------------------------\n" +
                "XXXX SD SA TD TA D1,D2,...Dn\n" +
                "--------------------------------\n" +
                "где ХХХХ - номер поезда (2343), SD - станция отправления (Николаев), SA - станция прибытия (Киев), TD - время отправления (17:42), TA - время прибытия (07:16)" +
                "D1,D2,...Dn - список дней следования поезда через запятую без пробелов (Sunday,Monday,Wednesday)");
        trainSchedule.addTrain();
    }
}
