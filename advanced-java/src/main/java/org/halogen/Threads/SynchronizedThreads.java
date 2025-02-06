package org.halogen.Threads;

class Counter {
    int count;

    // adding the synchronized keyword makes the method thread-safe
    public synchronized void increment(){
        count++;
    }
}

public class SynchronizedThreads {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Runnable a = () -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        };

        Runnable b = () -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

        // start the execution of the run() method
        t1.start();
        t2.start();

        // the main method waits till the t1 & t2 joins back after execution
        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}
