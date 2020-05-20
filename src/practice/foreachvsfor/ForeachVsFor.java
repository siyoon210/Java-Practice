package practice.foreachvsfor;

import practice.PerformanceTester;

import java.util.ArrayList;
import java.util.List;

public class ForeachVsFor {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        final int TestCaseNum = 100000;
        final int IteratorNumber = 100;

        final double foreach = PerformanceTester.calcPerformance(() -> {
            for (Integer integer : list) {
                integer++;
            }
        }, TestCaseNum, IteratorNumber);

        final double traditionalFor = PerformanceTester.calcPerformance(() -> {
            for (int i = 0, size = list.size(); i < size; i++) {
                Integer integer = list.get(i);
                integer++;
            }
        }, TestCaseNum, IteratorNumber);

        System.out.println("for-each = " + foreach);
        System.out.println("traditionalFor = " + traditionalFor);
    }
}
