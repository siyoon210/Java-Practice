package practice.equals;

//import practice.equals.autovalue.MyClass;

//import practice.equals.intellijdefault.MyClass;

import practice.PerformanceTester;
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

        final double v = PerformanceTester.calcPerformance(() -> myClass1.equals(myClass2));
        System.out.println("calcPerformance(myClass1, myClass2) = " + v);
    }
}
