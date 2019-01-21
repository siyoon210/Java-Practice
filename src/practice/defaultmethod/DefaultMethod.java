package practice.defaultmethod;

interface MyInterface {
    default void printHello() {
        System.out.println("Hello World :)");
    }
}

class MyClass implements MyInterface {
}

public class DefaultMethod {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.printHello();
    }
}
