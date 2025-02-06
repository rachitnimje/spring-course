package org.halogen.InnerClass;

class A {
    public void show() {
        System.out.println("In orignal method");
    }
}

abstract class B {
    public void show() {};
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        // we want to give different implementation to the show() method
        // so instead of creating a new class that extends A and overrides the method to give different implementation
        // we can just give the implementation of that method by declaring an inner class while creating the object of that class
        A obj = new A()
        {
            @Override
            public void show() {
                System.out.println("In anonymous inner class method");
            }
        };

        obj.show();

        // This can also be implemented when there is a abstract class and we need to give implementation to the method
        // we can either create a non-abstract class that extends B and give implementation or do this

        B objB = new B() {
            @Override
            public void show() {
                System.out.println("In anonymous inner class method");
            }
        };

        objB.show();
    }
}
