package org.halogen.Enum;

enum Status {
    Running, Succes, Failed;
}

public class EnumDemo {
    public static void main(String[] args) {
        Status status = Status.Running;
//        System.out.println(status);
        System.out.println(status.ordinal());

        switch (status) {
            case Running:
                System.out.println("Running");
                break;
            case Succes:
                System.out.println("Succes");
                break;
            case Failed:
                System.out.println("Failed");
                break;

        }
    }
}
