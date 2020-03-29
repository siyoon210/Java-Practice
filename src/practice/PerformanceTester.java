package practice;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTester {
    public static double calcPerformance(Runnable runnable) {
        return calcPerformance(runnable, 1000, 100_000);
    }

    public static double calcPerformance(Runnable runnable, int testCaseNumber, int actionIteratorNumber) {
        List<Long> result = new ArrayList<>();

        for (int i = 0; i < testCaseNumber; i++) {
            final long start = System.nanoTime();
            for (int j = 0; j < actionIteratorNumber; j++) {
                runnable.run();
            }
            final long end = System.nanoTime();
            result.add(end - start);
        }

        return result.stream().mapToDouble(r -> r).average().getAsDouble();
    }
}
