package practice.hashcode;

class MyClass {
    int intVale;
    String strVale;
    double doubleValue;

    public MyClass(int intVale, String strVale, double doubleValue) {
        this.intVale = intVale;
        this.strVale = strVale;
        this.doubleValue = doubleValue;
    }
}
public class HashCode {
    public static void main(String[] args) {
        final MyClass myClass1 = new MyClass(10, "siyoon", 10.0);
        System.out.println("myClass1.hashCode() = " + myClass1.hashCode());
        final MyClass myClass2 = new MyClass(10, "siyoon", 10.0);
        System.out.println("myClass2.hashCode() = " + myClass2.hashCode());
    }
}
