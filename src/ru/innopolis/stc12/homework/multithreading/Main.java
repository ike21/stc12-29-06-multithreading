package ru.innopolis.stc12.homework.multithreading;

public class Main {
    public static void main(String[] args) {
        Object monitor = new Object();
        Counter counter = new Counter();
        Chronometer chronometer = new Chronometer(counter, 1000, 30);

        Notification threadFiveSecond = new Notification(counter, 5);
        Notification threadSevenSecond = new Notification(counter, 7);

        chronometer.setMonitor(monitor);
        threadFiveSecond.setMonitor(monitor);
        threadSevenSecond.setMonitor(monitor);

        threadFiveSecond.setDaemon(true);
        threadSevenSecond.setDaemon(true);

        chronometer.start();
        threadFiveSecond.start();
        threadSevenSecond.start();
    }
}
