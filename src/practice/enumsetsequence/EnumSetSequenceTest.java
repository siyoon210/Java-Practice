package practice.enumsetsequence;

import java.util.EnumSet;

enum DayOfWeek {
    MON, TUE, WED, THU, FRI, SAT, SUN
}
public class EnumSetSequenceTest {
    public static void main(String[] args) {
        EnumSet<DayOfWeek> dayOfWeeks = EnumSet.allOf(DayOfWeek.class);
        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            System.out.println("dayOfWeek.toString() = " + dayOfWeek.toString());
        }

        EnumSet<DayOfWeek> dayOfWeeksNoneOf = EnumSet.noneOf(DayOfWeek.class);
        dayOfWeeksNoneOf.add(DayOfWeek.SUN);
        dayOfWeeksNoneOf.add(DayOfWeek.TUE);
        dayOfWeeksNoneOf.add(DayOfWeek.FRI);
        dayOfWeeksNoneOf.add(DayOfWeek.MON);

        for (DayOfWeek dayOfWeek : dayOfWeeksNoneOf) {
            System.out.println("dayOfWeek (None Of) = " + dayOfWeek);
        }
    }
}
