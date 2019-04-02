package practice.templatecallbackpattern;

class MyClass {
    void myMethod(PrintB printB) {
        a();

        printB.b();

        c();
    }

    void a() {
        System.out.println("A");
    }

    void c() {
        System.out.println("C");
    }
}

interface PrintB {
    void b();
}


public class TemplateCallback {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        myClass.myMethod(()-> System.out.println("B1"));
        myClass.myMethod(()-> System.out.println("B2"));
    }
}