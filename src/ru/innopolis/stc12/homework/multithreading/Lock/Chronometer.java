package ru.innopolis.stc12.homework.multithreading.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Chronometer extends Thread {
    Condition condition;
    private ReentrantLock locker;
    private Counter counter;
    private int milliseconds;
    private int iterationToStop;


    public Chronometer(Counter counter, int milliseconds, int iterationToStop, ReentrantLock locker) {
        this.counter = counter;
        this.milliseconds = milliseconds;
        this.iterationToStop = iterationToStop;
        this.locker = locker;
        this.condition = locker.newCondition();
    }

    public void a() {
        locker.lock();
        try {
//            Thread.sleep(milliseconds);
            counter.setCount();
            System.out.println(counter.getCount());
            condition.signalAll();
            condition.await(1000, TimeUnit.MILLISECONDS);
        } catch (
                InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            a();
        }
    }
}
