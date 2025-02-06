package org.halogen.Threads;

class A extends Thread{
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println("in A thread");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B extends Thread{
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println("in B thread");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        System.out.println(a.getPriority());
        System.out.println(b.getPriority());

        // setting priority only SUGGESTS the scheduler about the urgentness
        // it is not like the thread with max priority will execute first
        b.setPriority(Thread.MAX_PRIORITY);
        a.setPriority(Thread.MIN_PRIORITY);

        a.start();
        b.start();
    }
}
