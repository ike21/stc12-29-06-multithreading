package ru.innopolis.stc12.homework.multithreading.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Notification extends Thread {
    Condition condition;
    private ReentrantLock locker;
    private Counter counter;
    private int interval;

    public Notification(Counter counter, int interval, ReentrantLock locker) {
        this.counter = counter;
        this.interval = interval;
        this.locker = locker;
        this.condition = locker.newCondition();
    }

    @Override
    public void run() {
        while (true) {
            locker.lock();
            try {
                if (interval > 0 && counter.getCount() % interval == 0 && counter.getCount() != 0) {
                    System.out.println("second passed: " + interval);
                }
                condition.await(1000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                locker.unlock();
            }
        }
    }
}

