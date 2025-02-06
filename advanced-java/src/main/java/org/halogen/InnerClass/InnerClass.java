package org.halogen.InnerClass;

class MainClass {
    public void show() {
        System.out.println("Main Class Show");
    }

    class InnerClass1 {
        public void show() {
            System.out.println("Inner Class 1 Show");
        }
    }

    static class InnerClass2 {
        public void show() {
            System.out.println("Inner Class 2 Show");
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        MainClass mc = new MainClass();
        mc.show();

        // since the inner class is non-static, we have to refer to the object of the main class to create the object of inner class
        MainClass.InnerClass1 i1 = mc.new InnerClass1();
        i1.show();

        // when the inner class is static, no need to refer to the object of main class
        MainClass.InnerClass2 i2 = new MainClass.InnerClass2();
        i2.show();
    }
}


