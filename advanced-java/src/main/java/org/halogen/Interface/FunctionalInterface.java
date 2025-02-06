package org.halogen.Interface;

// A functional interface can have only 1 declared method

@java.lang.FunctionalInterface
interface Add {
    int add(int a, int b);
}

class Calculator implements Add{
    public int add(int a, int b) {
        return a+b;
    }
}

public class FunctionalInterface {
    public static void main(String[] args) {
        Add add = new Calculator();
        System.out.println(add.add(1,2));
    }
}
