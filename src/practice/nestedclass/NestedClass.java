package practice.nestedclass;

import java.util.AbstractList;
import java.util.List;

public class NestedClass {
    public static void main(String[] args) {
        class LocalClass {
            static final int finalInt = 1000;
//            지역클래스는 final이 아닌 정적 멤버를 가질 수 없다.
//            static int staticInt;
            int myInt;
        }

        LocalClass localClass = new LocalClass();
        localClass.myInt = 10;
    }

    private static List<Integer> anonymousClass() {
        return new AbstractList<Integer>() {
            static final int myint = 1000;
            final long myLong = 2000L;

//            익명클래스는 상수변수 이외에는 정적 멤버를 가질 수 없다.
//            public static void staticMethod() { }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Integer get(int index) {
                return null;
            }
        };
    }
}
