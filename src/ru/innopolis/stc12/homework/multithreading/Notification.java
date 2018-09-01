package ru.innopolis.stc12.homework.multithreading;

public class Notification extends Thread {
    private Object monitor;
    private Counter counter;
    private int interval;

    public Notification(Counter counter, int interval) {
        this.counter = counter;
        this.interval = interval;
    }

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            while (true) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (interval > 0 && counter.getCount() % interval == 0) {
                    System.out.println("second passed: " + interval);
                }
            }
        }
    }
}
