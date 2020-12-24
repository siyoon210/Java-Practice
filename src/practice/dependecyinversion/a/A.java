package practice.dependecyinversion.a;

import practice.dependecyinversion.b.B;

public class A {
    public void aMethod(B b) {
        System.out.println(b);
    }
}
