package practice.nullcomparetest;

public class NullCompareTest {
    public static void main(String[] args) {
        Integer integer = 1;
        Integer nullInteger = null;

        System.out.println("integer == nullInteger = " + (nullInteger == integer));

        System.out.println("nullInteger.equals(null) = " + integer.equals(null));
    }
}
