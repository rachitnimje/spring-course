package org.halogen.LambdaExpression;

@FunctionalInterface
interface Add {
    int add(int a, int b);
}

//class Calculator implements Add{
//    public int add(int a, int b) {
//        return a + b;
//    }
//}

public class Lambda {
    public static void main(String[] args) {
//        first way
//        Add add = new Add() {
//            public int add(int a, int b) {
//                return a + b;
//            }
//        };

//        second way: Lambda way
        Add add = (a, b) -> a + b;

        System.out.println(add.add(1,2));
    }
}
