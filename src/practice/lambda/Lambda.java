package practice.lambda;

interface MyInterface {
    abstract int myMethod(int a);
}

public class Lambda {
    public static void main(String[] args) {
        MyInterface mi = getLambda();
        useLambda(mi);
    }

    static MyInterface getLambda() {
        return a -> a * a;
    }

    static void useLambda(MyInterface mi) {
        int i1 = mi.myMethod(3);
        int i2 = mi.myMethod(4);

        System.out.println(i1);
        System.out.println(i2);
    }
}
