package practice.parallelstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPerformance {
    public static void main(String[] args) {
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        calcStreamPerformance(integers);
        calcParallelStreamPerformance(integers);
    }

    private static void calcStreamPerformance(List<Integer> integers) {
        long[] testCase = new long[10];

        for (int i = 0; i < testCase.length; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
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
            for (int j = 0; j < 1000; j++) {
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
