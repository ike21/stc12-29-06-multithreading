package ru.innopolis.stc12.homework.multithreading.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        ReentrantLock locker = new ReentrantLock();
        Counter counter = new Counter();
        Chronometer chronometer = new Chronometer(counter, 1000, 10, locker);

        Notification threadFiveSecond = new Notification(counter, 5, locker);
        Notification threadSevenSecond = new Notification(counter, 7, locker);

//        chronometer.setLocker(locker);
//        threadFiveSecond.setLocker(locker);
//        threadSevenSecond.setLocker(locker);
//
//        threadFiveSecond.setDaemon(true);
//        threadSevenSecond.setDaemon(true);

        chronometer.start();
        threadFiveSecond.start();
//        threadSevenSecond.start();
    }
}
