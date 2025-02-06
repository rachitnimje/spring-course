package org.halogen.Threads;

//class X implements Runnable{
//    public void run(){
//        for(int i=0; i<10; i++){
//            System.out.println("in X thread");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}

//class Y implements Runnable{
//    public void run(){
//        for(int i=0; i<10; i++){
//            System.out.println("in Y thread");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}

public class RunnableDemo {
    public static void main(String[] args) {
//        Runnable x = new X();
//        Runnable y = new Y();

        // Lambda way
        Runnable x = () -> {
                for(int i=0; i<10; i++){
                    System.out.println("in X thread");
                }
            };

        Runnable y = () -> {
            for(int i=0; i<10; i++){
                System.out.println("in Y thread");
            }
        };

        Thread t1 = new Thread(x);
        Thread t2 = new Thread(y);

        t1.start();
        t2.start();
    }
}
