package ru.innopolis.stc12.homework.multithreading;

public class Chronometer extends Thread {
    private Object monitor;
    private Counter counter;
    private int milliseconds;
    private int iterationToStop;


    public Chronometer(Counter counter, int milliseconds, int iterationToStop) {
        this.counter = counter;
        this.milliseconds = milliseconds;
        this.iterationToStop = iterationToStop;
    }

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterationToStop; i++) {
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.setCount();
            System.out.println(counter.getCount());
            synchronized (monitor) {
                monitor.notifyAll();
            }
        }
    }
}
