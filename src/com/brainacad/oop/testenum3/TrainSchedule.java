package com.brainacad.oop.testenum3;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Scanner;

public class TrainSchedule {
    private Train[] trains;

    public TrainSchedule(Train[] trains) {
        this.trains = trains;
    }
    public void addTrain(){
        Scanner scanner = new Scanner(System.in);
        int trainNumber = scanner.nextInt();
        String stationDispatch = scanner.next();
        String stationArrival = scanner.next();
        String timeDispatch = scanner.next();
        String timeArrival = scanner.next();
        String[] scheduleDays = scanner.nextLine().trim().split(",");
        DayOfWeek[] days = new DayOfWeek[scheduleDays.length];
        for (int i = 0; i < scheduleDays.length; i++) {
            String day = scheduleDays[i];
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
            days[i] = dayOfWeek;
        }
        Train train = new Train(trainNumber);
        train.setStationDispatch(stationDispatch);
        train.setStationArrival(stationArrival);
        train.setTimeDispatch(timeDispatch);
        train.setTimeArrival(timeArrival);
        train.setDays(days);
        Train[] newTrains = Arrays.copyOf(trains,trains.length+1);
        newTrains[trains.length] = train;
        trains = newTrains;

    }
    public void printTrains(){
        for (Train train : trains) {
            System.out.println(train);
        }
    }
    public void searchTrain(String stationDispatch,String stationArrival,DayOfWeek dayOfWeek){
        for (Train train : trains) {
            DayOfWeek[] days = train.getDays();
            for (DayOfWeek day : days) {
                if (train.getStationDispatch().equals(stationDispatch)&&
                        train.getStationArrival().equals(stationArrival)&&
                        day==dayOfWeek){
                    System.out.println(train);
                }
            }

        }
    }

    class Train{
        private int number;
        private String stationDispatch;
        private String stationArrival;
        private String timeDispatch;
        private String timeArrival;
        private DayOfWeek[] days;

        @Override
        public String toString() {
            return "Train number=" + number +
                    ", stationDispatch='" + stationDispatch + '\'' +
                    ", stationArrival='" + stationArrival + '\'' +
                    ", timeDispatch='" + timeDispatch + '\'' +
                    ", timeArrival='" + timeArrival + '\'' +
                    ", days=" + Arrays.toString(days) +
                    '}';
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getStationDispatch() {
            return stationDispatch;
        }

        public void setStationDispatch(String stationDispatch) {
            this.stationDispatch = stationDispatch;
        }

        public String getStationArrival() {
            return stationArrival;
        }

        public void setStationArrival(String stationArrival) {
            this.stationArrival = stationArrival;
        }

        public String getTimeDispatch() {
            return timeDispatch;
        }

        public void setTimeDispatch(String timeDispatch) {
            this.timeDispatch = timeDispatch;
        }

        public String getTimeArrival() {
            return timeArrival;
        }

        public void setTimeArrival(String timeArrival) {
            this.timeArrival = timeArrival;
        }

        public DayOfWeek[] getDays() {
            return days;
        }

        public void setDays(DayOfWeek[] days) {
            this.days = days;
        }

        public Train(int number) {

            this.number = number;
        }
    }
}
