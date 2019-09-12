package practice.enummapenumset;

import java.util.EnumSet;

public class EnumSetTest {
    public static void main(String[] args) {
        EnumSet enumSet1 = EnumSet.noneOf(DayOfWeek.class);
        EnumSet enumSet2 = EnumSet.allOf(DayOfWeek.class);

        System.out.println("enumSet1.size() = " + enumSet1.size());
        System.out.println("enumSet2.size() = " + enumSet2.size());
    }
}
