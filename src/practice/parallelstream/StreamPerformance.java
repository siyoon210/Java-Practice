package practice.parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPerformance {
    public static void main(String[] args) {
        final List<Integer> integers = new ArrayList<>(1_000);

        for (int i = 0; i < 1_000; i++) {
            integers.add(i);
        }

        calcStreamPerformance(integers);
        calcParallelStreamPerformance(integers);
    }

    private static void calcStreamPerformance(List<Integer> integers) {
        long[] testCase = new long[10];

        for (int i = 0; i < testCase.length; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < 10; j++) {
                final List<Integer> evenNumlist = integers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
            }
            long endTime = System.nanoTime();
            testCase[i] = endTime - startTime;
        }

        long sum = 0;
        for (final long l : testCase) {
            sum += l;
            if (sum < 0) {
                System.out.println("------오버플로우 남---- : " + sum);
            }
        }

        System.out.println("calcStreamPerformance : " + sum / testCase.length);
    }

    private static void calcParallelStreamPerformance(List<Integer> integers) {
        long[] testCase = new long[10];

        for (int i = 0; i < testCase.length; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < 10; j++) {
                final List<Integer> evenNumlist = integers.parallelStream().filter(n -> n % 2 == 0).collect(Collectors.toList());
            }
            long endTime = System.nanoTime();
            testCase[i] = endTime - startTime;
        }

        long sum = 0;
        for (final long l : testCase) {
            sum += l;
            if (sum < 0) {
                System.out.println("------오버플로우 남---- : " + sum);
            }
        }

        System.out.println("calcParallelStreamPerformance : " + sum / testCase.length);
    }
}
