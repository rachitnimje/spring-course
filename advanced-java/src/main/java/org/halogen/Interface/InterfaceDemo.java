package org.halogen.Interface;

interface A {
    // by default, the variables declared inside an interface are final and static
    int roll = 12;
    String name = "Rachit";


    // by default, the methods declared inside an interface are public and abstract
    void show();
    void config();
}

interface C {
    double cgpa = 8.58;
    String stream = "CE";


    void display();
}

interface D {
    void random();
}

interface E extends D {

}

class B implements A, C, E {

    @Override
    public void show() {
        System.out.println("In show method");
    }

    @Override
    public void config() {
        System.out.println("In config method");
    }

    @Override
    public void display() {
        System.out.println("In display method");
    }

    @Override
    public void random() {
        System.out.println("In random method");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(A.roll + ": " + A.name);
        a.show();
        a.config();

        C c = new B();
        System.out.println(C.cgpa + " " + C.stream);
        c.display();

        D d = new B();
        d.random();
    }
}
