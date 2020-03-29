package practice.equals;

//import practice.equals.autovalue.MyClass;

//import practice.equals.intellijdefault.MyClass;

import practice.equals.mycustom.MyClass;

//import practice.equals.lombok.MyClass;

import java.util.ArrayList;
import java.util.List;

/**
 * - 인텔리제이 1,520,835.7874
 * - 마이코스튬 1,582,557.3934
 * - 롬  복    1,478,283.6388
 */
public class EqualsTest {
    public static void main(String[] args) {
//        MyClass myClass2 = MyClass.create(MyClass.create(null, 1.0, 1, 1.0, 1, 1.0, 1), 1.0, 1, 1.0, 1, 1.0, 1);
//        MyClass myClass1 = MyClass.create(MyClass.create(null, 1.0, 1, 1.0, 1, 1.0, 1), 1.0, 1, 1.0, 1, 1.0, 1);

        MyClass myClass1 = new MyClass(new MyClass(null, 1.0, 1, 1.0, 1, 1.0, 1), 1.0, 1, 1.0, 1, 1.0, 1);
        MyClass myClass2 = new MyClass(new MyClass(null, 1.0, 1, 1.0, 1, 1.0, 1), 1.0, 1, 1.0, 1, 1.0, 1);
        System.out.println("calcPerformance(myClass1, myClass2) = " + calcPerformance(myClass1, myClass2));
    }

    private static double calcPerformance(MyClass myClass1, MyClass myClass2) {
        List<Long> result = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            final long start = System.nanoTime();
            for (int j = 0; j < 100_000; j++) {
                final boolean equals = myClass1.equals(myClass2);
            }
            final long end = System.nanoTime();

            result.add(end - start);
        }

        return result.stream().mapToDouble(r -> r).average().getAsDouble();
    }
}
