package com.fastcampus3.businesscard.exam;

public class MyObjectTest {
    public static void main(String[] args) {
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();

        System.out.println(myObject1.toString());
        System.out.println(myObject2.toString());

        myObject1.setNum(5555);

        System.out.println(myObject1.toString());
        System.out.println(myObject2.toString());
    }
}
