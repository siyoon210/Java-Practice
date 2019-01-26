package practice.foreachvsfor;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForeachVsFor {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
        Integer[] integers = new Integer[100000];

        for (int i = 0; i < 100000; i++) {
//            list.add(i);
            integers[i] = i;
        }

        for (int loop = 0; loop < 10; loop++) {
            long start = System.nanoTime();
//            for (Integer integer : list) {
//                integer++;
//            }
//        for (int i = 0; i < list.size(); i++) {
//            Integer integer = list.get(i);
//            integer++;
//        }

//            for (Integer integer : integers) {
//                integer++;
//            }
            for (int i = 0; i < integers.length; i++) {
                integers[i]++;
            }
            long end = System.nanoTime();

            System.out.println(end - start);
        }

    }
}
